package com.telecom.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.telecom.datavo.OrderVO;
import com.telecom.datavo.ProductModelVO;

public class CustomerOperations {

	public static String getRetId(String userName) {
		Connection con = JDBCConnectionManager.createConnection();
		String ret_id = "";
		try {
			Statement st2 = con.createStatement();
			String query2 = "SELECT * from USER_INFO WHERE USER_ID='"+userName+"'";
			ResultSet rs2 = st2.executeQuery(query2) ;
			while(rs2.next())
			{
				ret_id = rs2.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret_id;
	}

	public static ArrayList<ProductModelVO> GetProductModelListOfRet(
			String action, String ret_id) throws SQLException {
		Connection con  =  JDBCConnectionManager.createConnection();
		ArrayList<ProductModelVO> ProdModListMapped = new ArrayList<ProductModelVO>();
		try {
			Statement st1 = con.createStatement();
			String query1 = "SELECT * from USER_INFO WHERE RET_ID="+ret_id;
			ResultSet rs1 = st1.executeQuery(query1) ;
			ProductModelVO prodModVO = null;
			while(rs1.next())
			{
				prodModVO = new ProductModelVO();
				String prodModId = rs1.getString(10);
				String[] existingIds = prodModId.split(",");
				for(int i=0;i<existingIds.length;i++)
				{
					Statement st2 = con.createStatement();
					String query2 = "SELECT * from PROD_MOD_INFO_TABLE WHERE PROD_MOD_ID='"+existingIds[i]+"'";
					ResultSet rs2 = st2.executeQuery(query2) ;
					while(rs2.next())
					{
						prodModVO = new ProductModelVO();
						prodModVO.setProductModelId(rs2.getString(1));
						prodModVO.setProductModelName(rs2.getString(2));
						prodModVO.setProductModelDesc(rs2.getString(3));
						prodModVO.setProductModelFeature(rs2.getString(4));
						prodModVO.setProductModelPrice(rs2.getString(5));
						prodModVO.setProductModelThreshold(rs2.getInt(6));
						prodModVO.setProductModelQuantity(rs2.getInt(7));
						ProdModListMapped.add(prodModVO);
					}
				}
			}
		} catch (SQLException e) {
				e.printStackTrace();
			}
		finally{
			con.close();
		}
		return ProdModListMapped;
	}
	public static String createCompleteOrder(HttpServletRequest request,
			String ret_id, OrderVO orderVO2, String orderid2) {
		OrderVO orderVo = new OrderVO();
		orderVo.setCustName(request.getParameter("name"));
		orderVo.setCustMailId(request.getParameter("email"));
		orderVo.setOrderAmnt(request.getParameter("amount"));
		orderVo.setPhoneNumb(request.getParameter("phone"));
		orderVo.setProdModId(orderVO2.getProdModId());
		orderVo.setProdName(orderVO2.getProdName());
		orderVo.setProdStatus("ALLOCATED");
		orderVo.setShippmentAddr(request.getParameter("addr"));
		orderVo.setRetId(ret_id);
		orderVo.setQuantity(orderVO2.getQuantity());
		int result = 0;
		Connection con  =  JDBCConnectionManager.createConnection();
		try {
			if(orderid2 == "")
			{
					Statement st2 = con.createStatement();
					String query2 = "SELECT MAX(ORDER_ID) FROM ORDER_TABLE";
					ResultSet rs2 = st2.executeQuery(query2) ;
					int order_id = 0;
					if(rs2!=null){
						while(rs2.next()){
							orderid2 = rs2.getString(1);
							}
						}
					if(orderid2 == null){
						order_id = 1;
					}else{
						order_id = Integer.parseInt(orderid2);
						order_id++;
					}
					orderid2 = Integer.toString(order_id);
			}
		orderVo.setOrderId(orderid2);
		for(int s=0;s<Integer.parseInt(orderVo.getQuantity());s++)
		{
			Statement st = con.createStatement();
			String query = "SELECT MIN(PROD_CODE) FROM ORDER_TABLE WHERE PROD_MOD_ID='"+
					orderVo.getProdModId()+"' and PROD_STATUS='AVAILABLE'";
			ResultSet rs = st.executeQuery(query);
			String minCode = "";
			while(rs.next())
			{
				minCode = rs.getString(1);
			}
				Statement st1 = con.createStatement();
				String query1 = "update ORDER_TABLE SET ORDER_ID='"+orderVo.getOrderId()+
				"' ,RET_ID="+orderVo.getRetId()+", ORDER_AMNT='"+orderVo.getOrderAmnt()+
				"', CUST_NAME='"+orderVo.getCustName()+"', SHIPMENT_ADDR='"+orderVo.getShippmentAddr()+
				"', PHONE_NUMBER='"+orderVo.getPhoneNumb()+
				"', CUST_MAIL='"+orderVo.getCustMailId()+ "' ,PROD_STATUS='"+ orderVo.getProdStatus()+"' WHERE PROD_CODE="+minCode;
				result = st1.executeUpdate(query1);
		} 
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return orderid2;
	}

	public static int updateProdModTable(String prodModId, String sQuantity) throws SQLException {
		Connection con = JDBCConnectionManager.createConnection();
		int result = 0;
		try{
			int quantityToDelete = Integer.parseInt(sQuantity);
			int totalQuantity = 0;
			if(quantityToDelete!=0)
			{
				int quantity = 0;
				Statement st1 = con.createStatement();
				String query1 = "SELECT * from PROD_MOD_INFO_TABLE WHERE PROD_MOD_ID='"+prodModId+"'";
				ResultSet rs1 = st1.executeQuery(query1);
				while(rs1.next())
				{
					quantity = rs1.getInt(7);
				}
				totalQuantity = quantity - quantityToDelete;
				Statement st = con.createStatement();
				String query = "update PROD_MOD_INFO_TABLE SET PROD_MOD_QUANTITY="+totalQuantity+" where PROD_MOD_ID='"+prodModId+"'";
				result = st.executeUpdate(query);
			}
	}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			con.close();
		}
		return result;
	}

	public static int updateOrder(String orderId, String status) {
		Connection con = JDBCConnectionManager.createConnection();
		int result = 0;
		try {
			Statement st = con.createStatement();
			String query1 = "update ORDER_TABLE SET PROD_STATUS='"+status+"' where ORDER_ID='"+orderId+"' AND PROD_STATUS = 'ALLOCATED'";
			result = st.executeUpdate(query1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}

	public static List getOrderDetails(String orderId, String action) {
		Connection con = JDBCConnectionManager.createConnection();
		OrderVO orderVo = new OrderVO();
		ArrayList OrderVOList = new ArrayList();
		try {
			Statement st = con.createStatement();
			String query1 = "";
			if(action.equalsIgnoreCase("SEARCHORDERTOUPDATECUST"))
			{
				query1 = "select * from ORDER_TABLE where ORDER_ID='"+orderId+"'";
			}
			else if(action.equalsIgnoreCase("SEARCHORDERTORAISEDEFECT"))
			{
				query1 = "select * from ORDER_TABLE where ORDER_ID='"+orderId+"' AND (PROD_STATUS='ALLOCATED' OR PROD_STATUS='DISPATCHED')";
			}
			ResultSet rs = st.executeQuery(query1);
			while(rs.next())
			{
				orderVo = new OrderVO();
				orderVo.setCustName(rs.getString(9));
				orderVo.setPhoneNumb(rs.getString(11));
				orderVo.setCustMailId(rs.getString(12));
				orderVo.setShippmentAddr(rs.getString(10));
				orderVo.setProdModId(rs.getString(2));
				orderVo.setProdName(rs.getString(3));
				orderVo.setProdStatus(rs.getString(4));
				orderVo.setOrderAmnt(rs.getString(8));
				orderVo.setOrderId(orderId);
				orderVo.setProdCode(rs.getString(1));
				OrderVOList.add(orderVo);
			}
		} 
	
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return OrderVOList;
	}

	public static int updateCustDetails(HttpServletRequest request, String orderId) {
		int result = 0;
		OrderVO orderVo = new OrderVO();
		orderVo.setCustName(request.getParameter("name"));
		orderVo.setCustMailId(request.getParameter("email"));
		orderVo.setPhoneNumb(request.getParameter("phone"));
		orderVo.setShippmentAddr(request.getParameter("addr"));
		Connection con = JDBCConnectionManager.createConnection();
		Statement st1;
		try {
			st1 = con.createStatement();
			String query1 = "update ORDER_TABLE SET CUST_NAME='"+orderVo.getCustName()+"', SHIPMENT_ADDR='"+orderVo.getShippmentAddr()+
				"', PHONE_NUMBER='"+orderVo.getPhoneNumb()+
				"', CUST_MAIL='"+orderVo.getCustMailId() +"' WHERE ORDER_ID='"+orderId+"'";
			result = st1.executeUpdate(query1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static int raiseDefectOnSelectedProds(String[] prodIds) {
		int result = 0;
		Connection con = JDBCConnectionManager.createConnection();
		Statement st;
		Statement st1;

		try {
			
			for(int i = 0;i<prodIds.length;i++)
			{
				st = con.createStatement();
				String query = "update ORDER_TABLE SET PROD_STATUS='DEFECTPIECE' WHERE PROD_CODE="+prodIds[i];
				result = st.executeUpdate(query);
				
				st1 = con.createStatement();
				String query1 = "select * from ORDER_TABLE where PROD_CODE="+prodIds[i];
				ResultSet rs1= st1.executeQuery(query1);
				OrderVO orderVo = new OrderVO();
				while(rs1.next())
				{
					orderVo.setProdCode(prodIds[i]);
					orderVo.setProdModId(rs1.getString(2));
					orderVo.setProdName(rs1.getString(3));
					orderVo.setProdStatus(rs1.getString(4));
					orderVo.setOrderId(rs1.getString(5));
					orderVo.setRetId(rs1.getString(6));
					orderVo.setOrderAmnt(rs1.getString(8));
					orderVo.setCustName(rs1.getString(9));
					orderVo.setShippmentAddr(rs1.getString(10));
					orderVo.setPhoneNumb(rs1.getString(11));
					orderVo.setCustMailId(rs1.getString(12));
				}
				
				Statement st2 = con.createStatement();
				String query2 = "SELECT MIN(PROD_CODE) FROM ORDER_TABLE WHERE PROD_MOD_ID='"+
								orderVo.getProdModId()+"' and PROD_STATUS='AVAILABLE'";
				ResultSet rs2 = st2.executeQuery(query2);
				
				String minCode = "";
				while(rs2.next())
				{
					minCode = rs2.getString(1);
				}
				
					Statement st3 = con.createStatement();
					String query3 = "update ORDER_TABLE SET ORDER_ID='"+orderVo.getOrderId()+
					"' ,RET_ID="+orderVo.getRetId()+", ORDER_AMNT='"+orderVo.getOrderAmnt()+
					"', CUST_NAME='"+orderVo.getCustName()+"', SHIPMENT_ADDR='"+orderVo.getShippmentAddr()+
					"', PHONE_NUMBER='"+orderVo.getPhoneNumb()+
					"', CUST_MAIL='"+orderVo.getCustMailId()+ "' ,PROD_STATUS='ALLOCATED' WHERE PROD_CODE="+minCode;
					result = st3.executeUpdate(query3);
			}
		}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
	}
}

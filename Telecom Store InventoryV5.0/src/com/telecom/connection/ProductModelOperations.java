package com.telecom.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.telecom.datavo.ProductModelVO;
import com.telecom.datavo.RetailerInfoVO;
import com.telecom.datavo.TheresholdProductsGraphVO;

public class ProductModelOperations {

	public static int createProductModel(ProductModelVO productModelVO) {
		int inserted = 0;
		try {
			Connection con = JDBCConnectionManager.createConnection();
			Statement st = con.createStatement();
			Statement st1 = con.createStatement();
			Statement st3 = con.createStatement();
			String sql = "select max(PROD_MOD_ID) from PROD_MOD_INFO_TABLE";
			ResultSet rs = st1.executeQuery(sql) ;
			String product_mod_id="";
			int prodmod_id = 0;
			if(rs!=null){
				while(rs.next()){
					product_mod_id = rs.getString(1);
					}
				}
			if(product_mod_id == null){
				prodmod_id = 10000;
			}else{
				prodmod_id = Integer.parseInt(product_mod_id);
				prodmod_id=prodmod_id+10000;
			}
			String query = "insert into PROD_MOD_INFO_TABLE values('"+prodmod_id+"','"+
			productModelVO.getProductModelName()+"','"+productModelVO.getProductModelDesc()+"','"+
			productModelVO.getProductModelFeature()+"','"+productModelVO.getProductModelPrice()+"','"+
			productModelVO.getProductModelThreshold()+"','"+productModelVO.getProductModelQuantity()+"');";
			int prod_id = 0;
			int inserted1  = 0;
				try {
					inserted = st.executeUpdate(query);
					for(int i=0;i<productModelVO.getProductModelQuantity();i++)
					{
						prod_id = prodmod_id + (i+1);
						String query1 = "insert INTO ORDER_TABLE(PROD_CODE, PROD_MOD_ID, PROD_NAME, PROD_STATUS) VALUES ("+ prod_id +" ,'"+ prodmod_id+"','"+productModelVO.getProductModelName()+"' ,'AVAILABLE')";
						inserted1 = st3.executeUpdate(query1);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				finally{
					con.close();
				}
			}
		catch(Exception e){
			e.printStackTrace();
		}
		return inserted;
	}

	public static ArrayList<ProductModelVO> GetProductModelList(String action,
			String prodModId) throws SQLException {
		
		Connection con  =  JDBCConnectionManager.createConnection();
		ArrayList<ProductModelVO> ProdModList = new ArrayList<ProductModelVO>();
		try {
			Statement st = con.createStatement();
			String query="";
			if(action.equalsIgnoreCase("SEARCHPRODMODTODELETE") || 
					action.equalsIgnoreCase("SEARCHPRODUCTMODFORUPDATING")){
				query = "SELECT * from PROD_MOD_INFO_TABLE WHERE PROD_MOD_ID='"+prodModId+"'";
			
			}else{
				query = "SELECT * from PROD_MOD_INFO_TABLE";
			}
			ResultSet rs = st.executeQuery(query) ;
			
			ProductModelVO prodModVO = null;
			while(rs.next())
			{
				prodModVO = new ProductModelVO();
				prodModVO.setProductModelId(rs.getString(1));
				prodModVO.setProductModelName(rs.getString(2));
				prodModVO.setProductModelDesc(rs.getString(3));
				prodModVO.setProductModelFeature(rs.getString(4));
				prodModVO.setProductModelPrice(rs.getString(5));
				prodModVO.setProductModelThreshold(rs.getInt(6));
				prodModVO.setProductModelQuantity(rs.getInt(7));
				ProdModList.add(prodModVO);
			}
		} catch (SQLException e) {
				e.printStackTrace();
			}
		finally{
			con.close();
		}
	
		return ProdModList;
	}
	
	
public static void deleteSelectedProduModles(String[] prodModIds) throws SQLException {
		
		Connection con  =  JDBCConnectionManager.createConnection();
		try {
			Statement st = con.createStatement();
			for(int i=0; i<prodModIds.length; i++){
				String query = "DELETE from PROD_MOD_INFO_TABLE WHERE PROD_MOD_ID='"+prodModIds[i]+"'";
				st.executeUpdate(query) ;
			}
		} catch (SQLException e) {
				e.printStackTrace();
			}
		finally{
			con.close();
		}
	}

public static int updateRetailer(ProductModelVO productModel) throws SQLException {
		int result = 0;
		Connection con = JDBCConnectionManager.createConnection();
			try{
				int quantity = 0;
				int totalQuantity = 0;
				if(productModel.getProductModelQuantity()!=0)
				{
					Statement st1 = con.createStatement();
					String query1 = "SELECT * from PROD_MOD_INFO_TABLE WHERE PROD_MOD_ID='"+productModel.getProductModelId()+"'";
					ResultSet rs1 = st1.executeQuery(query1);
					int quantity1 = 0;
					while(rs1.next())
					{
						quantity = rs1.getInt(7);
					}
				}
				totalQuantity = quantity + productModel.getProductModelQuantity();
				Statement st = con.createStatement();
				String query = "update PROD_MOD_INFO_TABLE SET PROD_MOD_NAME='"+productModel.getProductModelName()+"', " +
						"PROD_MOD_DESC='"+productModel.getProductModelDesc()+"',"+
						"PROD_MOD_FEATURE='"+productModel.getProductModelFeature()+"', PROD_MOD_PRICE='"+productModel.getProductModelPrice()+"', " +
						"PROD_MOD_THRESHOLD="+productModel.getProductModelThreshold()+", PROD_MOD_QUANTITY="+totalQuantity+" where PROD_MOD_ID='"+productModel.getProductModelId()+"';";
				result = st.executeUpdate(query);
				Statement st1 = con.createStatement();
				String sql = "select max(PROD_CODE) from ORDER_TABLE where PROD_MOD_ID='"+productModel.getProductModelId()+"';";
				ResultSet rs1 = st1.executeQuery(sql) ;
				String maxProdCode = "";
				while(rs1.next())
				{
					maxProdCode = rs1.getString(1);
				}
				int maxid = Integer.parseInt(maxProdCode);
				int inserted1  = 0;
				int nextProdId = 0;
				try {
					Statement st3 = con.createStatement();
					for(int i=0;i<productModel.getProductModelQuantity();i++)
					{
						nextProdId = maxid + (i+1);
						String query1 = "insert INTO ORDER_TABLE(PROD_CODE, PROD_MOD_ID, PROD_NAME, PROD_STATUS) VALUES ("+ nextProdId +" ,'"+ productModel.getProductModelId()+"','"+productModel.getProductModelName()+"' ,'AVAILABLE')";
						inserted1 = st3.executeUpdate(query1);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				finally{
					con.close();
				}
				
			}
			catch(Exception e){
				e.printStackTrace();
				return 0;
			}
			finally{
				con.close();
			}
			return result;
		}
public static ArrayList<TheresholdProductsGraphVO> fetchTheresholdProducts() throws SQLException
{
			
	int result = 0;
	Connection con = JDBCConnectionManager.createConnection();
	ArrayList<TheresholdProductsGraphVO> ProdModCountList = new ArrayList<TheresholdProductsGraphVO>();
	try
	{
		Statement st = con.createStatement();
		String query="SELECT PROD_MOD_QUANTITY, PROD_MOD_ID,PROD_MOD_THRESHOLD from PROD_MOD_INFO_TABLE "; //where PROD_MOD_QUANTITY<16
		ResultSet rs = st.executeQuery(query) ;
		TheresholdProductsGraphVO prodCount = null;
		while(rs.next())
		{
			String color = null;
			String quantity = rs.getString(1);
			Integer  thresold = Integer.parseInt(rs.getString(3));
			int quant = Integer.parseInt(quantity);
			if(quant >= 5+thresold) //16
				color = "#00FF00";
			else if(quant < 5+thresold && quant > thresold) // 9
				color = "#EBEB0C";
			else if(quant <=thresold) // 4
				color = "#FF0000";
			
			prodCount = new TheresholdProductsGraphVO();
			prodCount.setProdModId(rs.getString(2));
			prodCount.setProdQuantity(quantity);
			prodCount.setColor(color);
			ProdModCountList.add(prodCount);
			
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return null;
	}
	finally
	{
		con.close();
	}
	return ProdModCountList;
}
}

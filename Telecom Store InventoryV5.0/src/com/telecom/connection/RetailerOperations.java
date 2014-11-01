package com.telecom.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.telecom.datavo.ProductModelVO;
import com.telecom.datavo.RetailerInfoVO;

public class RetailerOperations {
	
	public static int createRetailer(RetailerInfoVO retailer) {
		int inserted = 0;
		try {
			Connection con = JDBCConnectionManager.createConnection();
			
			Statement st = con.createStatement();
			Statement st1 = con.createStatement();
			String sql = "select max(RET_ID) from USER_INFO where USER_ROLE='RETAILER';";
			ResultSet rs = st1.executeQuery(sql) ;
			String retailer_id="";
			int ret_id = 0;
			
			if(rs!=null){
				while(rs.next()){
						retailer_id = rs.getString(1);
					}
				}

			if(retailer_id == null){
				 ret_id = 1000;
			}else{
				ret_id = Integer.parseInt(retailer_id);
				ret_id++;
			}

			String query = "insert into USER_INFO values('"+ret_id+"','"+
			retailer.getRetailerName()+"','"+retailer.getEmail()+"','"+
			retailer.getContactNumber()+"','"+retailer.getLicenseNumber()+"','"+
			retailer.getStoreLocation()+"','"+retailer.getAddress()+"','"+retailer.getRole()+"','"+retailer.getEmail()+
				"','','10/13/2013','password"+ret_id+"');";
				try {
					inserted = st.executeUpdate(query);
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

	public static int updateRetailer(RetailerInfoVO retailer) throws SQLException{
	int result = 0;
	Connection con = JDBCConnectionManager.createConnection();
		try{
			Statement st = con.createStatement();
			String query = "update USER_INFO SET USER_NAME='"+retailer.getRetailerName()+"', " +
					"USER_EMAIL='"+retailer.getEmail()+"',"+
					"USER_PHONE="+retailer.getContactNumber()+", USER_LICENSE='"+retailer.getLicenseNumber()+"', " +
					"USER_ID='"+retailer.getEmail()+"', USER_ADDR='"+retailer.getAddress()+"', " +
					"USER_LOC='"+retailer.getStoreLocation()+"' where RET_ID="+retailer.getRetailerNumber()+";";
			result = st.executeUpdate(query);
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

	public static ArrayList<RetailerInfoVO> GetRetailerList(String action, String retId) throws SQLException {
		
		Connection con  =  JDBCConnectionManager.createConnection();
		ArrayList<RetailerInfoVO> RetailerList = new ArrayList<RetailerInfoVO>();
		try {
			Statement st = con.createStatement();
			String query="";
			if(action.equalsIgnoreCase("SEARCHRETAILRSTODELETE") || 
					action.equalsIgnoreCase("SEARCHRETAILRSFORUPDATING") || 
					action.equalsIgnoreCase("SEARCHRETAILRSTOMAP") || 
					action.equalsIgnoreCase("SEARCHRETAILRSTODELETEMAP")){
				query = "SELECT * from USER_INFO WHERE RET_ID="+retId;
			}else{
				query = "SELECT * from USER_INFO WHERE USER_ROLE=\'RETAILER\'";
			}
			ResultSet rs = st.executeQuery(query) ;
			RetailerInfoVO retInfoVO = null;
			while(rs.next())
			{
				retInfoVO = new RetailerInfoVO();
				retInfoVO.setRetailerNumber(Integer.toString(rs.getInt(1)));
				retInfoVO.setRetailerName(rs.getString(2));
				retInfoVO.setEmail(rs.getString(3));
				retInfoVO.setContactNumber(rs.getString(4));
				retInfoVO.setLicenseNumber(rs.getString(5));
				retInfoVO.setStoreLocation(rs.getString(6));
				retInfoVO.setAddress(rs.getString(7));
				RetailerList.add(retInfoVO);
			}
		} catch (SQLException e) {
				e.printStackTrace();
			}
		finally{
			con.close();
		}
		return RetailerList;
	}
	
	public static void deleteSelectedRetailors(String[] retailorIDs) throws SQLException {
		
		Connection con  =  JDBCConnectionManager.createConnection();
		try {
			Statement st = con.createStatement();
			for(int i=0; i<retailorIDs.length; i++){
				String query = "DELETE from USER_INFO WHERE RET_ID="+retailorIDs[i];
				st.executeUpdate(query) ;
			}
		} catch (SQLException e) {
				e.printStackTrace();
			}
		finally{
			con.close();
		}
	}
	public static void mapProductsToRetailer(String[] prodModIds, String ret_Id) throws SQLException {
		int result = 0;
		Connection con = JDBCConnectionManager.createConnection();
		Statement st2 = con.createStatement();
		String query2 = "SELECT * from USER_INFO WHERE RET_ID="+ret_Id;
		ResultSet rs2 = st2.executeQuery(query2) ;
		String existingIds = "";
		while(rs2.next())
		{
			existingIds = rs2.getString(10);
		}
		String ProdsToMap = existingIds;
		for(int i=0;i<prodModIds.length;i++)
		{
			ProdsToMap=ProdsToMap+prodModIds[i]+",";
		}
		//ProdsToMap = ProdsToMap.replace(ProdsToMap.substring(ProdsToMap.length()-1), "");
		try{
			Statement st = con.createStatement();
			String query = "update USER_INFO SET PROD_MOD_ID='"+ProdsToMap+"'"+ " WHERE RET_ID="+ret_Id;
			result = st.executeUpdate(query);
		}catch (SQLException e) {
				e.printStackTrace();
		}
		finally{
			con.close();
		}
	}

	public static ArrayList<ProductModelVO> GetProductModelList(String action,
			String ret_Id) throws SQLException {
		Connection con  =  JDBCConnectionManager.createConnection();
		ArrayList<ProductModelVO> ProdModListAll = new ArrayList<ProductModelVO>();

		try {
			Statement st = con.createStatement();
			String query = "SELECT * from PROD_MOD_INFO_TABLE";
			ResultSet rs = st.executeQuery(query) ;
			String AllProdIds = "";
			while (rs.next()){
				AllProdIds = AllProdIds + rs.getString(1) +",";
			}
			String AllProdModIds[] = AllProdIds.split(",");
			Statement st1 = con.createStatement();
			String query1 = "SELECT * from USER_INFO WHERE RET_ID="+ret_Id;
			ResultSet rs1 = st1.executeQuery(query1) ;
			ProductModelVO prodModVO = null;
			String prodModId = null;
			while(rs1.next())
			{
				prodModVO = new ProductModelVO();
				prodModId = rs1.getString(10);
			}
			
			if(prodModId != null)
			{
				String[] existingIds = prodModId.split(",");
				for(int d=0;d<AllProdModIds.length;d++)
				{
					for(int m=0;m<existingIds.length;m++)
					{
						if(AllProdModIds[d].equals(existingIds[m]))
						{
							AllProdModIds[d] = null;
							break;
						}
					}
				}
			}
			for(int a=0;a<AllProdModIds.length;a++)
			{
				if(AllProdModIds[a] != null)
				{
					Statement st2 = con.createStatement();
					String query2 = "SELECT * from PROD_MOD_INFO_TABLE WHERE PROD_MOD_ID='"+AllProdModIds[a]+"'";
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
						ProdModListAll.add(prodModVO);
					}
				}
			}
		} catch (SQLException e) {
				e.printStackTrace();
			}
		finally{
			con.close();
		}
	
		return ProdModListAll;
	}

	public static ArrayList<ProductModelVO> GetProductModelListOfRet(
			String action, String ret_Id) throws SQLException {
		Connection con  =  JDBCConnectionManager.createConnection();
		ArrayList<ProductModelVO> ProdModListMapped = new ArrayList<ProductModelVO>();
		try {
			Statement st1 = con.createStatement();
			String query1 = "SELECT * from USER_INFO WHERE RET_ID="+ret_Id;
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

	public static void deleteProductsToRetailer(String[] prodModIds,
			String ret_Id) throws SQLException {
		int result = 0;
		Connection con = JDBCConnectionManager.createConnection();
		String ProdsToMap = "";
		for(int i=0;i<prodModIds.length;i++)
		{
			ProdsToMap=ProdsToMap+prodModIds[i]+",";
		}
		try{
			Statement st = con.createStatement();
			String query = "update USER_INFO SET PROD_MOD_ID='"+ProdsToMap+"'"+ "WHERE RET_ID="+ret_Id;
			result = st.executeUpdate(query);
		}catch (SQLException e) {
				e.printStackTrace();
		}
		finally{
			con.close();
		}
	}
}

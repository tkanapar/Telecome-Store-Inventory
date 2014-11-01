package com.telecom.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.telecom.datavo.InventoryManagerInfoVO;

public class InventoryManagerOperations {
	
	
	public static int createInventoryManager(InventoryManagerInfoVO inventoryManager) {
		int inserted = 0;
		try {
			Connection con = JDBCConnectionManager.createConnection();
			
			Statement st = con.createStatement();
			Statement st1 = con.createStatement();
			String sql = "select max(RET_ID) from USER_INFO where USER_ROLE='INVENTORY_MANAGER';";
			ResultSet rs = st1.executeQuery(sql) ;
			int im_id = 1;
			
			if(rs!=null){
					//return 0;
				}else{
					im_id= 1;
				}
			/*if(retailer_id == null){
				 ret_id = 1;
			}else{
				ret_id = Integer.parseInt(retailer_id);
				ret_id++;
			}*/

			String query = "insert into USER_INFO values('"+im_id+"','"+
			inventoryManager.getInventoryManagerName()+"','"+inventoryManager.getEmail()+"','"+
			inventoryManager.getContactNumber()+"','STORE_NULL','STORE_NULL','"+inventoryManager.getAddress()+"','"+
			inventoryManager.getRole()+"','"+inventoryManager.getEmail()+
				"','null','10/13/2013','password"+im_id+"');";
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

	public static ArrayList<InventoryManagerInfoVO> GetInventoryManagerList(String action) throws SQLException {
		
		Connection con  =  JDBCConnectionManager.createConnection();
		ArrayList<InventoryManagerInfoVO> inventoryManagerList = new ArrayList<InventoryManagerInfoVO>();
		try {
			Statement st = con.createStatement();
			String query="";
			if(action.equalsIgnoreCase("VIEWIM")){
				query = "SELECT * from USER_INFO WHERE USER_ROLE='INVENTORY_MANAGER'";
			}
			ResultSet rs = st.executeQuery(query) ;
			
			InventoryManagerInfoVO inventoryMangerVO = null;
			while(rs.next())
			{
				inventoryMangerVO = new InventoryManagerInfoVO();
				inventoryMangerVO.setInventoryManagerName(rs.getString(2));
				inventoryMangerVO.setEmail(rs.getString(3));
				inventoryMangerVO.setContactNumber(rs.getString(4));
				inventoryMangerVO.setAddress(rs.getString(7));
				inventoryManagerList.add(inventoryMangerVO);
			}
		} catch (SQLException e) {
				e.printStackTrace();
			}
		finally{
			con.close();
		}
		return inventoryManagerList;
	}
	
	public static int deleteIMUSER() {
		int result =0;
		Connection con =  JDBCConnectionManager.createConnection();
		try {
			
			Statement st = con.createStatement();
			
				String query = "DELETE from USER_INFO WHERE USER_ROLE='INVENTORY_MANAGER'";
				result = st.executeUpdate(query) ;
				
		}
		catch (SQLException e) {
				e.printStackTrace();
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}

	public static int updateIMDetails(String name, String email, String contact) {
		int result =0;
		Connection con =  JDBCConnectionManager.createConnection();
		try {
			
			Statement st = con.createStatement();
			
				String query = "update USER_INFO SET USER_NAME='"+name+"', USER_EMAIL='"+email+"', USER_PHONE="+
				contact+" WHERE USER_ROLE='INVENTORY_MANAGER'";
				result = st.executeUpdate(query) ;
				
		}
		catch (SQLException e) {
				e.printStackTrace();
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
	 /*public static void main(String args[]){
		 try {
			GetRetailerList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 }*/

	

}

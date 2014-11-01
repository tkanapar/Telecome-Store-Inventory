package com.telecom.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginOperations {
	
	public static String checkLogin(HttpServletRequest request) {
		boolean result = false;
		String numb = "";

		try {
			Connection con = JDBCConnectionManager.createConnection();
			Statement st = con.createStatement();
			String sql = "select * from USER_INFO";
			ResultSet rs = st.executeQuery(sql) ;
			String user = null;
			String pass = null;
			String userName = request.getParameter("user");
			String password = request.getParameter("pwd");
			String role = "";
			while(rs.next()){
				user = rs.getString(3);
				pass = rs.getString(12);
				if(user.equalsIgnoreCase(userName) && pass.equalsIgnoreCase(password)){
					result = true;
					role = rs.getString(8);
				}
			}
			if(result)
			{
				if(role.equalsIgnoreCase("INVENTORY_MANAGER")){
					numb = "IM";
				}
				else if(role.equalsIgnoreCase("RETAILER"))
				{
					numb = "user";
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return numb;
	}

	/*public static void main(String args[]){
		 try {
			GetRetailerList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 }*/
}

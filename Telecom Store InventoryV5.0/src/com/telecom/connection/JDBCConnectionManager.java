package com.telecom.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletResponse;

import com.telecom.datavo.RetailerInfoVO;

public class JDBCConnectionManager {

	static Connection con;
	static Connection createConnection() {
			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver") ;
				con = DriverManager.getConnection("jdbc:odbc:myDB");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return con;
	}
}

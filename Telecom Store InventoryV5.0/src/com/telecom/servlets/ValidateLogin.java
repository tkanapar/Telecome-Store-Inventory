package com.telecom.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.telecom.connection.LoginOperations;
import com.telecom.connection.ProductModelOperations;
import com.telecom.datavo.TheresholdProductsGraphVO;

/**
 * Servlet implementation class ValidateLogin
 */
public class ValidateLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateLogin() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processLogin(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processLogin(request, response);
	}

	private void processLogin(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = getServletConfig().getInitParameter("userName");
		String password = getServletConfig().getInitParameter("password");
		
		String givenUserName = request.getParameter("user");
		String givenPwd = request.getParameter("pwd");
		
		if(userName.equals(givenUserName) && 
				password.equals(givenPwd) && userName.equals("admin")){
			try {
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(100000);
				session.setAttribute("name","Admin");
				 session.setAttribute("userName", givenUserName);
				session.setAttribute("SessionCreated", "TRUE");
				session.setAttribute("lastRequestURL", "/Telecom_Store/homePage.jsp");
				 response.setDateHeader("Expires", 0);  
			     response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");  
			     response.addHeader("Cache-Control", "post-check=0, pre-check=0");  
			     response.setHeader("Pragma", "no-cache");  
			     response.sendRedirect("homePage.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				String result = LoginOperations.checkLogin(request);
				if(result.equalsIgnoreCase("IM"))
				{
				 HttpSession session = request.getSession();
				 session.setMaxInactiveInterval(100000);
				 session.setAttribute("SessionCreated", "TRUE");
				 session.setAttribute("name","InventoryManager");
				 session.setAttribute("userName", givenUserName);
				 session.setAttribute("lastRequestURL", "/Telecom_Store/homePage.jsp");
				 response.setDateHeader("Expires", 0);  
			     response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");  
			     response.addHeader("Cache-Control", "post-check=0, pre-check=0");  
			     response.setHeader("Pragma", "no-cache");  
			     
			     ProductModelOperations getTheresholdProducts = new ProductModelOperations();
				    try 
				    {
						ArrayList<TheresholdProductsGraphVO> prodModCountList = getTheresholdProducts.fetchTheresholdProducts();
						if(prodModCountList!=null )
							{
							HttpSession ThresholdGraph = request.getSession();
							ThresholdGraph.setAttribute("prodModCountList" , prodModCountList);
							response.sendRedirect("homePage.jsp");
							}
						else
						{
							response.sendRedirect("error.jsp");
						}
				     } 
				     catch (SQLException e) 
				     {
						e.printStackTrace();
					 }
				}
				else if(result != ""){
					HttpSession session = request.getSession();
					 session.setMaxInactiveInterval(100000);
					 session.setAttribute("SessionCreated", "TRUE");
    				 session.setAttribute("name","Retailer");
    				 session.setAttribute("userName", givenUserName);
					 session.setAttribute("lastRequestURL", "/Telecom_Store/homePage.jsp");
					 response.setDateHeader("Expires", 0);  
				     response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");  
				     response.addHeader("Cache-Control", "post-check=0, pre-check=0");  
				     response.setHeader("Pragma", "no-cache");  
				     response.sendRedirect("homePage.jsp");
					
					}
				else{
					response.sendRedirect("MyIndex.jsp");
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

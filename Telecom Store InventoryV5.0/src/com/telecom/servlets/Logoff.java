package com.telecom.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logoff
 */
public class Logoff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logoff() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processLogoff(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processLogoff(request, response);
	}

	private void processLogoff(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if(session != null)
			session.removeAttribute("SessionCreated");
			session.invalidate();
		try {
			response.sendRedirect("MyIndex.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

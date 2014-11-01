package com.telecom.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.telecom.connection.CustomerOperations;
import com.telecom.datavo.OrderVO;
import com.telecom.datavo.ProductModelVO;

/**
 * Servlet implementation class RetailerServlet
 */
public class RetailerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetailerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		HttpSession orderSession = request.getSession();
		String userName = (String) orderSession.getAttribute("userName");
		String action = request.getParameter("action");
		String ret_id = CustomerOperations.getRetId(userName);
		if(action.equalsIgnoreCase("GETPRODUCTS")){
			ArrayList<ProductModelVO> productModelArray = new ArrayList<ProductModelVO>(); 
			try{
				productModelArray = CustomerOperations.GetProductModelListOfRet(action, ret_id);
				orderSession.setAttribute("prodModList" , productModelArray);
				request.setAttribute("OPERATION", "GETPRODUCTS");
				response.sendRedirect("ViewAllProductModelToOrder.jsp");
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}else if(action.equalsIgnoreCase("SELECTPRODSTOORDER"))
		{
			String prodIds = request.getParameter("prod_id");
			String quantity = request.getParameter("quantity");
			String prodNames = request.getParameter("prod_name");
			String[] prodModIds = prodIds.split(",");
			String[] numbOfProd = quantity.split(",");
			String[] prodName = prodNames.split(",");
			ArrayList orderList = new ArrayList();
			OrderVO orderVo = null;
			for(int i=0; i<prodModIds.length; i++)
			{
				orderVo = new OrderVO();
				orderVo.setProdModId(prodModIds[i]);
				orderVo.setQuantity(numbOfProd[i]);
				orderVo.setProdName(prodName[i]);
				orderVo.setProdStatus("ALLOCATED");
				orderList.add(orderVo);
				try {
					int result = CustomerOperations.updateProdModTable(prodModIds[i],numbOfProd[i]);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			orderSession.setAttribute("orderVoHalf", orderList);
			try {
				response.sendRedirect("completePlacingOrder.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(action.equalsIgnoreCase("PLACEORDERWITHALLDETAILS"))
		{
			ArrayList<OrderVO> OrderList = new ArrayList<OrderVO>();
			OrderVO orderVO = new OrderVO();
			OrderList = (ArrayList)orderSession.getAttribute("orderVoHalf");
			String orderid = "";
			for(int i=0;i<OrderList.size();i++)
			{
				orderid = CustomerOperations.createCompleteOrder(request, ret_id, OrderList.get(i), orderid);
			}
			if(orderid != null){
				response.sendRedirect("homePage.jsp?OPERATION=PLACEORDERWITHALLDETAILS&result=success&orderId="+orderid);
			}else{
				response.sendRedirect("homePage.jsp?OPERATION=PLACEORDERWITHALLDETAILS&result=failure");
			}			
		}
		else if(action.equalsIgnoreCase("SEARCHTOUPDATESTATUS"))
		{
			String orderId = request.getParameter("orderId");
			int result = 0;
			result = CustomerOperations.updateOrder(orderId, "DISPATCHED");
			if(result != 0){
				response.sendRedirect("homePage.jsp?OPERATION=SEARCHTOUPDATESTATUS&result=success");
			}else{
				response.sendRedirect("homePage.jsp?OPERATION=SEARCHTOUPDATESTATUS&result=failure");
			}			
		}
		else if(action.equalsIgnoreCase("SEARCHORDERTOUPDATECUST")){
			try{
			String orderId = request.getParameter("orderId");
			List orderVoList = new ArrayList();
			orderVoList = CustomerOperations.getOrderDetails(orderId, "SEARCHORDERTOUPDATECUST");
			orderSession.setAttribute("orderVODetails", orderVoList);
			OrderVO ov = new OrderVO();
			orderSession.setAttribute("orderId", orderId);
			response.sendRedirect("ViewDetailsOfOrder.jsp");
		}catch(Exception e){
			e.printStackTrace();
		}
		}
		else if(action.equalsIgnoreCase("UPDATEORDERCUSTDETAILS")){
			int result = 0;
			try{
				String orderId = (String) orderSession.getAttribute("orderId");
				result = CustomerOperations.updateCustDetails(request, orderId);
				if(result != 0){
					response.sendRedirect("homePage.jsp?OPERATION=UPDATEORDERCUSTDETAILS&result=success");
				}else{
					response.sendRedirect("homePage.jsp?OPERATION=UPDATEORDERCUSTDETAILS&result=failure");
				}	
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(action.equalsIgnoreCase("SEARCHORDERTORAISEDEFECT")){
			try{
				String orderId = request.getParameter("defectOrderId");
				List defectOrderVoList = new ArrayList();
				defectOrderVoList = CustomerOperations.getOrderDetails(orderId, "SEARCHORDERTORAISEDEFECT");
				orderSession.setAttribute("orderVOCustDetails", defectOrderVoList);
				orderSession.setAttribute("orderId", orderId);
				response.sendRedirect("ViewDetailsOfOrderToRaiseDefect.jsp");
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(action.equalsIgnoreCase("PRODUCTSRAISEDASDEFECT")){
			try{
				String prodIdsList = request.getParameter("selectedProdids");
				String[] prodIds = prodIdsList.split(",");
				int result = CustomerOperations.raiseDefectOnSelectedProds(prodIds);
				if(result != 0){
					response.sendRedirect("homePage.jsp?OPERATION=PRODUCTSRAISEDASDEFECT&result=success");
				}else{
					response.sendRedirect("homePage.jsp?OPERATION=PRODUCTSRAISEDASDEFECT&result=failure");
				}	
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}

package com.telecom.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.telecom.connection.ProductModelOperations;

import com.telecom.datavo.ProductModelVO;
import com.telecom.datavo.TheresholdProductsGraphVO;


/**
 * Servlet implementation class IMServlet
 */
public class IMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IMServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String action = request.getParameter("action");
		ArrayList<ProductModelVO> productModelArray = new ArrayList<ProductModelVO>(); 
		 ProductModelOperations getTheresholdProducts = new ProductModelOperations();
		HttpSession session = request.getSession();
		if(action.equalsIgnoreCase("CREATEPRODUCTMODEL")){
			ProductModelVO productModelVO = new ProductModelVO();
			productModelVO = productModelVO.createProductModelhelper(request);
			 try{
				 int result = ProductModelOperations.createProductModel(productModelVO);
				 	ArrayList<TheresholdProductsGraphVO> prodModCountList = getTheresholdProducts.fetchTheresholdProducts();
				 	session.setAttribute("prodModCountList" , prodModCountList);
					if(result!=0){
						response.sendRedirect("homePage.jsp?OPERATION=CREATEPRODUCTMODEL&result=success");
					}else{
						response.sendRedirect("homePage.jsp?OPERATION=CREATEPRODUCTMODEL&result=failure");
					}
				} catch (Exception e) {
					response.sendRedirect("homePage.jsp?OPERATION=CREATEPRODUCTMODEL&result=failure");
					e.printStackTrace();
				}
			 }
		//Delete Operation
		else if(action.equalsIgnoreCase("DELETEPRODUCTMODELS")){
		 	
			String selectedProdMod = request.getParameter("selectedProdMod");
			try{
				
			 	
				String ProdModIds[] = selectedProdMod.split(",");
				ProductModelOperations.deleteSelectedProduModles(ProdModIds);
				ArrayList<TheresholdProductsGraphVO> prodModCountList = getTheresholdProducts.fetchTheresholdProducts();
			 	session.setAttribute("prodModCountList" , prodModCountList);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(action.equalsIgnoreCase("VIEWPRODUCTMODELS"))
		{
			try {
				productModelArray = ProductModelOperations.GetProductModelList(action, "0");
				HttpSession ViewProdModSession = request.getSession();
				ViewProdModSession.setAttribute("prodModList" , productModelArray);
				request.setAttribute("OPERATION", "VIEWPRODUCTMODELS");
				response.sendRedirect("ViewAllProductModel.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//Search for Delete operation
		else if(action.equalsIgnoreCase("SEARCHPRODMODTODELETE")){
								
			String prod_mod__id = request.getParameter("prod_mod__id");
			
			ArrayList<ProductModelVO> prodModArray = new ArrayList<ProductModelVO>(); 
			try{
				prodModArray = ProductModelOperations.GetProductModelList(action, prod_mod__id);
				HttpSession ViewProdmodSession = request.getSession();
				ViewProdmodSession.setAttribute("prodModList" , prodModArray);
				request.setAttribute("OPERATION", "SEARCHPRODMODTODELETE");
				response.sendRedirect("ViewAllProductModel.jsp");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//Search for Updating pRODUCT mODELS
		else if(action.equalsIgnoreCase("SEARCHPRODUCTMODFORUPDATING")){
			String prod_mod_id = request.getParameter("prod_mod_id");
			ArrayList<ProductModelVO> ProductModelArray = new ArrayList<ProductModelVO>(); 
			try{
				ProductModelArray = ProductModelOperations.GetProductModelList(action, prod_mod_id);
				HttpSession ViewProdModSession = request.getSession();
				ViewProdModSession.setAttribute("ProdModList" , ProductModelArray);
				request.setAttribute("OPERATION", "SEARCHPRODUCTMODFORUPDATING");
				response.sendRedirect("ViewProductModelForUpdate.jsp");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(action.equalsIgnoreCase("UPDATEPRODUCTMODEL")){
			ProductModelVO productModel = new ProductModelVO();
			productModel = productModel.createProductModelhelper(request);
			int result = 0;
			try {
				result = ProductModelOperations.updateRetailer(productModel);
				ArrayList<TheresholdProductsGraphVO> prodModCountList = getTheresholdProducts.fetchTheresholdProducts();
			 	session.setAttribute("prodModCountList" , prodModCountList);
				if(result!=0){
					response.sendRedirect("homePage.jsp");
				}else{
					response.sendRedirect("homePage.jsp");
				}
			} catch (Exception e) {
				response.sendRedirect("homePage.jsp?OPERATION=UPDATEPRODUCTMODEL&result=failure");
				e.printStackTrace();
			}
		}
		}
		
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}

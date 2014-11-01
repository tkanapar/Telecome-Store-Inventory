package com.telecom.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.telecom.connection.InventoryManagerOperations;
import com.telecom.connection.ProductModelOperations;
import com.telecom.connection.RetailerOperations;
import com.telecom.datavo.InventoryManagerInfoVO;
import com.telecom.datavo.ProductModelVO;
import com.telecom.datavo.RetailerInfoVO;

/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
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
			String action = request.getParameter("action");
			
			// Create Retailer operation
			if(action.equalsIgnoreCase("CREATERETAILER")){
							
				RetailerInfoVO retailer = new RetailerInfoVO();
				retailer = retailer.createRetailerHelper(request);
				
				try {
					int result = RetailerOperations.createRetailer(retailer);
					if(result!=0){
						response.sendRedirect("homePage.jsp?OPERATION=CREATERETAILER&result=success");
					}else{
						response.sendRedirect("homePage.jsp?OPERATION=CREATERETAILER&result=failure");
					}
				} catch (Exception e) {
					response.sendRedirect("homePage.jsp?OPERATION=CREATERETAILER&result=failure");
					e.printStackTrace();
				}
			}
			
			// Update Retailer operation
			else if(action.equalsIgnoreCase("UPDATERETAILER")){
				RetailerInfoVO retailer = new RetailerInfoVO();
				retailer = retailer.createRetailerHelper(request);
				
				int result = 0;
				try {
					result = RetailerOperations.updateRetailer(retailer);
					if(result!=0){
						response.sendRedirect("homePage.jsp?OPERATION=UPDATERETAILER&result=success");
					}else{
						response.sendRedirect("homePage.jsp?OPERATION=UPDATERETAILER&result=failure");
					}
				} catch (Exception e) {
					response.sendRedirect("homePage.jsp?OPERATION=UPDATERETAILER&result=failure");
					e.printStackTrace();
				}
			}
			
			//View Retailer Operation
			else if(action.equalsIgnoreCase("VIEWRETAILER"))
			{
				ArrayList<RetailerInfoVO> retailerArray = new ArrayList<RetailerInfoVO>(); 
				
				try {
					retailerArray = RetailerOperations.GetRetailerList(action, "0");
					HttpSession ViewRetSession = request.getSession();
					ViewRetSession.setAttribute("RetList" , retailerArray);
					request.setAttribute("OPERATION", "viewretailer");
					response.sendRedirect("ViewAllRetailer.jsp");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			//Delete Operation
			else if(action.equalsIgnoreCase("DELETEUSERS")){
				String selectedRet = request.getParameter("selectedRet");
				try{
					String retailorIds[] = selectedRet.split(",");
					RetailerOperations.deleteSelectedRetailors(retailorIds);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
			//Search for Delete operation
			else if(action.equalsIgnoreCase("SEARCHRETAILRSTODELETE")){
				String ret_Id = request.getParameter("ret_id");
				
				ArrayList<RetailerInfoVO> retailerArray = new ArrayList<RetailerInfoVO>(); 
				try{
					retailerArray = RetailerOperations.GetRetailerList(action, ret_Id);
					HttpSession ViewRetSession = request.getSession();
					ViewRetSession.setAttribute("RetList" , retailerArray);
					request.setAttribute("OPERATION", "SEARCHRETAILRSTODELETE");
					response.sendRedirect("ViewAllRetailer.jsp");
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			else if(action.equalsIgnoreCase("SEARCHRETAILRSTOMAP")){
				String ret_Id = request.getParameter("ret_id");
				ArrayList<RetailerInfoVO> retailerArray = new ArrayList<RetailerInfoVO>(); 
				ArrayList<ProductModelVO> productModelArray = new ArrayList<ProductModelVO>(); 
				try{
					retailerArray = RetailerOperations.GetRetailerList(action, ret_Id);
					productModelArray = RetailerOperations.GetProductModelList(action, ret_Id);
					HttpSession mapRet = request.getSession();
					mapRet.setAttribute("RetList" , retailerArray);
					mapRet.setAttribute("prodModList" , productModelArray);
					request.setAttribute("OPERATION", "SEARCHRETAILRSTOMAP");
					response.sendRedirect("ViewAllProductModelToMap.jsp");
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			else if(action.equalsIgnoreCase("MAPPRODUCTMODELS")){
				
				String selectedProdMod = request.getParameter("selectedProdMod");
				String ret_Id = request.getParameter("ret_id");
				try{
					String ProdModIds[] = selectedProdMod.split(",");
					RetailerOperations.mapProductsToRetailer(ProdModIds,ret_Id);
				}catch(Exception e){
					e.printStackTrace();
				}
			}

			
			//Search for Updating Retailors
			else if(action.equalsIgnoreCase("SEARCHRETAILRSFORUPDATING")){
				String ret_Id = request.getParameter("ret_id");
				ArrayList<RetailerInfoVO> retailerArray = new ArrayList<RetailerInfoVO>(); 
				try{
					retailerArray = RetailerOperations.GetRetailerList(action, ret_Id);
					HttpSession ViewRetSession = request.getSession();
					ViewRetSession.setAttribute("RetList" , retailerArray);
					request.setAttribute("OPERATION", "SEARCHRETAILRSFORUPDATING");
					response.sendRedirect("ViewAllRetailerUpdate.jsp");
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
			//  Create Inventory Manager operation
			else if(action.equalsIgnoreCase("CREATEIM")){
				InventoryManagerInfoVO inventoryManager = new InventoryManagerInfoVO();
				inventoryManager = inventoryManager.createIMHelper(request);
				try {
					int result = InventoryManagerOperations.createInventoryManager(inventoryManager);
					if(result!=0){
						response.sendRedirect("homePage.jsp?OPERATION=CREATEIM&result=success");
					}else{
						response.sendRedirect("homePage.jsp?OPERATION=CREATEIM&result=failure");
					}
				} catch (Exception e) {
					response.sendRedirect("homePage.jsp?OPERATION=CREATEIM&result=failure");
					e.printStackTrace();
				}
			}
			
			//  VIEW/UPDATE/DELETE Inventory Manager operation
			else if(action.equalsIgnoreCase("VIEWIM")){
				ArrayList<InventoryManagerInfoVO> imUSERArray = new ArrayList<InventoryManagerInfoVO>(); 
				try {
					imUSERArray = InventoryManagerOperations.GetInventoryManagerList(action);
					HttpSession ViewRetSession = request.getSession();
					ViewRetSession.setAttribute("IMList" , imUSERArray);
					request.setAttribute("OPERATION", "viewInventoryManager");
					response.sendRedirect("ViewAllInventoryManagers.jsp");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			// Delete Inventory Manager Operation
			else if(action.equalsIgnoreCase("DELETEIMUSER")){
				ArrayList<InventoryManagerInfoVO> imUSERArray = new ArrayList<InventoryManagerInfoVO>(); 
				try {
					int result = InventoryManagerOperations.deleteIMUSER();
					if(result!=0){
						response.sendRedirect("homePage.jsp?OPERATION=DELETEIMUSER&result=success");
					}else{
						response.sendRedirect("homePage.jsp?OPERATION=DELETEIMUSER&result=failure");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		// Update Inventory Manager Operation
		else if(action.equalsIgnoreCase("UPDATEIMUSER")){
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String contact = request.getParameter("number");
			
			try {
				int result = InventoryManagerOperations.updateIMDetails(name, email, contact);
				if(result!=0){
					response.sendRedirect("homePage.jsp?OPERATION=UPDATEIMUSER&result=success");
				}else{
					response.sendRedirect("homePage.jsp?OPERATION=UPDATEIMUSER&result=failure");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
		else if(action.equalsIgnoreCase("VIEWPRODUCTMODELSBYADMIN"))
		{
			ArrayList<ProductModelVO> productModelArray = new ArrayList<ProductModelVO>(); 
			
			try {
				productModelArray = ProductModelOperations.GetProductModelList(action, "0");
				HttpSession ViewProdModSession = request.getSession();
				ViewProdModSession.setAttribute("prodModList" , productModelArray);
				request.setAttribute("OPERATION", "VIEWPRODUCTMODELS");
				response.sendRedirect("ViewAllProductModelByAdmin.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(action.equalsIgnoreCase("SEARCHRETAILRSTODELETEMAP")){
			String ret_Id = request.getParameter("ret_id");
			ArrayList<RetailerInfoVO> retailerArray = new ArrayList<RetailerInfoVO>(); 
			ArrayList<ProductModelVO> productModelArray = new ArrayList<ProductModelVO>(); 
			try{
				retailerArray = RetailerOperations.GetRetailerList(action, ret_Id);
				productModelArray = RetailerOperations.GetProductModelListOfRet(action, ret_Id);
				HttpSession mapRet = request.getSession();
				mapRet.setAttribute("RetList" , retailerArray);
				mapRet.setAttribute("prodModList" , productModelArray);
				request.setAttribute("OPERATION", "SEARCHRETAILRSTODELETEMAP");
				response.sendRedirect("ViewAllProductModelToDeleteMap.jsp");
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(action.equalsIgnoreCase("DELETEMAPPRODUCTMODELSRET")){
			String selectedProdMod = request.getParameter("selectedProdMod");
			String ret_Id = request.getParameter("ret_id");
			try{
				String ProdModIds[] = selectedProdMod.split(",");
				RetailerOperations.deleteProductsToRetailer(ProdModIds,ret_Id);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
			
			
			
		
	}
}

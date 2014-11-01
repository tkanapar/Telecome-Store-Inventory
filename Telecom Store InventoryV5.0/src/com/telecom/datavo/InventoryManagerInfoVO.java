package com.telecom.datavo;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public class InventoryManagerInfoVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5062111832152455258L;
	
	private String inventoryManagerName;
	private String email;
	private String contactNumber;
	private String address;
	private String role;
	
	
	
	public String getInventoryManagerName() {
		return inventoryManagerName;
	}

	public void setInventoryManagerName(String inventoryManagerName) {
		this.inventoryManagerName = inventoryManagerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public InventoryManagerInfoVO createIMHelper(HttpServletRequest request){
		InventoryManagerInfoVO manager = new InventoryManagerInfoVO();
		
		manager.setAddress(request.getParameter("addr"));
		manager.setContactNumber(request.getParameter("phone"));
		manager.setEmail(request.getParameter("email"));
		manager.setInventoryManagerName(request.getParameter("name"));
		manager.setRole("INVENTORY_MANAGER");
		
		/*if(request.getParameter("action").equalsIgnoreCase("UPDATEIM")){
			manager.setRetailerNumber(request.getParameter("manager_id"));
		}*/
		return manager;
	}

}

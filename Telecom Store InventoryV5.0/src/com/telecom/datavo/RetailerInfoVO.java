package com.telecom.datavo;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public class RetailerInfoVO implements Serializable {
	
	private String retailerName;
	private String email;
	private String contactNumber;
	private String storeLocation;
	private String licenseNumber;
	private String address;
	private String retailerNumber;
	private String role;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getRetailerNumber() {
		return retailerNumber;
	}
	public void setRetailerNumber(String retailerNumber) {
		this.retailerNumber = retailerNumber;
	}
	public String getRetailerName() {
		return retailerName;
	}
	public void setRetailerName(String retailerName) {
		this.retailerName = retailerName;
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
	public void setContactNumber(String i) {
		this.contactNumber = i;
	}
	public String getStoreLocation() {
		return storeLocation;
	}
	public void setStoreLocation(String storeLocation) {
		this.storeLocation = storeLocation;
	}
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public RetailerInfoVO createRetailerHelper(HttpServletRequest request){
		RetailerInfoVO retailer = new RetailerInfoVO();
		
		retailer.setAddress(request.getParameter("addr"));
		retailer.setContactNumber(request.getParameter("phone"));
		retailer.setEmail(request.getParameter("email"));
		retailer.setLicenseNumber(request.getParameter("licence"));
		retailer.setStoreLocation(request.getParameter("loc"));
		retailer.setRetailerName(request.getParameter("name"));
		retailer.setRole("RETAILER");
		if(request.getParameter("action").equalsIgnoreCase("UPDATERETAILER")){
			retailer.setRetailerNumber(request.getParameter("retailer_id"));
		}
		return retailer;
	}

}

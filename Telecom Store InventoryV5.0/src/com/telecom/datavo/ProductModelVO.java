package com.telecom.datavo;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public class ProductModelVO implements Serializable {
	private String productModelId;
	private String productModelName;
	private String productModelDesc;
	private String productModelFeature;
	private String productModelPrice;
	private int productModelThreshold;
	private int productModelQuantity;
	public String getProductModelId() {
		return productModelId;
	}
	public void setProductModelId(String productModelId) {
		this.productModelId = productModelId;
	}
	public String getProductModelName() {
		return productModelName;
	}
	public void setProductModelName(String productModelName) {
		this.productModelName = productModelName;
	}
	public String getProductModelDesc() {
		return productModelDesc;
	}
	public void setProductModelDesc(String productModelDesc) {
		this.productModelDesc = productModelDesc;
	}
	public String getProductModelFeature() {
		return productModelFeature;
	}
	public void setProductModelFeature(String productModelFeature) {
		this.productModelFeature = productModelFeature;
	}
	public String getProductModelPrice() {
		return productModelPrice;
	}
	public void setProductModelPrice(String productModelPrice) {
		this.productModelPrice = productModelPrice;
	}
	public int getProductModelThreshold() {
		return productModelThreshold;
	}
	public void setProductModelThreshold(int productModelThreshold) {
		this.productModelThreshold = productModelThreshold;
	}
	public int getProductModelQuantity() {
		return productModelQuantity;
	}
	public void setProductModelQuantity(int productModelQuantity) {
		this.productModelQuantity = productModelQuantity;
	}
	public ProductModelVO createProductModelhelper(HttpServletRequest request)
	{
		ProductModelVO productModelVO = new ProductModelVO();
		productModelVO.setProductModelName(request.getParameter("name"));
		productModelVO.setProductModelDesc(request.getParameter("desc"));
		productModelVO.setProductModelFeature(request.getParameter("feature"));
		productModelVO.setProductModelPrice(request.getParameter("price"));
		productModelVO.setProductModelThreshold(Integer.parseInt(request.getParameter("threshold")));
		productModelVO.setProductModelQuantity(Integer.parseInt(request.getParameter("quantity")));
		
		if(request.getParameter("action").equalsIgnoreCase("UPDATEPRODUCTMODEL")){
			productModelVO.setProductModelId(request.getParameter("prod_mod_id"));
		}
		
		return productModelVO;
		
		
	}
	
}

package com.telecom.datavo;

import java.io.Serializable;

public class OrderVO implements Serializable {
	private String prodCode;
	private String prodModId;
	private String prodName;
	private String prodStatus;
	private String orderId;
	private String retId;
	private String orderDate;
	private String orderAmnt;
	private String custId;
	private String custName;
	private String shippmentAddr;
	private String phoneNumb;
	private String custMailId;
	private String quantity;
	
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getProdCode() {
		return prodCode;
	}
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}
	public String getProdModId() {
		return prodModId;
	}
	public void setProdModId(String prodModId) {
		this.prodModId = prodModId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdStatus() {
		return prodStatus;
	}
	public void setProdStatus(String prodStatus) {
		this.prodStatus = prodStatus;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getRetId() {
		return retId;
	}
	public void setRetId(String retId) {
		this.retId = retId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderAmnt() {
		return orderAmnt;
	}
	public void setOrderAmnt(String orderAmnt) {
		this.orderAmnt = orderAmnt;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getShippmentAddr() {
		return shippmentAddr;
	}
	public void setShippmentAddr(String shippmentAddr) {
		this.shippmentAddr = shippmentAddr;
	}
	public String getPhoneNumb() {
		return phoneNumb;
	}
	public void setPhoneNumb(String phoneNumb) {
		this.phoneNumb = phoneNumb;
	}
	public String getCustMailId() {
		return custMailId;
	}
	public void setCustMailId(String custMailId) {
		this.custMailId = custMailId;
	}
	
}

package com.telecom.datavo;

import java.io.Serializable;

public class TheresholdProductsGraphVO implements Serializable
{
	private String prodModId;
	
	private String prodQuantity;
	
	private String color;

	public String getProdModId() {
		return prodModId;
	}

	public void setProdModId(String prodModId) {
		this.prodModId = prodModId;
	}

	public String getProdQuantity() {
		return prodQuantity;
	}

	public void setProdQuantity(String prodQuantity) {
		this.prodQuantity = prodQuantity;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}
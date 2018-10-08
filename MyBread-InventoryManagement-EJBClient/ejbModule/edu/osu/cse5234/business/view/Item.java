package edu.osu.cse5234.business.view;

import java.io.Serializable;

public class Item implements Serializable {
	
	private static final long serialVersionUID = -8834348079171772957L;
	
	private String name;
	private String price;
	private String quantity;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
}

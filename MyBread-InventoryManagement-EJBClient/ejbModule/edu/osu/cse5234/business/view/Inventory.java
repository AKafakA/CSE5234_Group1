package edu.osu.cse5234.business.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Inventory implements Serializable {
	
	private static final long serialVersionUID = 509788171103225953L;
	private List<Item> itemList;
	
	public Inventory() {
		
	}
	
	public Inventory(List<Item> itemList) {
		this.itemList = itemList;
	}

	public List<Item> getItemList() {
		return this.itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	
	public List<Item> getEmptyItemList() {
		List<Item> result = new ArrayList<Item>();
		for (Item item : itemList) {
			Item newItem = new Item();
			
			newItem.setName(item.getName());
			newItem.setPrice(item.getPrice());
			newItem.setQuantity(item.getPrice());
			
			result.add(newItem);
		}
		return result;
	}
}

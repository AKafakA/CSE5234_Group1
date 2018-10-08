package edu.osu.cse5234.business.view;

import java.util.Collection;

public interface InventoryService {
	
	public Inventory getAvailableInventory();
	
	public boolean validateQuantity(Collection<Item> items);
	
	public boolean updateInventory(Collection<Item> items);
}

package edu.osu.cse5234.business;

import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.Item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class InventoryServiceBean
 */
@Stateless
@Remote(InventoryService.class)
public class InventoryServiceBean implements InventoryService {
	
	private List<Item> items = new ArrayList<Item>();
	
    public InventoryServiceBean() {
    	items = null;
    }

	@Override
	public Inventory getAvailableInventory() {
		items = new ArrayList<Item>();
		
		Item whiteBread = new Item();
		Item wheatBread = new Item();
		Item raisinBread = new Item();
		Item oatBread = new Item();
		Item honeyWheatBread = new Item();
		
		whiteBread.setName("White Bread");
		wheatBread.setName("Wheat Bread");
		raisinBread.setName("Raisin Bread");
		oatBread.setName("Oat Bread");
		honeyWheatBread.setName("Honey Wheat Bread");
		
		whiteBread.setPrice("3.00");
		wheatBread.setPrice("4.00");
		raisinBread.setPrice("3.50");
		oatBread.setPrice("3.75");
		honeyWheatBread.setPrice("4.50");
		
		whiteBread.setQuantity("");
		wheatBread.setQuantity("");
		raisinBread.setQuantity("");
		oatBread.setQuantity("");
		honeyWheatBread.setQuantity("");
		
		items.add(whiteBread);
		items.add(wheatBread);
		items.add(raisinBread);
		items.add(oatBread);
		items.add(honeyWheatBread);
		
		return new Inventory(items);
	}

	@Override
	public boolean validateQuantity(Collection<Item> items) {
		/*for (Item orderItem : items) {
			if (Integer.parseInt(orderItem.getQuantity()) > 0) {
				for (Item inventoryItem : items) {
					if (orderItem.getName().equals(inventoryItem.getName())) {
						// To Do
					}
				}
			}
		}*/
		return true;
	}

	@Override
	public boolean updateInventory(Collection<Item> items) {
		// Update the inventory
		// TODO: Also update the database to decrease quantities correspondingly
		/*for (Item orderItem : items) {
			int orderQuantity = orderItem.getQuantity().equals("") ? 0 : Integer.parseInt(orderItem.getQuantity());
			if (orderQuantity > 0) {
				for (Item inventoryItem : items) {
					if (orderItem.getName().equals(inventoryItem.getName())) {
						int inventoryQuantity =  inventoryItem.getQuantity().equals("") ? 0 : Integer.parseInt(inventoryItem.getQuantity());
						inventoryItem.setQuantity(Integer.toString(inventoryQuantity - orderQuantity));
						System.out.println(inventoryItem.getName() + ". New quantity: " +  inventoryItem.getQuantity());
					}
				}
			}
		}*/
		return true;
	}
}

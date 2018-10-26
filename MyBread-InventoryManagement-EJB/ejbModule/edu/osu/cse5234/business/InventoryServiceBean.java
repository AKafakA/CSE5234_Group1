package edu.osu.cse5234.business;

import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.Item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class InventoryServiceBean
 */
@Stateless
@Remote(InventoryService.class)
public class InventoryServiceBean implements InventoryService {
	
	@PersistenceContext
	private EntityManager entityManager;
	private List<Item> items = new ArrayList<Item>();
	private final String MY_QUERY = "Select i from Item i";
	

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Inventory getAvailableInventory() {	
		items = entityManager.createQuery(MY_QUERY, Item.class).getResultList();
		return new Inventory(items);
	}

	@Override
	public boolean validateQuantity(Collection<Item> items) {
		for (Item orderItem : items) {
			if (orderItem.getQuantity() > 0) {
				Inventory inventory = getAvailableInventory();
				for (Item inventoryItem : inventory.getItemList()) {
					if (orderItem.getName().equals(inventoryItem.getName())) {
						if (orderItem.getQuantity() > inventoryItem.getQuantity()){
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	@Override
	public boolean updateInventory(Collection<Item> items) {
		// Update the inventory
		// TODO: Also update the database to decrease quantities correspondingly
		for (Item orderItem : items) {
			if (orderItem.getQuantity() > 0) {
				Inventory inventory = getAvailableInventory();
				for (Item inventoryItem : inventory.getItemList()) {
					if (orderItem.getName().equals(inventoryItem.getName())) {
							int newQuantity = inventoryItem.getQuantity() - orderItem.getQuantity();
							int id = inventoryItem.getId();
							if (orderItem.getQuantity() > inventoryItem.getQuantity()){
								return false;
							} else {
								entityManager.createQuery(String.format("update Item set quantity = %d where id=1", newQuantity , id), Item.class) 
							     .executeUpdate();
							}
						}
					}
				}
			}
		entityManager.flush();
		return true;
	}
}

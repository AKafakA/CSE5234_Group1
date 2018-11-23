package edu.osu.cse5234.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryUpdater {
	public static void main(String[] args) {
		System.out.println("Starting Inventory Update ...");
		try {
			Connection conn = createConnection();
			Collection<Integer> newOrderIds = getNewOrders(conn);
			Map<Integer, Integer> orderedItems = getOrderedLineItems(newOrderIds, conn);
			udpateInventory(orderedItems, conn);
			udpateOrderStatus(newOrderIds, conn);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Connection createConnection() throws SQLException, ClassNotFoundException {
		Class.forName("org.h2.Driver");
		Connection conn = (Connection) DriverManager.getConnection("jdbc:h2:~/MyBread", "sa", "");
		return conn;
	}

	private static Collection<Integer> getNewOrders(Connection conn) throws SQLException {
		Collection<Integer> orderIds = new ArrayList<Integer>();
		ResultSet rset = ((java.sql.Connection) conn).createStatement().executeQuery(
                     "select ID from CUSTOMER_ORDER where STATUS = 'New'");
		while (rset.next()) {
			orderIds.add(new Integer(rset.getInt("ID")));
		}
		return orderIds;
	}

	private static Map<Integer, Integer> getOrderedLineItems(Collection<Integer> newOrderIds,
                Connection conn)  throws SQLException {
		// TODO Auto-generated method stub
		// This method returns a map of two integers. The first Integer is item ID, and 
                 // the second is cumulative requested quantity across all new orders
		Map<Integer, Integer> requestMap = new HashMap<>();
		ResultSet rset = ((java.sql.Connection) conn).createStatement().executeQuery(
				"select ITEM_NUMBER, QUANTITY, CUSTOMER_ORDER_ID_FK from CUSTOMER_ORDER_LINE_ITEM");
		
		while(rset.next()) {
			int custOrderID = rset.getInt("CUSTOMER_ORDER_ID_FK");
			int itemId = rset.getInt("ITEM_NUMBER");
			int quantity = rset.getInt("QUANTITY");
			if(newOrderIds.contains(custOrderID)) {
				requestMap.put(itemId, requestMap.getOrDefault(itemId, 0) + quantity);
			}
		}
		return requestMap;
	}

	private static void udpateInventory(Map<Integer, Integer> orderedItems, 
                Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		ResultSet itemSet = ((java.sql.Connection) conn).createStatement().executeQuery(
				"select ITEM_NUMBER, AVAILABLE_QUANTITY from ITEM");	
		while(itemSet.next()) {
			int itemId = itemSet.getInt("ITEM_NUMBER");
			int availableQuantity = itemSet.getInt("AVAILABLE_QUANTITY");
			
			if (orderedItems.containsKey(itemId)) {
				if(availableQuantity <= orderedItems.get(itemId)) {
				int newQuantity = orderedItems.get(itemId) - orderedItems.get(itemId);
				((java.sql.Connection) conn).createStatement().executeQuery(
						String.format("update ITEM set AVAILABLE_QUANTITY = %d where ITEM_NUMBER = %d", newQuantity, itemId));
				}
				else {
					System.out.println("not enough quantity for item with id " + itemId);
				}
			}
		}

	}

	private static void udpateOrderStatus(Collection<Integer> newOrderIds, 
                Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		List<Integer> newOrders =  new ArrayList<>(newOrderIds);
		for (Integer id : newOrders) {
			((java.sql.Connection) conn).createStatement().executeUpdate(
					String.format("update CUSTOMER_ORDER set Status = 'Old' where ID = %d", id));
			}
		}
}
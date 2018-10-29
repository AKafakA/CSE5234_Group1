package edu.osu.cse5234.business;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.WebServiceRef;

import com.chase.payment.CreditCardPayment;
import com.chase.payment.PaymentProcessorService;

import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;
import edu.osu.cse5234.controller.Order;
import edu.osu.cse5234.controller.PaymentInfo;
import edu.osu.cse5234.model.LineItem;
import edu.osu.cse5234.util.ServiceLocator;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean {
	@PersistenceContext
	private EntityManager entityManager;
    
	@WebServiceRef(wsdlLocation = 
    	       "http://localhost:9080/ChaseBankApplication/PaymentProcessorService?wsdl")
    private PaymentProcessorService service;

    public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
     * Default constructor. 
     */
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    }

    public String processOrder(Order order) throws IllegalArgumentException{
    	InventoryService inventoryService = ServiceLocator.getInventoryService();
    	List<LineItem> selledItems =  order.getLineItems();
    	CreditCardPayment creditCardPayment = createCreditCardPayment(order.getPayment());
    	String paymentResponse = service.getPaymentProcessorPort().processPayment(creditCardPayment); 
    	
    	int port = Integer.parseInt(paymentResponse);
    	
    	if(port < 0 ) {
    		return "Payment did not go through!";
    	}else {
    		order.getPayment().setConfirmationNumber(paymentResponse);
    	}
    	
    	if (inventoryService.updateInventory(lineItemsToItems(selledItems))) {
        	this.entityManager.persist(order);
        	this.entityManager.flush();
        	ServiceLocator.getInventoryService().updateInventory(lineItemsToItems(order.getLineItems()));
        	int max = 9999999;
        	int min = 1000000;
        	Random rand = new Random();
        	int randomNumber = rand.nextInt(max - min + 1) + min;
        	return String.valueOf(randomNumber);
    	} else {
    		return "Sorry, no enough items";
    	}

    }
    
    private CreditCardPayment createCreditCardPayment(PaymentInfo payment) {
    	CreditCardPayment creditCardPayment = new CreditCardPayment();
    	
    	creditCardPayment.setCardHolderName(payment.getCardHolderName());
    	creditCardPayment.setCreditCardNumber(payment.getCreditCardNumber());
    	creditCardPayment.setCvvCode(payment.getCvvCode());
    	creditCardPayment.setExpirationDate(payment.getExpirationDate());
    	
    	return creditCardPayment;
    }
    
    public boolean validateItemAvailability(Order order) {
    	InventoryService inventoryService = ServiceLocator.getInventoryService();
    	return inventoryService.validateQuantity(lineItemsToItems(order.getLineItems()));
    }
    
    private List<Item> lineItemsToItems(List<LineItem> lineItems) {
    	List<Item> items = new ArrayList<>();
    	
    	for(LineItem lt : lineItems) {
    		Item newItem = new Item();
    		newItem.setName(lt.getItemName());
    		newItem.setQuantity(lt.getQuantity());
    		items.add(newItem);
    	}
    	
    	return items;
    		
    }
}

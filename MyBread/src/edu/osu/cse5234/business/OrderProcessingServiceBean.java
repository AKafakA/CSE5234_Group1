package edu.osu.cse5234.business;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.json.Json;
import javax.json.JsonObject;
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

import com.ups.shipping.client.ShippingInitiationClient;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
@Resource(name="jms/emailQCF", lookup="jms/emailQCF", type=ConnectionFactory.class)
public class OrderProcessingServiceBean {
	@PersistenceContext
	private EntityManager entityManager;
    
	//Payment
	@WebServiceRef(wsdlLocation = 
    	       "http://localhost:9080/ChaseBankApplication/PaymentProcessorService?wsdl")
    private PaymentProcessorService service;
	//Shipping
	private static String shippingResourceURI = "http://localhost:9080/UPS/jaxrs";
	//Email Notification
	@Inject
	@JMSConnectionFactory("java:comp/env/jms/emailQCF")
	private JMSContext jmsContext;

	@Resource(lookup="jms/emailQ")
	private Queue queue;

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
    	
    	//shipping
		ShippingInitiationClient shippingInitiationClient = new ShippingInitiationClient(shippingResourceURI);
		    		
		JsonObject responseJson = shippingInitiationClient.invokeInitiateShipping(arrangeShippingRequest(order));

		System.out.println("UPS accepted request? " + responseJson.getBoolean("Accepted"));
		System.out.println("Shipping Reference Number: " +  responseJson.getInt("ShippingReferenceNumber"));
		
		//Notification
		notifyUser(order.getCustomerEmail());
		
		//update inventory
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
    
    private JsonObject arrangeShippingRequest(Order order) {
    	return Json.createObjectBuilder()
    			.add("Organization", "MyBread LLC.")
    			.add("OrderRefId", order.getId())
    			.add("Zip", order.getShipping().getZip())
    			.add("ItemsNumber", order.getLineItems().size())
    			.build();
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
    
    private void notifyUser(String customerEmail) {
    	String message = customerEmail + ":" +
    	       "Your order was successfully submitted. " + 
    	     	"You will hear from us when items are shipped. " + 
    	      	new Date();
    	System.out.println("\nNotificaton\n===\n");
    	System.out.println("Sending message: " + message);
    	jmsContext.createProducer().send(queue, message);
    	System.out.println("Message Sent!");
    }
}

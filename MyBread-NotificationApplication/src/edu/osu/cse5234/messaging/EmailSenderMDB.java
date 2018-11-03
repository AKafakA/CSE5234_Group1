package edu.osu.cse5234.messaging;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: EmailSenderMDB
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		})
public class EmailSenderMDB implements MessageListener {

    /**
     * Default constructor. 
     */
    public EmailSenderMDB() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        // TODO Auto-generated method stub
    	try {
			System.out.println("MDB: " + 
                     ((TextMessage) message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
    }

}

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class EmailProcessingServlet
 */
@WebServlet("/processEmail") 

public class EmailProcessingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	@JMSConnectionFactory("jms/emailQCF")
	private JMSContext jmsContext;

	@Resource(lookup="jms/emailQ")
	private Queue queue;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailProcessingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Receiving message...");
		PrintWriter out = response.getWriter();
		Message message = jmsContext.createConsumer(queue).receive(5000);
		if(message != null && message instanceof TextMessage) {
		         TextMessage textMessage = (TextMessage) message;
		         try {
		            System.out.println("Received: " + textMessage.getText());
		            out.println("Received: " + textMessage.getText());
		         } catch (JMSException e) {
		            out.println("Error: " + e.getMessage());
		         }
		} else {
		        System.out.println("No or unknown message");
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

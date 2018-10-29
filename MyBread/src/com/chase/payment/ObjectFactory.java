
package com.chase.payment;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.chase.payment package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ProcessPaymentResponse_QNAME = new QName("http://payment.chase.com/", "processPaymentResponse");
    private final static QName _Ping_QNAME = new QName("http://payment.chase.com/", "ping");
    private final static QName _ProcessPayment_QNAME = new QName("http://payment.chase.com/", "processPayment");
    private final static QName _PingResponse_QNAME = new QName("http://payment.chase.com/", "pingResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.chase.payment
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ProcessPaymentResponse }
     * 
     */
    public ProcessPaymentResponse createProcessPaymentResponse() {
        return new ProcessPaymentResponse();
    }

    /**
     * Create an instance of {@link Ping }
     * 
     */
    public Ping createPing() {
        return new Ping();
    }

    /**
     * Create an instance of {@link ProcessPayment }
     * 
     */
    public ProcessPayment createProcessPayment() {
        return new ProcessPayment();
    }

    /**
     * Create an instance of {@link PingResponse }
     * 
     */
    public PingResponse createPingResponse() {
        return new PingResponse();
    }

    /**
     * Create an instance of {@link CreditCardPayment }
     * 
     */
    public CreditCardPayment createCreditCardPayment() {
        return new CreditCardPayment();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcessPaymentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.chase.com/", name = "processPaymentResponse")
    public JAXBElement<ProcessPaymentResponse> createProcessPaymentResponse(ProcessPaymentResponse value) {
        return new JAXBElement<ProcessPaymentResponse>(_ProcessPaymentResponse_QNAME, ProcessPaymentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ping }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.chase.com/", name = "ping")
    public JAXBElement<Ping> createPing(Ping value) {
        return new JAXBElement<Ping>(_Ping_QNAME, Ping.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcessPayment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.chase.com/", name = "processPayment")
    public JAXBElement<ProcessPayment> createProcessPayment(ProcessPayment value) {
        return new JAXBElement<ProcessPayment>(_ProcessPayment_QNAME, ProcessPayment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.chase.com/", name = "pingResponse")
    public JAXBElement<PingResponse> createPingResponse(PingResponse value) {
        return new JAXBElement<PingResponse>(_PingResponse_QNAME, PingResponse.class, null, value);
    }

}

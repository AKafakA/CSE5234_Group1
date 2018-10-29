package com.chase.payment;

import javax.jws.WebService;


@WebService (targetNamespace="http://payment.chase.com/", serviceName="PaymentProcessorService", portName="PaymentProcessorPort", wsdlLocation="WEB-INF/wsdl/PaymentProcessorService.wsdl")
public class PaymentProcessorDelegate{

    com.chase.payment.PaymentProcessor _paymentProcessor = null;

    public String ping () {
        return _paymentProcessor.ping();
    }

    public String processPayment (CreditCardPayment creditPayment) {
        return _paymentProcessor.processPayment(creditPayment);
    }

    public PaymentProcessorDelegate() {
        _paymentProcessor = new com.chase.payment.PaymentProcessor(); }

}
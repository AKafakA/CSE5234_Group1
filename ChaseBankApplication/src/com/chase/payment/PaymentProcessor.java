package com.chase.payment;

public class PaymentProcessor {
	public String ping() {
		return "Ready for business.";
	}
	
	public String processPayment(CreditCardPayment creditPayment) {
		return "123456";
	}
}

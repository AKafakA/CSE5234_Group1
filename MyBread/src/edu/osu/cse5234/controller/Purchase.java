package edu.osu.cse5234.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/purchase")
public class Purchase {
	
	private int count = 0;
	
	@RequestMapping(method = RequestMethod.GET)
	public String viewOrderEntryPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// ... instantiate and set order object with items to display
		Order order = new Order();
		List<Item> items = new ArrayList<Item>();
		
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
		
		whiteBread.setQuantity("0");
		wheatBread.setQuantity("0");
		raisinBread.setQuantity("0");
		oatBread.setQuantity("0");
		honeyWheatBread.setQuantity("0");
		
		items.add(whiteBread);
		items.add(wheatBread);
		items.add(raisinBread);
		items.add(oatBread);
		items.add(honeyWheatBread);
		
		order.setItems(items);
		request.setAttribute("order", order);
		return "OrderEntryForm";
	}

	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("order") Order order, HttpServletRequest request) {
		request.getSession().setAttribute("order", order);
		return "redirect:/purchase/paymentEntry";
	}
	
	@RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
	public String viewPaymentEntryPage(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("payment", new PaymentInfo());	
		return "PaymentEntryForm";
	}
	
	@RequestMapping(path = "/submitPayment", method = RequestMethod.POST)
	public String submitPayment(@ModelAttribute("paymentInfo") PaymentInfo paymentInfo, HttpServletRequest request) {
		request.getSession().setAttribute("payment", paymentInfo);
		return "redirect:/purchase/shippingEntry";
	}
	
	@RequestMapping(path = "/shippingEntry", method = RequestMethod.GET)
	public String viewShippingEntryPage(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("shipping", new ShippingInfo());	
		return "ShippingEntryForm";
	}
	
	@RequestMapping(path = "/submitShipping", method = RequestMethod.POST)
	public String submitShipping(@ModelAttribute("shippingInfo") ShippingInfo shippingInfo, HttpServletRequest request) {
		request.getSession().setAttribute("shipping", shippingInfo);
		return "redirect:/purchase/viewOrder";
	}
	
	@RequestMapping(path = "/viewOrder", method = RequestMethod.GET)
	public String viewOrderPage(HttpServletRequest request, HttpServletResponse response) {
		return "ViewOrder";
	}
	
	@RequestMapping(path = "/confirmOrder", method = RequestMethod.POST)
	public String confirmOrder(HttpServletRequest request) {
		count++;
		request.getSession().setAttribute("confirmation", count);
		return "redirect:/purchase/viewConfirmation";
	}
	
	@RequestMapping(path = "/viewConfirmation", method = RequestMethod.GET)
	public String viewConfirmationPage(HttpServletRequest request, HttpServletResponse response) {
		return "Confirmation";
	}
}

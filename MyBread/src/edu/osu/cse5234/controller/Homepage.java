package edu.osu.cse5234.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class Homepage {
	@RequestMapping(method = RequestMethod.GET)
	public String redirectToHomepage(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
		return "Home";
	}
	
	@RequestMapping(path = "/purchase", method = RequestMethod.POST)
	public String purchase(@ModelAttribute("order") Order order, HttpServletRequest request) {
		request.getSession().setAttribute("order", order);
		return "redirect:/purchase";
	}
	
	@RequestMapping(path = "/AboutUs", method = RequestMethod.GET)
	public String contactUs() throws Exception {
		return "AboutUs";
	}
	
	@RequestMapping(path = "/ContactUs", method = RequestMethod.GET)
	public String aboutUs() throws Exception {
		return "ContactUs";
	}
}

package edu.osu.cse5234.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	@RequestMapping(method = RequestMethod.GET)
	public void printHello(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.getWriter().println("Hello World Spring MVC!");
	}
	
	@RequestMapping(path = "/new", method = RequestMethod.GET)
	public String printHelloNew() throws Exception {
		return "HelloJSP";
		
	}
}

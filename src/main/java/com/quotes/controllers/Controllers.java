package com.quotes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quotes.models.Quote;
import com.quotes.services.MyService;

@Controller
@RequestMapping("/quote")
public class Controllers {

	@Autowired
	public MyService myService;
	
	@GetMapping("/display")
	public String displayQuote() {
	    System.out.println("Request to dispaly qutoes has been received.");
		return "quote";
	}
	@GetMapping("/get")
	@ResponseBody
	public Quote getQuote() throws InterruptedException {
		System.out.println("A new request is received to get new quote.");
		
		Quote quote = myService.fetchData();
		
		Thread.sleep(500);
		return quote;
	}
}

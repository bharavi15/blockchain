package com.bharavi.Blockchain.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bharavi.Blockchain.beans.Transaction;

@Controller
public class MainController {
	
	private static final Logger log = LoggerFactory.getLogger(MainController.class);

	
	@RequestMapping("/")
	@ResponseBody
	public String helloHandler () {
		Transaction transaction = new Transaction();
		transaction.setCreditAccount("abcd");
		log.info(transaction.toString());
		return "<h1>Hello World!s</h1>";
	}

}

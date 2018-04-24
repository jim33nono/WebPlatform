package com.dev.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@PropertySource("classpath:authorizeUrlAndRes.properties")
public class IndexController {
	private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

	@RequestMapping(value = { "/", "/index" })
	public String index() {
		LOGGER.info("Connected Index Page Successfully");
		return "/html/main.html";
		// return "redirect:/tryLogin.do";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String apiTest() {
		LOGGER.info("test api catched");
		return "/html/main.html";
	}
	

}

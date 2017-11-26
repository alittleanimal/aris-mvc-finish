package com.accenture.aris.inventory.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/stock")
public class TestViewController {

	@RequestMapping(value = "/view/charts")
	public String testChart(){
		return "ktp/charts";
	}
	
	@RequestMapping(value = "/view/elements")
	public String testElements(){
		return "ktp/test/MyJsp";
	}
	
}

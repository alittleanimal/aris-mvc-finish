package com.accenture.aris.inventory.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accenture.aris.inventory.business.service.CourseService;
import com.accenture.aris.inventory.business.service.impl.CourseServiceImpl;

@Controller
@RequestMapping(value = "/stock")
public class TestViewController {

	private CourseService courseService = new CourseServiceImpl();
	
	@RequestMapping(value = "/view/charts")
	public String testChart(){
		courseService.selectCourse("U0001");
		return "ktp/charts";
	}
	
	@RequestMapping(value = "/view/elements")
	public String testElements(){
		return "ktp/test/MyJsp";
	}
	
}

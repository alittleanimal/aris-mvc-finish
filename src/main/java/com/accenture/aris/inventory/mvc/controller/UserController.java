package com.accenture.aris.inventory.mvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.accenture.aris.inventory.business.service.CourseService;
import com.accenture.aris.inventory.business.service.impl.CourseServiceImpl;

@Controller
@RequestMapping(value = "/stock")
public class UserController {

	private CourseService courseService = new CourseServiceImpl();
	
	@RequestMapping(value = "/view/userRegister")
	public String testChart(@Valid Model uiModel, SessionStatus status){

		return "userInfo/userRegister";
	}
	
	@RequestMapping(value = "/view/elements")
	public String testElements(){
		return "ktp/test/MyJsp";
	}
	
}

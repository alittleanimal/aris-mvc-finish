package com.accenture.aris.inventory.mvc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.accenture.aris.core.authentication.ServletAuthenticatedLocator;
import com.accenture.aris.core.authorization.ServletAuthorisedLocator;
import com.accenture.aris.core.support.ServiceResult;
import com.accenture.aris.core.support.message.Messages;
import com.accenture.aris.inventory.business.entity.CourseEntity;
import com.accenture.aris.inventory.business.entity.MessageEntity;
import com.accenture.aris.inventory.business.service.CourseService;
import com.accenture.aris.inventory.business.service.MessageService;
import com.accenture.aris.inventory.business.service.impl.CourseServiceImpl;
import com.accenture.aris.inventory.mvc.form.MessageForm;
import com.accenture.aris.sample.business.entity.UserEntity;
import com.accenture.aris.sample.business.service.UserService;

@Controller
@RequestMapping(value = "/stock")
public class NoticeController {

	@Autowired
	private Messages messages;
	@Autowired
	CourseService courseService;
	@Autowired
	MessageService messageService;
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/view/noticeIndex")
	public String noticeIndexInit(@Valid Model uiModel, SessionStatus status,HttpServletRequest request){

		return "notice/noticeIndex_teacher";

	}
	
	
	
	
	public static String getRandomCharAndNumr(Integer length) {  
	    String str = "";  
	    Random random = new Random();  
	    for (int i = 0; i < length; i++) {  
	        boolean b = random.nextBoolean();  
	        if (b) { // 字符串  
	            // int choice = random.nextBoolean() ? 65 : 97; 取得65大写字母还是97小写字母  
	            str += (char) (65 + random.nextInt(26));// 取得大写字母  
	        } else { // 数字  
	            str += String.valueOf(random.nextInt(10));  
	        }  
	    }  
	    return str;  
	}  
	
}

package com.accenture.aris.inventory.mvc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

@Controller
@RequestMapping(value = "/stock")
public class MessageController {

	@Autowired
	private Messages messages;
	@Autowired
	CourseService courseService;
	@Autowired
	MessageService messageService;
	
	@RequestMapping(value = "/view/messageIndex")
	public String messageIndexInit(@Valid Model uiModel, SessionStatus status,HttpServletRequest request){
		String userID= new ServletAuthenticatedLocator(request).getAuthenicatedUser();
        String roleID= new ServletAuthorisedLocator(request).getAuthorisedRole();
        
		ServiceResult<List<CourseEntity>> serviceResult = courseService.selectCourse(userID);
		List courseEntity = (List) serviceResult.getAttribute("courses");
		
		uiModel.addAttribute("courses", courseEntity);

		return "message/messageIndex";

	}
	
	@RequestMapping(value = "/view/messageDetail/{cno}")
	public String messageDetail(@Valid @PathVariable("cno") int cno, Model uiModel, SessionStatus status,HttpServletRequest request){
		String userID= new ServletAuthenticatedLocator(request).getAuthenicatedUser();
		List<MessageEntity> noReplyMessage = messageService.messageDetail(cno, 1);
		List<MessageEntity> replyedMessage = messageService.messageDetail(cno, 2);
		
		List<List<MessageEntity>> replyMessageUnits = new ArrayList();
		
		for (MessageEntity messageEntity : replyedMessage)
		{
			String messageID = messageEntity.getMessageid();
			List<MessageEntity> replyMessage = messageService.messageReply(messageID);
			List<MessageEntity> replyedMessageUnit = new ArrayList();
			replyedMessageUnit.add(messageEntity);
			for (MessageEntity replyMessageEntity : replyMessage)
			{
				replyedMessageUnit.add(replyMessageEntity);
			}
			
			replyMessageUnits.add(replyedMessageUnit);
		}
		
		uiModel.addAttribute("noReplyMessage", noReplyMessage);
		uiModel.addAttribute("replyMessageUnits", replyMessageUnits);

		return "message/messageDetail";

	}
	
}

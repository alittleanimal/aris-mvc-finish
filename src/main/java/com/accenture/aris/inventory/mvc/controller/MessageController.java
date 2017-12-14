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
public class MessageController {

	@Autowired
	private Messages messages;
	@Autowired
	CourseService courseService;
	@Autowired
	MessageService messageService;
	@Autowired
	UserService userService;
	
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
		uiModel.addAttribute("cno", cno);
		uiModel.addAttribute("noReplyMessage", noReplyMessage);
		uiModel.addAttribute("replyMessageUnits", replyMessageUnits);

		return "message/messageDetail";

	}
	
	@RequestMapping(value = "/view/messageResponse/{responseinfo}")
	public String messageResponse(@Valid @PathVariable("responseinfo") String responseinfo, Model uiModel, SessionStatus status,HttpServletRequest request){
		int cno = Integer.parseInt(responseinfo.substring(0, 4));
		
		String messageid = responseinfo.substring(4);		
		
		uiModel.addAttribute("responseinfo", responseinfo);
		uiModel.addAttribute("cno", cno);
		uiModel.addAttribute("messageid", messageid);
		
		return "message/messageResponse";

	}
	
	@RequestMapping(value = "/view/messageResponseUpdate/{responseinfo}")
	public String messageResponseUpdate(@Valid MessageForm messageForm ,@PathVariable("responseinfo") String responseinfo, Model uiModel, 
			 SessionStatus status,HttpServletRequest request){
		int cno = Integer.parseInt(responseinfo.substring(0, 4));		
		String messageid = responseinfo.substring(4);
		String userID= new ServletAuthenticatedLocator(request).getAuthenicatedUser();
		ServiceResult<UserEntity> result = userService.searchUserService(userID);
		String name = result.getResult().getName();
		
		MessageEntity messageEntity = new MessageEntity();
		messageEntity.setUserid(userID);
		messageEntity.setCno(cno);
		messageEntity.setReply(3);
		messageEntity.setName(name);
		messageEntity.setMessageid(getRandomCharAndNumr(6));
		messageEntity.setText(messageForm.gettext());
		boolean responseResult = messageService.replyMessage(messageEntity, messageid);
		boolean	replyResult = messageService.changeReply(messageid, 2);


		return "redirect:/stock/view/messageDetail/" +cno;
	}
	

	@RequestMapping(value = "/view/messageCreate/{cno1}")
	public String messageCreate(@Valid MessageForm messageForm ,@PathVariable("cno1") int cno1, Model uiModel, 
			 SessionStatus status,HttpServletRequest request){

		String userID= new ServletAuthenticatedLocator(request).getAuthenicatedUser();

		
		MessageEntity messageEntity = new MessageEntity();
		messageEntity.setUserid(userID);
		messageEntity.setCno(cno1);
		messageEntity.setReply(1);
		messageEntity.setMessageid(getRandomCharAndNumr(6));
		messageEntity.setText(messageForm.gettext());
		boolean responseResult = messageService.createMessage(messageEntity);


		return "redirect:/stock/view/messageDetail/" +cno1;
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

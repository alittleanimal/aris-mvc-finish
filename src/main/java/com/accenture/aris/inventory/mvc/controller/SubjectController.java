package com.accenture.aris.inventory.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.accenture.aris.core.authentication.Authenticator;
import com.accenture.aris.core.authentication.ServletAuthenticatedLocator;
import com.accenture.aris.core.authorization.Authorization;
import com.accenture.aris.core.authorization.ServletAuthorisedLocator;
import com.accenture.aris.core.support.ServiceResult;
import com.accenture.aris.core.support.codeloader.CodeLoader;
import com.accenture.aris.core.support.codeloader.StaticCodeLoader;
import com.accenture.aris.core.support.message.Messages;
import com.accenture.aris.core.support.pagination.Pagination;
import com.accenture.aris.inventory.business.entity.CourseEntity;
import com.accenture.aris.inventory.business.entity.StockInfoEntity;
import com.accenture.aris.inventory.business.service.CourseService;
import com.accenture.aris.inventory.business.service.StockService;
import com.accenture.aris.inventory.mvc.form.InvitationCodeForm;
import com.accenture.aris.inventory.mvc.form.StockSearchForm;
import com.accenture.aris.inventory.mvc.form.StockUpdateForm;

@Controller
@RequestMapping(value = "/stock")
public class SubjectController {
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(SubjectController.class);
	
	@Autowired
	private Messages messages;
	@Autowired
	CourseService courseService;
	@Autowired
	private StaticCodeLoader staticCodeLoader;
	@Autowired
	private CodeLoader codeLoader;
	
	
	@RequestMapping(value = "/view/subjectIndex")
	public String subjectIndexInit(@Valid Model uiModel, SessionStatus status,HttpServletRequest request){
		//return "ktp/subjectIndex";

		String userID= new ServletAuthenticatedLocator(request).getAuthenicatedUser();
        String roleID= new ServletAuthorisedLocator(request).getAuthorisedRole();
        
		ServiceResult<List<CourseEntity>> serviceResult = courseService.selectCourse(userID);
		List courseEntity = (List) serviceResult.getAttribute("courses");
		
		uiModel.addAttribute("courses", courseEntity);
		if (roleID.equals("S0001")){
			return "ktp/subjectIndex_student";
		}
		else if (roleID.equals("T0001")){
			return "ktp/subjectIndex_teacher";
		}
		status.setComplete();
		return "ktp/subjectIndex";
	}
	
	@RequestMapping(value = "/view/joinClass")
	public String joinClass(@Valid InvitationCodeForm InviteCodeForm, BindingResult result, Model uiModel){
		if (result.hasErrors()) {
			LOGGER.debug("invalid request.");
			uiModel.addAttribute("message", messages.getMessage("I00001"));
			return "ktp/joinClass";
		}
		
		return "ktp/joinClass";
	}
	
	@RequestMapping(value = "/view/inviteCodeupdate")
	public String inviteCodeupdate(InvitationCodeForm inviteCodeForm,HttpServletRequest request){
		//else return "ktp/joinClass";
		String invitation = inviteCodeForm.getInvitation();
		String userID= new ServletAuthenticatedLocator(request).getAuthenicatedUser();
		Boolean validresult = courseService.AddStudent(userID, invitation);
		if (validresult.equals(true)){
			return "ktp/joinClassComplete";
		}
		else if (validresult.equals(false)){
			return "ktp/joinClassFailed";
		}
		return "ktp/joinClass";
		
	}
	
	@RequestMapping(value = "/view/createClass")
	public String createClass(){
		return "ktp/createClass";
	}

	@RequestMapping(value = "/view/classInformationupdate")
	public String classInformationupdate(){
		//else return "ktp/joinClass";
		return "ktp/createClassComplete";
	}
}

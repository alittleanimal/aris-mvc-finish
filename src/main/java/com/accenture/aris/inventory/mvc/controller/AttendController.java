package com.accenture.aris.inventory.mvc.controller;

import java.util.List;
import java.util.Random;

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
import com.accenture.aris.inventory.mvc.form.CourseInfoForm;
import com.accenture.aris.inventory.mvc.form.InvitationCodeForm;
import com.accenture.aris.inventory.mvc.form.StockSearchForm;
import com.accenture.aris.inventory.mvc.form.StockUpdateForm;

@Controller
@RequestMapping(value = "/stock")
public class AttendController {
	
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
	
	
	@RequestMapping(value = "/view/attendIndex")
	public String attendIndexInit(@Valid Model uiModel, SessionStatus status,HttpServletRequest request){
		//return "ktp/subjectIndex";
		String userID= new ServletAuthenticatedLocator(request).getAuthenicatedUser();
        String roleID= new ServletAuthorisedLocator(request).getAuthorisedRole();
        
		ServiceResult<List<CourseEntity>> serviceResult = courseService.selectCourse(userID);
		List courseEntity = (List) serviceResult.getAttribute("courses");
		
		uiModel.addAttribute("courses", courseEntity);
		if (roleID.equals("S0001")){
			return "attend/attendIndex_student";
		}
		else if (roleID.equals("T0001")){
			return "attend/attendIndex_teacher";
		}
		status.setComplete();
		return "attend/attendIndex";
	}
	
	@RequestMapping(value = "/view/attendDetail/{cno}")
	public String attendenceDetail(@Valid StockSearchForm stockSearchForm,HttpServletRequest request,
			BindingResult result, Model uiModel){
        String roleID= new ServletAuthorisedLocator(request).getAuthorisedRole();
        if (roleID.equals("S0001")){
			return "attend/attendDetail_student";
		}
		else if (roleID.equals("T0001")){
			return "attend/attendDetail_teacher";
		}
		return "attend/attendDetail_student";
	}
	
	@RequestMapping(value = "/view/doAttend/{cno}")
	public String doAttend(@Valid StockSearchForm stockSearchForm,HttpServletRequest request,
			BindingResult result, Model uiModel){
        String roleID= new ServletAuthorisedLocator(request).getAuthorisedRole();
        if (roleID.equals("S0001")){
			return "attend/doAttend";
		}
		else if (roleID.equals("T0001")){
			return "attend/doAttend";
		}
		return "attend/doAttend";
	}
	
	@RequestMapping(value = "/view/attendCodeupdate")
	public String attendCodeupdate(@Valid InvitationCodeForm inviteCodeForm,HttpServletRequest request,
			BindingResult result, Model uiModel){
        String roleID= new ServletAuthorisedLocator(request).getAuthorisedRole();

		return "attend/doAttendComplete";
	}
	
}

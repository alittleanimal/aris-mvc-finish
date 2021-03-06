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
import org.springframework.web.bind.annotation.PathVariable;
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
import com.accenture.aris.inventory.business.service.AttendService;
import com.accenture.aris.inventory.business.service.CourseService;
import com.accenture.aris.inventory.business.service.GradeService;
import com.accenture.aris.inventory.business.service.StockService;
import com.accenture.aris.inventory.mvc.form.CourseInfoForm;
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
	AttendService attendService;
	@Autowired
	GradeService gradeService;
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
	
	@RequestMapping(value = "/view/endCourse/{cno}")
	public String endCourse(@PathVariable("cno") int cno){
		boolean endResult1 = courseService.endCourse(cno);
		boolean endResult2 = attendService.endAttendByCno(cno);
		boolean endResult3 = gradeService.endTestByCno(cno);
 		
		return "redirect:/stock/view/subjectIndex";
	}

	@RequestMapping(value = "/view/classInformationupdate")
	public String classInformationupdate(HttpServletRequest request,CourseInfoForm courseInfoForm,Model uiModel){
		//else return "ktp/joinClass";
		String userName= new ServletAuthenticatedLocator(request).getAuthenicatedName();
		String userID= new ServletAuthenticatedLocator(request).getAuthenicatedUser();
		String invitation = getRandomCharAndNumr(5);
		
		CourseEntity courseEntity = new CourseEntity();
		BeanUtils.copyProperties(courseInfoForm, courseEntity);
		int credit = 0;
		if (courseInfoForm.getCredit()!=""){
			credit= Integer.parseInt(courseInfoForm.getCredit());
		}
		courseEntity.setCredit(credit);
		
		String cname = courseEntity.getCname();
		String semester = courseEntity.getSemester();
		String time = courseEntity.getTime();
		if (credit == 0||cname==null || semester==null || time==null)
		{
			return "ktp/createClassFailed";
		}
		courseEntity.setTeacher(userName);
		courseEntity.setInvitation(invitation);
		
		Boolean createResult = courseService.AddCourse(courseEntity);
		if (createResult.equals(true)){
			courseService.AddStudent(userID, invitation);
			
			uiModel.addAttribute("newClass", courseEntity);
			return "ktp/createClassComplete";
		}
		else{
			return "ktp/createClassFailed";
		}
		
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

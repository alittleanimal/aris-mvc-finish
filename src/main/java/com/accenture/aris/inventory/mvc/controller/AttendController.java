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
import com.accenture.aris.inventory.business.service.StockService;
import com.accenture.aris.inventory.mvc.form.AttendenceForm;
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
	AttendService attendService;
	@Autowired
	private StaticCodeLoader staticCodeLoader;
	@Autowired
	private CodeLoader codeLoader;
	
	
	@RequestMapping(value = "/view/attendIndex")
	public String attendIndexInit(@Valid Model uiModel, SessionStatus status,HttpServletRequest request){
		//return "ktp/subjectIndex";
		String userID= new ServletAuthenticatedLocator(request).getAuthenicatedUser();
        String roleID= new ServletAuthorisedLocator(request).getAuthorisedRole();
        		
		List attendingCourse = attendService.SelectAttendingCourse(userID);
		List unattendingCourse = attendService.SelectUnAttendingCourse(userID);
		
		uiModel.addAttribute("attendingCourse", attendingCourse);
		uiModel.addAttribute("unattendingCourse", unattendingCourse);
		
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
	public String attendenceDetail(@Valid @PathVariable("cno") int cno,HttpServletRequest request, Model uiModel){
        String roleID= new ServletAuthorisedLocator(request).getAuthorisedRole();
        String userID= new ServletAuthenticatedLocator(request).getAuthenicatedUser();
        
        if (roleID.equals("S0001")){
        	List StudentAttendingDetail = attendService.selectAttendByIdCno(cno, userID, "attend");
        	List StudentunAttendingDetail = attendService.selectAttendByIdCno(cno, userID, "notattend");
        	
        	String CourseName = courseService.selectCourseNameById(cno);
        	
        	uiModel.addAttribute("CourseName", CourseName);
        	uiModel.addAttribute("StudentAttendingDetail", StudentAttendingDetail);
        	uiModel.addAttribute("StudentunAttendingDetail", StudentunAttendingDetail);
        	
			return "attend/attendDetail_student";
		}
		else if (roleID.equals("T0001")){
			List TeacherAttendingDetail = attendService.selectAttendenceDetail(cno, 1);
			List TeacherUnAttendingDetail = attendService.selectAttendenceDetail(cno, 0);
			
			String CourseName = courseService.selectCourseNameById(cno);        	
        	uiModel.addAttribute("CourseName", CourseName);
			
        	uiModel.addAttribute("CourseName", CourseName);
        	uiModel.addAttribute("TeacherAttendingDetail", TeacherAttendingDetail);
        	uiModel.addAttribute("TeacherUnAttendingDetail", TeacherUnAttendingDetail);

			return "attend/attendDetail_teacher";
		}
		return "attend/attendDetail_student";
	}
	
	@RequestMapping(value = "/view/doAttend/{cno}")
	public String doAttend(@Valid @PathVariable("cno") int cno, HttpServletRequest request, Model uiModel){
        String roleID= new ServletAuthorisedLocator(request).getAuthorisedRole();
        
        String CourseName = courseService.selectCourseNameById(cno);
        int count = attendService.MaxCount(cno);
        
        uiModel.addAttribute("CourseName", CourseName);
        uiModel.addAttribute("count", count);
        
		return "attend/doAttend";
	}
	
	@RequestMapping(value = "/view/attendCodeupdate")
	public String attendCodeupdate(@Valid AttendenceForm attendenceForm,HttpServletRequest request,Model uiModel){
        String userID= new ServletAuthenticatedLocator(request).getAuthenicatedUser();
        String attendenceId = attendenceForm.getattendenceId();
        Boolean attendResult = attendService.IsAttend(userID, attendenceId);
        
        if (attendResult.equals(true)){
        	return "attend/doAttendComplete";
		}
		else if (attendResult.equals(false)){
			return "attend/doAttendFailed";
		}

		return "attend/doAttendComplete";
	}
	
}

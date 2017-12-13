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
        	uiModel.addAttribute("TeacherAttendingDetail", TeacherAttendingDetail);
        	uiModel.addAttribute("TeacherUnAttendingDetail", TeacherUnAttendingDetail);

			return "attend/attendDetail_teacher";
		}
		return "attend/attendDetail_student";
	}
	
	@RequestMapping(value = "/view/attendDetailTeacher/{attendInfo}")
	public String attendDetailTeacher(@Valid @PathVariable("attendInfo") String attendInfo,HttpServletRequest request, Model uiModel){
		int cno = Integer.parseInt(attendInfo.substring(0, 4));
		
		int count = Integer.parseInt(attendInfo.substring(4));
		String CourseName = courseService.selectCourseNameById(cno); 
	        
        List AttendDetail = attendService.selectAttendByCnoCount(cno, count,"attend");
        List unAttendDetail = attendService.selectAttendByCnoCount(cno, count,"notAttend");

        
    	uiModel.addAttribute("cno", cno);
    	uiModel.addAttribute("CourseName", CourseName);
        uiModel.addAttribute("AttendDetail", AttendDetail);
        uiModel.addAttribute("unAttendDetail", unAttendDetail);

        
		return "attend/attendDetail2_teacher";
	}
	

	@RequestMapping(value = "/view/endAttend/{attendInfo}")
	public String endAttend(@Valid @PathVariable("attendInfo") String attendInfo,HttpServletRequest request, Model uiModel){
		int cno = Integer.parseInt(attendInfo.substring(0, 4));		
		int count = Integer.parseInt(attendInfo.substring(4));
		
		boolean endResult = attendService.endAttend(cno, count);
        
		List TeacherAttendingDetail = attendService.selectAttendenceDetail(cno, 1);
		List TeacherUnAttendingDetail = attendService.selectAttendenceDetail(cno, 0);
		
		String CourseName = courseService.selectCourseNameById(cno); 
		
    	uiModel.addAttribute("CourseName", CourseName);
    	uiModel.addAttribute("TeacherAttendingDetail", TeacherAttendingDetail);
    	uiModel.addAttribute("TeacherUnAttendingDetail", TeacherUnAttendingDetail);

		return "attend/attendDetail_teacher";
	}
	
	@RequestMapping(value = "/view/isAttend/{changeInfo}")
	public String isAttend(@Valid @PathVariable("changeInfo") String changeInfo, HttpServletRequest request, Model uiModel){        
        String attendenceId = changeInfo.substring(0, 5);
        String userID = changeInfo.substring(5);
        boolean changeResult = attendService.IsAttend(userID, attendenceId);
        int cno = attendService.getCno(attendenceId);
        int count = attendService.getCount(attendenceId);
        
        String CourseName = courseService.selectCourseNameById(cno); 
        
        List AttendDetail = attendService.selectAttendByCnoCount(cno, count,"attend");
        List unAttendDetail = attendService.selectAttendByCnoCount(cno, count,"notAttend");

        
    	uiModel.addAttribute("cno", cno);
    	uiModel.addAttribute("CourseName", CourseName);
        uiModel.addAttribute("AttendDetail", AttendDetail);
        uiModel.addAttribute("unAttendDetail", unAttendDetail);

        
		return "attend/attendDetail2_teacher";
	}
	
	@RequestMapping(value = "/view/isNotAttend/{changeInfo}")
	public String isNotAttend(@Valid @PathVariable("changeInfo") String changeInfo, HttpServletRequest request, Model uiModel){
	    String attendenceId = changeInfo.substring(0, 5);
	    String userID = changeInfo.substring(5);     
        boolean changeResult = attendService.IsNotAttend(userID, attendenceId);
      
        
        int cno = attendService.getCno(attendenceId);
        int count = attendService.getCount(attendenceId);
        
        String CourseName = courseService.selectCourseNameById(cno); 
        
        List AttendDetail = attendService.selectAttendByCnoCount(cno, count,"attend");
        List unAttendDetail = attendService.selectAttendByCnoCount(cno, count,"notAttend");

        
    	uiModel.addAttribute("cno", cno);
    	uiModel.addAttribute("CourseName", CourseName);
        uiModel.addAttribute("AttendDetail", AttendDetail);
        uiModel.addAttribute("unAttendDetail", unAttendDetail);

        
		return "attend/attendDetail2_teacher";
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
	
	@RequestMapping(value = "/view/addAttend/{cno}")
	public String addAttend(@Valid @PathVariable("cno") int cno, HttpServletRequest request, Model uiModel){
        
        String CourseName = courseService.selectCourseNameById(cno);
        int count = attendService.MaxCount(cno)+1;
        
        uiModel.addAttribute("CourseName", CourseName);
        uiModel.addAttribute("count", count);
        uiModel.addAttribute("cno", cno);

        
		return "attend/addAttend";
	}
	
	@RequestMapping(value = "/view/addAttendConfirm/{cno}")
	public String addAttendConfirm(@Valid @PathVariable("cno") int cno, HttpServletRequest request, Model uiModel){
        String attendenceId = getRandomCharAndNumr(5);
        Boolean addResult = attendService.AddAttendence(cno, attendenceId);
        uiModel.addAttribute("attendenceId", attendenceId);
        if (addResult.equals(true)){
        	return "attend/addAttendComplete";
		}
		else if (addResult.equals(false)){
			return "attend/addAttendFailed";
		}

		return "attend/addAttendComplete";
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

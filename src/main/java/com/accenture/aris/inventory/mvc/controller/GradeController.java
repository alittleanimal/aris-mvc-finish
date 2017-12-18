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
import com.accenture.aris.inventory.business.entity.GradeEntity;
import com.accenture.aris.inventory.business.entity.MessageEntity;
import com.accenture.aris.inventory.business.entity.NoticeEntity;
import com.accenture.aris.inventory.business.service.CourseService;
import com.accenture.aris.inventory.business.service.GradeService;
import com.accenture.aris.inventory.business.service.MessageService;
import com.accenture.aris.inventory.business.service.NoticeService;
import com.accenture.aris.inventory.business.service.impl.CourseServiceImpl;
import com.accenture.aris.inventory.mvc.form.GradeForm;
import com.accenture.aris.inventory.mvc.form.MessageForm;
import com.accenture.aris.inventory.mvc.form.NoticeForm;
import com.accenture.aris.sample.business.entity.UserEntity;
import com.accenture.aris.sample.business.service.UserService;

@Controller
@RequestMapping(value = "/stock")
public class GradeController {

	@Autowired
	private Messages messages;
	@Autowired
	CourseService courseService;
	@Autowired
	MessageService messageService;
	@Autowired
	UserService userService;
	@Autowired
	NoticeService noticeService;
	@Autowired
	GradeService gradeService;
	
	@RequestMapping(value = "/view/gradeIndex")
	public String gradeIndexInit(@Valid Model uiModel, SessionStatus status,HttpServletRequest request){
		
        String roleID= new ServletAuthorisedLocator(request).getAuthorisedRole();
		String userID= new ServletAuthenticatedLocator(request).getAuthenicatedUser();
		
		if (roleID.equals("S0001")){
			
			List<GradeEntity> studentGradeList = gradeService.getStudentTestList(userID);
			List<GradeEntity> studentFailedGradeList = new ArrayList();
			List<GradeEntity> studentPassedGradeList = new ArrayList();


			for (GradeEntity gradeEntity: studentGradeList)
			{
				if (gradeEntity.getGrade()<60){
					studentFailedGradeList.add(gradeEntity);
				}
				else {
					studentPassedGradeList.add(gradeEntity);
				}
			}
			uiModel.addAttribute("studentFailedGradeList", studentFailedGradeList);
			uiModel.addAttribute("studentPassedGradeList", studentPassedGradeList);
			
			return "grade/gradeIndex_student";
		}
		else if (roleID.equals("T0001")){
			
			ServiceResult<List<CourseEntity>> serviceResult = courseService.selectCourse(userID);
			List courseEntity = (List) serviceResult.getAttribute("courses");
			
			uiModel.addAttribute("courses", courseEntity);
			
			return "grade/gradeIndex_teacher";
		}
		return "grade/gradeIndex_teacher";

	}
	
	@RequestMapping(value = "/view/gradeDetail/{cno}")
	public String gradeDetail(@Valid @PathVariable("cno") int cno, Model uiModel, SessionStatus status,HttpServletRequest request){
		
		List<GradeEntity> courseGradeList = gradeService.getTestList(cno);
		uiModel.addAttribute("courseGradeList", courseGradeList);
		uiModel.addAttribute("cno", cno);

		
		return "grade/gradeDetail";
		
	}
	
	@RequestMapping(value = "/view/gradeDetailTeacher/{testid}")
	public String gradeDetailTeacher(@Valid @PathVariable("testid") String testid, Model uiModel, SessionStatus status,HttpServletRequest request){
		
		List<GradeEntity> studentGradeList = gradeService.getTestDetail(testid);
		int cno = studentGradeList.get(0).getCno();
		
		uiModel.addAttribute("studentGradeList", studentGradeList);
		uiModel.addAttribute("cno", cno);
		
		return "grade/gradeDetail_teacher";
		
	}
	
	@RequestMapping(value = "/view/changeGradeDetail/{gradeid}")
	public String changeGradeDetail(@Valid @PathVariable("gradeid") int gradeid, 
			 Model uiModel, SessionStatus status,HttpServletRequest request){
		
		GradeEntity gradeEntity = gradeService.getOneDetail(gradeid);
		String testid = gradeEntity.getTestid();
		
		uiModel.addAttribute("gradeEntity", gradeEntity);
		
		return "grade/gradeDetail_change";
		
		
	}
	
	@RequestMapping(value = "/view/changeGrade/{gradeid}")
	public String changeGrade(@Valid @PathVariable("gradeid") int gradeid, 
			GradeForm gradeForm, Model uiModel, SessionStatus status,HttpServletRequest request){
		
		GradeEntity gradeEntity = gradeService.getOneDetail(gradeid);
		String testid = gradeEntity.getTestid();
		if (gradeForm.getGrade()== null || gradeForm.getGrade()== "" ||
				Integer.parseInt(gradeForm.getGrade())>100 ||Integer.parseInt(gradeForm.getGrade())<0)
		{
			GradeEntity gradeEntityChange = gradeService.getOneDetail(gradeid);
			
			uiModel.addAttribute("gradeEntity", gradeEntityChange);
			return "grade/gradeDetail_changeFailed";
		}
		boolean gradeResult = gradeService.changeGrade(gradeid, Integer.parseInt(gradeForm.getGrade()));
	
		return "redirect:/stock/view/gradeDetailTeacher/" + testid;
		
	}
	
	@RequestMapping(value = "/view/createTestDetail/{cno}")
	public String createTestDetail(@Valid @PathVariable("cno") int cno, Model uiModel,SessionStatus status,HttpServletRequest request){
			
		String cname = courseService.selectCourseNameById(cno);
		uiModel.addAttribute("cno", cno);
		uiModel.addAttribute("cname", cname);


		return "grade/createTest" ;
		
	}
	
	@RequestMapping(value = "/view/endTest/{testid}")
	public String endTest(@Valid @PathVariable("testid") String testid, Model uiModel,SessionStatus status,HttpServletRequest request){
			
		int cno= gradeService.getCnoBytestid(testid);
		
		boolean endResult = gradeService.endTest(testid);

		return "redirect:/stock/view/gradeDetail/"+cno ;
		
	}
	@RequestMapping(value = "/view/createTest/{cno}")
	public String createTest(@Valid @PathVariable("cno") int cno, Model uiModel,
			GradeForm gradeForm,SessionStatus status,HttpServletRequest request){
		
		if (gradeForm.getTestname()==null ||gradeForm.getTestname()=="" 
				|| gradeForm.getTime()=="" || gradeForm.getTime()==null)
		{
			String cname = courseService.selectCourseNameById(cno);
			uiModel.addAttribute("cno", cno);
			uiModel.addAttribute("cname", cname);
			return "grade/createTestFailed" ;
		}
		GradeEntity gradeEntity = new GradeEntity();
		gradeEntity.setTestid(getRandomCharAndNumr(7));
		gradeEntity.setCno(cno);
		gradeEntity.setCname(courseService.selectCourseNameById(cno));
		gradeEntity.setTestname(gradeForm.getTestname());
		gradeEntity.setTime(gradeForm.getTime());
		
		boolean testResult = gradeService.createTest(gradeEntity);
		

		
		return "grade/createTestSuccess" ;
		
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

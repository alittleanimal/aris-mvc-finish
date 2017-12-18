package com.accenture.aris.inventory.business.service;

import java.util.List;

import com.accenture.aris.core.support.ServiceResult;
import com.accenture.aris.inventory.business.entity.AttendEntity;
import com.accenture.aris.inventory.business.entity.CourseEntity;

public interface CourseService {
	public ServiceResult<List<CourseEntity>> selectCourse(String userid);
	public Boolean AddStudent(String userid, String invitation);
	public Boolean AddCourse(CourseEntity courseEntity);
	public String selectCourseNameById(int cno);
	public boolean endCourse (int cno);
}

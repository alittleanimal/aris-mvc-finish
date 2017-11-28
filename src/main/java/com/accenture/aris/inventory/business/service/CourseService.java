package com.accenture.aris.inventory.business.service;

import java.util.List;

import com.accenture.aris.core.support.ServiceResult;
import com.accenture.aris.inventory.business.entity.CourseEntity;

public interface CourseService {
	public ServiceResult<List<CourseEntity>> selectCourse(String userid);
	public Boolean AddStudent(String userid, String invitation);
	public ServiceResult<Boolean> AddCourse(CourseEntity courseEntity);
}

package com.accenture.aris.inventory.business.service;

import com.accenture.aris.core.support.ServiceResult;
import com.accenture.aris.inventory.business.entity.CourseEntity;

public interface CourseService {
	public ServiceResult<CourseEntity> selectCourse(String userid);
	public ServiceResult<Boolean> AddStudent(Integer userid, String invitation);
	public ServiceResult<Boolean> AddCourse(CourseEntity courseEntity);
}

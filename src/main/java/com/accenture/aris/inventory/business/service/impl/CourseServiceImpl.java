package com.accenture.aris.inventory.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.aris.core.support.ServiceResult;
import com.accenture.aris.inventory.business.entity.CourseEntity;
import com.accenture.aris.inventory.business.repository.CourseRepository;
import com.accenture.aris.inventory.business.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepository courseRepository;
	@Override
	public ServiceResult<CourseEntity> selectCourse(String userid) {
		List<Integer> courseList = courseRepository.selectByUserid(userid);
		List<CourseEntity> courseEntityList = new ArrayList<CourseEntity>();
		CourseEntity courseEntity = new CourseEntity();
		for (Integer course : courseList) {
			courseEntity = courseRepository.selectByCno(course);
			courseEntityList.add(courseEntity);
		}	
		ServiceResult<CourseEntity> result = new ServiceResult<CourseEntity>();
		result.setAttribute("course", courseEntity);
		return result;
	}
	@Override
	public ServiceResult<Boolean> AddStudent(Integer userid, String invitation) {
		CourseEntity courseEntity = courseRepository.selectByInvitation(invitation);
		int result = courseRepository.insertStudent(userid, courseEntity.getCno(), courseEntity.getInvitation());
		if (result != 0) {
			return new ServiceResult<Boolean>(true); 
		}else {
			return new ServiceResult<Boolean>(false);
		}
	}
	@Override
	public ServiceResult<Boolean> AddCourse(CourseEntity courseEntity) {
		int result = courseRepository.insertCourse(courseEntity);
		if (result != 0) {
			return new ServiceResult<Boolean>(true); 
		}else {
			return new ServiceResult<Boolean>(false);
		}
	}
	
}

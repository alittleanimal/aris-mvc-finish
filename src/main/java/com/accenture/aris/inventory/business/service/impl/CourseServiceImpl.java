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
	public ServiceResult<List<CourseEntity>> selectCourse(String userid) {
		List<Integer> courseList = courseRepository.selectByUserid(userid);
		List<CourseEntity> courseEntityList = new ArrayList<CourseEntity>();
		CourseEntity courseEntity = new CourseEntity();
		for (Integer course : courseList) {
			courseEntity = courseRepository.selectByCno(course);
			courseEntityList.add(courseEntity);
		}	
		ServiceResult<List<CourseEntity>> result = new ServiceResult<List<CourseEntity>>();
		result.setAttribute("courses", courseEntityList);
		return result;
	}
	@Override
	public Boolean AddStudent(String userid, String invitation) {
		CourseEntity courseEntity = courseRepository.selectByInvitation(invitation);
		if (null == courseEntity) {
			return false; 
		}
		int result = courseRepository.insertStudent(userid, courseEntity.getCno(), courseEntity.getInvitation());
		if (result != 0) {
			return true; 
		}else {
			return false;
		}
	}
	@Override
	public Boolean AddCourse(CourseEntity courseEntity) {
		int result = courseRepository.insertCourse(courseEntity);
		if (result != 0) {
			return true; 
		}else {
			return false;
		}
	}
	
}

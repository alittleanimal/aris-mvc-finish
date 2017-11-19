package com.accenture.aris.inventory.business.repository;

import com.accenture.aris.inventory.business.entity.CourseEntity;

public interface CourseRepository {
	CourseEntity selectByCno(int cno);
	int update(CourseEntity record);
	int insert(CourseEntity record);
	int deleteByCno(int cno);
}

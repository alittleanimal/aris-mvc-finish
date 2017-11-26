package com.accenture.aris.inventory.business.repository;

import java.util.List;

import com.accenture.aris.inventory.business.entity.CourseEntity;

public interface CourseRepository {
	CourseEntity selectByCno(int cno);
	CourseEntity selectByInvitation(String invite);
	int update(CourseEntity record);
	int insertCourse(CourseEntity record);
	int deleteByCno(int cno);
	List<Integer> selectByUserid(String userid);
	int insertStudent(int userid, int cno, String invite);
}

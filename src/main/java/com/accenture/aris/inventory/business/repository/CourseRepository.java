package com.accenture.aris.inventory.business.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.accenture.aris.inventory.business.entity.AttendEntity;
import com.accenture.aris.inventory.business.entity.CourseEntity;

@Repository
public interface CourseRepository {
	CourseEntity selectByCno(int cno);
	CourseEntity selectByInvitation(String invite);
	int update(CourseEntity record);
	int insertCourse(CourseEntity record);
	int deleteByCno(int cno);
	int deleteSelectByCno(int cno);
	List<Integer> selectByUserid(String userid);
	List<String> selectUserNameByCno(int cno);
	int insertStudent(String userid, int cno, String invite);
	List<AttendEntity> selectAttendByCno(int cno);


}

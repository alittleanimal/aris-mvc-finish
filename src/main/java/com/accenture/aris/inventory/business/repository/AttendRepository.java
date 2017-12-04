package com.accenture.aris.inventory.business.repository;

import org.springframework.stereotype.Repository;

import com.accenture.aris.inventory.business.entity.AttendEntity;

@Repository
public interface AttendRepository {
	int insertIntoAttendance(AttendEntity record);
	int insertIntoAttendDetail(AttendEntity record);
	int updateAttendState(String attendenceID,String userID,String state);
	AttendEntity selectAllAttendByCno(Integer cno);
	int selectAttendCourseById(String userid);
}

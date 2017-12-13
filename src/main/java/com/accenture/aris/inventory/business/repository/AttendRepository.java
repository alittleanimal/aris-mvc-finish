package com.accenture.aris.inventory.business.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.accenture.aris.inventory.business.entity.AttendEntity;
import com.accenture.aris.inventory.business.entity.CourseEntity;

@Repository
public interface AttendRepository {
	int insertIntoAttendance(AttendEntity record);

	int insertIntoAttendDetail(AttendEntity record);

	int updateAttendState(String attendenceID, String userID, String state);

	int updateAttendStateByCnoCount(int cno, int count, int status);

	List<AttendEntity> selectAllAttendByCno(Integer cno);

	List<Integer> selectAttendCourseById(String userid);

	List<Integer> selectUnAttendCourseById(String userid);

	int MaxCount(int cno);

	List<AttendEntity> selectAttendByIdCno(int cno, String user, String state);

	List<AttendEntity> selectAttendByCnoCount(int cno, int count, String state);
	
	List<AttendEntity> selectAttendenceDetail(Integer cno, int status);
	
	int getCno (String attendenceID);
	
	int getCount (String attendenceID);
}

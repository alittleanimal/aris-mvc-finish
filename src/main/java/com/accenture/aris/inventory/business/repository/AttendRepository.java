package com.accenture.aris.inventory.business.repository;

import com.accenture.aris.inventory.business.entity.AttendanceEntity;

public interface AttendRepository {
	int insertIntoAttendance(AttendanceEntity record);
	int insertIntoAttendDetail(AttendanceEntity record);
	int updateAttendDetail(AttendanceEntity record);
}

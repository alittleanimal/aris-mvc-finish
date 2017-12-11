package com.accenture.aris.inventory.business.service;

import java.util.List;

import com.accenture.aris.inventory.business.entity.AttendEntity;
import com.accenture.aris.inventory.business.entity.CourseEntity;

public interface AttendService {
	// 添加状态status（int） 1代表正在进行，0代表不在进行
	// 添加次数count （int）
	// 去除date
	public List<CourseEntity> SelectAttendingCourse(String userID);

	public List<CourseEntity> SelectUnAttendingCourse(String userID);

	public boolean AddAttendence(int cno, String attendenceID); // 添加count考勤次数作为参数

	public List<AttendEntity> selectAttendenceDetail(int cno);

	public boolean IsAttend(String userID, String attendenceID);

	public boolean IsNotAttend(String userID, String attendenceID);
	
	public boolean endAttend(int cno, int count);
	
	public List<AttendEntity> selectAttendByIdCno(int cno, String user,String state) ;
	
	public List<AttendEntity> selectAttendByCnoCount(int cno, int count);
	
	public List<AttendEntity> selectAttendenceDetail(Integer cno, int status);
	
	public int MaxCount(int cno);
}

package com.accenture.aris.inventory.business.service;

import com.accenture.aris.inventory.business.entity.AttendEntity;
import com.accenture.aris.inventory.business.entity.CourseEntity;

public interface AttendService {
	//添加状态status（int） 1代表正在进行，0代表不在进行
	//添加次数count （int）
	//去除date
	public CourseEntity SelectAttendingCourse(String userID);
	public boolean AddAttendence(int cno,String attendenceID, int count); //添加count考勤次数作为参数
	public AttendEntity selectAttendenceDetail(int cno);
	public boolean IsAttend(String userID,String attendenceID);
	public boolean IsNotAttend(String userID,String attendenceID);
}

package com.accenture.aris.inventory.business.entity;

import java.sql.Date;

public class AttendanceEntity {
	private int id;
	private String attendenceId;
	private int courseId;
	private String userId;
	private String state;
	private Date startDate;
	private Date endDate;
	
	public AttendanceEntity(){}
	
	public AttendanceEntity(int id, String attendenceId, int courseId, String userId, String state, Date startDate,
			Date endDate) {
		this.id = id;
		this.attendenceId = attendenceId;
		this.courseId = courseId;
		this.userId = userId;
		this.state = state;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	
	
	public AttendanceEntity(int id, String attendenceId, int courseId, Date startDate, Date endDate) {
		super();
		this.id = id;
		this.attendenceId = attendenceId;
		this.courseId = courseId;
		this.startDate = startDate;
		this.endDate = endDate;
	}



	public AttendanceEntity(int id, String attendenceId, int courseId, String userId, String state) {
		super();
		this.id = id;
		this.attendenceId = attendenceId;
		this.courseId = courseId;
		this.userId = userId;
		this.state = state;
	}



	public String getAttendenceId() {
		return attendenceId;
	}
	public void setAttendenceId(String attendenceId) {
		this.attendenceId = attendenceId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}

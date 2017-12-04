package com.accenture.aris.inventory.business.entity;

import java.sql.Date;

public class AttendEntity {
	private int id;
	private String attendenceId;
	private int courseId;
	private String userId;
	private String state;
	private int status;
	private int count;
	
	public AttendEntity(){}
	
	public AttendEntity(int id, String attendenceId, int courseId, int status, int count) {
		this.id = id;
		this.attendenceId = attendenceId;
		this.courseId = courseId;
		this.status = status;
		this.count = count;
	}
	
	public AttendEntity(int id, String attendenceId, int courseId, String userId, String state, int status, int count) {
		super();
		this.id = id;
		this.attendenceId = attendenceId;
		this.courseId = courseId;
		this.userId = userId;
		this.state = state;
		this.status = status;
		this.count = count;
	}

	public AttendEntity(int id, String attendenceId, int courseId, String userId, String state) {
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}

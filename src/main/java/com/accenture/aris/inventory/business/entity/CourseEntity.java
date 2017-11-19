package com.accenture.aris.inventory.business.entity;

public class CourseEntity {
	private int cno;
	private String cname;
	private String invitation;
	private String teacher;
	private int credit;
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getInvitation() {
		return invitation;
	}
	public void setInvitation(String invitation) {
		this.invitation = invitation;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	
}

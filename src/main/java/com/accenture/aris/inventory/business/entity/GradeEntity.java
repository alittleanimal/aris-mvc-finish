package com.accenture.aris.inventory.business.entity;

public class GradeEntity {
	private String testid;
	private int cno;
	private String cname;
	private String testname;
	private String time;
	private int gradeid;
	private String username;
	private int grade;
	
	public GradeEntity() {
		// TODO Auto-generated constructor stub
	}

	public GradeEntity(String testid, int cno, String cname, String testname, String time, int gradeid, String username,
			int grade) {
		this.testid = testid;
		this.cno = cno;
		this.cname = cname;
		this.testname = testname;
		this.time = time;
		this.gradeid = gradeid;
		this.username = username;
		this.grade = grade;
	}

	public String getTestid() {
		return testid;
	}

	public void setTestid(String testid) {
		this.testid = testid;
	}

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

	public String getTestname() {
		return testname;
	}

	public void setTestname(String testname) {
		this.testname = testname;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getGradeid() {
		return gradeid;
	}

	public void setGradeid(int gradeid) {
		this.gradeid = gradeid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
	
	
	
}

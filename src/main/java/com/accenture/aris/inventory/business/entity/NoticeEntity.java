package com.accenture.aris.inventory.business.entity;

public class NoticeEntity {
	private int notice_id;
	private String userid;
	private String context;
	private String title;
	private String teachername;
	
	public NoticeEntity() {
	}
	
	public NoticeEntity(int notice_id, String useridString, String contextString, String title, String teachername) {
		this.notice_id = notice_id;
		this.userid = useridString;
		this.context = contextString;
		this.title = title;
		this.teachername = teachername;
	}

	public int getNotice_id() {
		return notice_id;
	}

	public void setNotice_id(int notice_id) {
		this.notice_id = notice_id;
	}

	public String getUseridString() {
		return userid;
	}

	public void setUseridString(String useridString) {
		this.userid = useridString;
	}

	public String getContextString() {
		return context;
	}

	public void setContextString(String contextString) {
		this.context = contextString;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	
	
}

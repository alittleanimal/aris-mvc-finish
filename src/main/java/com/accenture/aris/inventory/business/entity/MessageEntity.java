package com.accenture.aris.inventory.business.entity;

import java.sql.Date;

public class MessageEntity {
	private String messageid;
	private int cno;
	private String userid;
	private String text;
	private int reply;
	private String name;

	public MessageEntity() {
	}

	public MessageEntity(String messageid, int cno, String userid, String text, int reply) {
		this.messageid = messageid;
		this.cno = cno;
		this.userid = userid;
		this.text = text;
		this.reply = reply;
	}

	public String getMessageid() {
		return messageid;
	}

	public void setMessageid(String messageid) {
		this.messageid = messageid;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getReply() {
		return reply;
	}

	public void setReply(int reply) {
		this.reply = reply;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

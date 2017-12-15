package com.accenture.aris.inventory.business.service;

import java.util.List;

import com.accenture.aris.inventory.business.entity.NoticeEntity;

public interface NoticeService {
	public List<NoticeEntity> noticeDetail(); //获取所有notice表中内容
	public boolean createNotice (NoticeEntity record); //插入一条notice
}

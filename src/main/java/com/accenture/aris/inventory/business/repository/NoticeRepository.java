package com.accenture.aris.inventory.business.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.accenture.aris.inventory.business.entity.NoticeEntity;

@Repository
public interface NoticeRepository {
	
	List<NoticeEntity> noticeDetail();
	//获取所有notice表中内容
	int createNotice(NoticeEntity record); //插入一条notice
}

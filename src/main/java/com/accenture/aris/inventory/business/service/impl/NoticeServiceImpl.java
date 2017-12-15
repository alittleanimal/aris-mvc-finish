package com.accenture.aris.inventory.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.aris.inventory.business.entity.NoticeEntity;
import com.accenture.aris.inventory.business.repository.NoticeRepository;
import com.accenture.aris.inventory.business.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeRepository noticeRepository;
	
	@Override
	public List<NoticeEntity> noticeDetail() {
		List<NoticeEntity> noticeEntities = noticeRepository.noticeDetail();
		return noticeEntities;
	}

	@Override
	public boolean createNotice(NoticeEntity record) {
		int temp = noticeRepository.createNotice(record);
		if (temp != 0) {
			return true;
		}else {
			return false;
		}
	}

}

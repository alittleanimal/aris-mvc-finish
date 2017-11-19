package com.accenture.aris.inventory.business.repository;

import com.accenture.aris.inventory.business.entity.MessageEntity;

public interface MessageRepository {
	MessageEntity selectByMessageId(int messageId);
	int update(MessageEntity record);
	int insert(MessageEntity record);
	int deleteByMessageId(int messageId);
}

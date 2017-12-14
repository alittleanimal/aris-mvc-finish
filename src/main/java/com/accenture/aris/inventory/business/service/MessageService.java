package com.accenture.aris.inventory.business.service;

import java.util.List;

import com.accenture.aris.inventory.business.entity.MessageEntity;

public interface MessageService {
	boolean createMessage(MessageEntity messageEntity); // 创建一条留言 reply=1

	List<MessageEntity> messageDetail(int cno, int reply); // 根据留言种类和课程号查询留言信息

	List<MessageEntity> messageReply(String messageid); // 根据留言ID查询留言信息

	boolean replyMessage(MessageEntity messageEntity, String targetMessageID);
	
}

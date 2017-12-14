package com.accenture.aris.inventory.business.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.accenture.aris.inventory.business.entity.MessageEntity;

@Repository
public interface MessageRepository {
	MessageEntity selectByMessageId(int messageid);

	int deleteByMessageId(int messageid);

	int createMessage(MessageEntity messageEntity); // 创建一条留言 reply=1

	List<MessageEntity> messageDetail(int cno, int reply); // 根据留言种类和课程号查询留言信息

	List<MessageEntity> messageReply(String messageid); // 根据留言ID查询留言信息

	int createMessageReply(String targetMessageid, String replyMessageid);
	
	int changeReply (String messageID , int Reply);
	
}

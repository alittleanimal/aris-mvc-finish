package com.accenture.aris.inventory.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.aris.inventory.business.entity.MessageEntity;
import com.accenture.aris.inventory.business.repository.MessageRepository;
import com.accenture.aris.inventory.business.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageRepository messageRepository;

	@Override
	public boolean createMessage(MessageEntity messageEntity) {
		int temp = messageRepository.createMessage(messageEntity);
		if (temp == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<MessageEntity> messageDetail(int cno, int reply) {
		List<MessageEntity> messageEntities = messageRepository.messageDetail(cno, reply);
		return messageEntities;
	}

	@Override
	public List<MessageEntity> messageReply(String messageid) {
		List<MessageEntity> messageEntities = messageRepository.messageReply(messageid);
		return messageEntities;
	}

	@Override
	public boolean replyMessage(MessageEntity messageEntity, String targetMessageID) {
		int temp = messageRepository.createMessage(messageEntity);
		if (temp == 0) {
			return false;
		}
		temp = messageRepository.createMessageReply(targetMessageID, messageEntity.getMessageid());
		if (temp == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean changeReply(String messageID, int Reply) {
		int temp = messageRepository.changeReply(messageID, Reply);
		if (temp == 0) {
			return false;
		} else {
			return true;
		}
	}
}

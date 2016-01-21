package com.intelligrated.service;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

public class InboundHttpMessageHandler implements MessageHandler {

	@Override
	public void handleMessage(Message<?> message) throws MessagingException {
		System.out.println(" InboundHttpMessageHandler" + message.getPayload());

	}

}

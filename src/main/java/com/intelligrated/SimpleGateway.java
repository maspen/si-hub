package com.intelligrated;

import org.springframework.messaging.Message;

public interface SimpleGateway {
//	public String send(String text);
	public Message<?> sendMessage(Message<?> messge);
}

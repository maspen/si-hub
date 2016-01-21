package com.intelligrated.service;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * printes http responses
 * 
 * @author matt.aspen
 *
 */

@Component
public class InboundHTTPPrinterService {

	public String printFromHttp(Message<?> message) {
		System.out.println(" InboundHTTPPrinterService msg: " + message.getPayload());
		return message.getPayload().toString();
	}
}

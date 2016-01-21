package com.intelligrated.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.intelligrated.SimpleGateway;

//@Component
public class StdInService implements Runnable {
	@Autowired
	SimpleGateway gateway;
	
	@Override
	public void run() {
		final Scanner scanner = new Scanner(System.in);
		
		System.out.println("start typing, type 'quit' to exit");
		
		while(true) {
			String input = scanner.nextLine();
			if("quit".equalsIgnoreCase(input.trim())) {
				System.out.println(" exiting SI Hub");
				break;
			} else {
//				String reply = gateway.send(input);
				Message<?> reply = gateway.sendMessage(MessageBuilder.withPayload(input).build());
				System.out.println("SI HUB from TCP server: " + reply.getPayload());
			}
		}
		System.out.println(" SI HUB exiting.");
		scanner.close();
		System.exit(0);
	}

}

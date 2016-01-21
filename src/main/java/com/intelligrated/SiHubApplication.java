package com.intelligrated;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import com.intelligrated.service.StdInService;

@SpringBootApplication
public class SiHubApplication implements CommandLineRunner {
	@Autowired
	SimpleGateway gateway;
//	@Autowired
//	StdInService stdInService;
	
	public static void main(String[] args) {
		SpringApplication.run(SiHubApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
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
				System.out.println("SI HUB from TCP server: [" + reply.getPayload() +"]");
			}
		}
		System.out.println(" SI HUB exiting.");
		scanner.close();
		System.exit(0);
//		new Thread(stdInService).start();	
	}
}

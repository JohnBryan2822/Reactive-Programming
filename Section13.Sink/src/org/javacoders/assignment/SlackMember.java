package org.javacoders.assignment;

import java.util.function.Consumer;

public class SlackMember {
	
	private String name;
	private Consumer<String> messageConsumer;
	
	public SlackMember(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	void receives(String message) {
		System.out.println(message);
	}
	
	public void says(String message) {
		this.messageConsumer.accept(message);
	}
	
	void setMessageConsumer(Consumer<String> messageConsumer) {
		this.messageConsumer = messageConsumer;
	}
	

}

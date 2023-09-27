package org.javacoders.assignment;

public class SlackMessage {

	private static final String FORMAT = "[%s -> %s] : %s";
	
	private String sender;
	private String receiver;
	private String message;
	public String getSender() {
		return sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public String getMessage() {
		return message;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return String.format(FORMAT, this.sender, this.receiver, this.message);
	}
	
	
}

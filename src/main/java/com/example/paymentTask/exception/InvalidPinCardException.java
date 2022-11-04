package com.example.paymentTask.exception;

public class InvalidPinCardException extends Exception {

	private static final long serialVersionUID = 1L;

	String messageId;

	public InvalidPinCardException(String messageId) {
		super();
		this.messageId = messageId;
	}

	public String getMessageId() {
		return messageId;
	}
}

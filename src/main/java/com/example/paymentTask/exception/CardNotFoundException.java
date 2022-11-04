package com.example.paymentTask.exception;

public class CardNotFoundException extends Exception {


	public String getMessageId() {
		return messageId;
	}

	private static final long serialVersionUID = -761503632186596342L;
	String messageId;

	public CardNotFoundException(String messageId) {
		super();
		this.messageId = messageId;
		
	}

}

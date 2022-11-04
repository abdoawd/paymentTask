package com.example.paymentTask.exception;

public class CardDeactivatedException extends Exception {
	/**
	 * 
	 */
	public String getMessageId() {
		return messageId;
	}

	private static final long serialVersionUID = 1L;
	String messageId;

	public CardDeactivatedException(String message) {
		super();
		this.messageId = messageId;
	}

}

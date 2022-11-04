package com.example.paymentTask.exception;

public class NoSufficientBalanceException extends Exception {
	/**
	 * 
	 */
	public String getMessageId() {
		return messageId;
	}

	private static final long serialVersionUID = 1L;
	String messageId;

	public NoSufficientBalanceException(String messageId) {
		super();
		this.messageId = messageId;
	}
}

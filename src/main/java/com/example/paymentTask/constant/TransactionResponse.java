package com.example.paymentTask.constant;

public interface TransactionResponse {

 int CODE_APPROVED = 00;
 int CODE_EXTERNAL_DECLINE = 05;
 int CODE_TRANSACTION_NOT_SUPPORTED = 12;
 int CODE_WITHDRAWAL_AMOUNT_EXCEEDED = 13;
 int CODE_INVALID_AMOUNT = 13;
 int CODE_INVALID_CARD = 14;
 int CODE_MESSAGE_EDIT_ERROR = 30;
 int CODE_RESTRICTED_CARD = 36;
 int CODE_LOST_CARD = 41;
 int CODE_Stolen_CARD = 43;
 int CODE_INSUFFICIENT_FUNDS = 51;
 int CODE_EXPIRED_CARD = 54;
 int CODE_INVALID_PIN = 55;
 int CODE_INVALID_CVV = 57;
 int CODE_WITHDRAWAL_LIMIT_EXCEEDED = 61;

}

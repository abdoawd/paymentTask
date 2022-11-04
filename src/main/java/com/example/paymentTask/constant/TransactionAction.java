package com.example.paymentTask.constant;

import com.example.paymentTask.exception.CardDeactivatedException;
import com.example.paymentTask.exception.CardNotFoundException;
import com.example.paymentTask.exception.NoSufficientBalanceException;
import com.example.paymentTask.model.FinancialTransaction;

public interface TransactionAction {

    public void financial(FinancialTransaction financialTransaction) throws CardNotFoundException, CardDeactivatedException, NoSufficientBalanceException;
    public void reversal(FinancialTransaction financialTransaction) ;
    public void process(FinancialTransaction financialTransaction) throws CardNotFoundException, CardDeactivatedException, NoSufficientBalanceException;
}

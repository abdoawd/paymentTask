package com.example.paymentTask.service;

import com.example.paymentTask.constant.TransactionAction;
import com.example.paymentTask.constant.TransactionConstant;
import com.example.paymentTask.exception.CardDeactivatedException;
import com.example.paymentTask.exception.CardNotFoundException;
import com.example.paymentTask.exception.NoSufficientBalanceException;
import com.example.paymentTask.model.FinancialTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TransactionHandlerService implements TransactionAction {

    @Autowired
    WithdrawalHandlerService withdrawalHandlerService;

    @Override
    public void financial(FinancialTransaction financialTransaction) throws CardNotFoundException, CardDeactivatedException, NoSufficientBalanceException {

        withdrawalHandlerService.financial(financialTransaction);

    }

    @Override
    public void reversal(FinancialTransaction reversalTransaction) {

    }

    @Override
    public void process(FinancialTransaction transaction) throws CardNotFoundException, CardDeactivatedException, NoSufficientBalanceException {
        switch (transaction.getActionCode()) {
            case TransactionConstant.ACTION_PURCHASE:
            case TransactionConstant.ACTION_WITHDRAWAL:
                financial(transaction);
                break;
            case TransactionConstant.ACTION_REFUND:
                reversal(transaction);
                break;

        }
    }
}

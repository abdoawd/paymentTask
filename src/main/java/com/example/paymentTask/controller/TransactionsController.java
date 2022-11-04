package com.example.paymentTask.controller;


import com.example.paymentTask.exception.CardDeactivatedException;
import com.example.paymentTask.exception.CardNotFoundException;
import com.example.paymentTask.exception.NoSufficientBalanceException;
import com.example.paymentTask.model.FinancialTransaction;
import com.example.paymentTask.service.TransactionHandlerService;
import com.example.paymentTask.util.TransactionsUtil;
import org.jpos.core.InvalidCardException;
import org.jpos.iso.ISOMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.Utilities;

@RestController
@RequestMapping("/transactios")
public class TransactionsController {

    @Autowired
    TransactionHandlerService service ;


    @Autowired
    TransactionsUtil util ;

    @PostMapping("/receive")
    public ISOMsg  receive (@RequestBody ISOMsg msg ) throws InvalidCardException, CardNotFoundException, CardDeactivatedException, NoSufficientBalanceException {

        service.process(util.convertIsoToObject(msg));

        return util.PrepareResponse(msg);
    }
}

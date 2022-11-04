package com.example.paymentTask.service;

import com.example.paymentTask.constant.CardStatus;
import com.example.paymentTask.entity.Card;
import com.example.paymentTask.exception.CardDeactivatedException;
import com.example.paymentTask.exception.CardNotFoundException;
import com.example.paymentTask.exception.NoSufficientBalanceException;
import com.example.paymentTask.hsm.HsmServiceImpl;
import com.example.paymentTask.model.FinancialTransaction;
import com.example.paymentTask.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class WithdrawalHandlerService {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    HsmServiceImpl hsmService ;

    void financial(FinancialTransaction transaction) throws CardDeactivatedException, CardNotFoundException, NoSufficientBalanceException {
        // validate the card { exist , status , expiry }
        validateCard(transaction.getCardHolder().getPAN());
        hsmService.verifyPin("pinKey" ,  "pin block "/* DE 52*/ ,"command" , "offset" );

        checkBalance(transaction.getCardHolder().getPAN(),transaction.getTransactionAmount());

    }

    private void checkBalance(String pan, double transactionAmount) throws NoSufficientBalanceException {
         //  get current balance

        double balance  =  cardRepository.getBalanceByPan(pan);
        if (balance<transactionAmount)
            throw  new NoSufficientBalanceException("No Sufficient Balance ") ;
        else //deduct balance
        cardRepository.deductBalance(pan,transactionAmount) ;

    }

    private void validateCard(String pan) throws CardDeactivatedException, CardNotFoundException {
        Optional<Card> card = cardRepository.findCardStatusByPan(pan);
        if (!card.isPresent())
            throw new CardNotFoundException("Card no found");
        checkCardStatus(card);
    }

    private void checkCardStatus(Optional<Card> card) throws CardDeactivatedException {

        if (card.get().getStatus() != CardStatus.ACTIVE)
            throw new CardDeactivatedException("Card no Active");
        else validateExpiry(card);
    }

    private void validateExpiry(Optional<Card> card) {
        Date expiryDate = card.get().getExpiryDate();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
         expiryDate.compareTo(date);



    }


}

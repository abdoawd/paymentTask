package com.example.paymentTask.util;

import com.example.paymentTask.model.FinancialTransaction;
import org.jpos.core.CardHolder;
import org.jpos.core.InvalidCardException;
import org.jpos.iso.ISODate;
import org.jpos.iso.ISOMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TransactionsUtil {

    @Autowired
    FinancialTransaction transaction;

    public FinancialTransaction convertIsoToObject(ISOMsg isoMsg) throws InvalidCardException {

        transaction.setMessageType(getIsoField(isoMsg, 0));
        transaction.setActionCode(Integer.parseInt(getIsoField(isoMsg, 3).substring(2)));
        transaction.setCardHolder(new CardHolder(getIsoField(isoMsg, 35)));
        transaction.setTransactionAmount(Double.parseDouble(getIsoField(isoMsg, 4)));
        transaction.setTransactionCurrency(Integer.parseInt(getIsoField(isoMsg, 49)));
        transaction.setRrn(getIsoField(isoMsg, 37));
        transaction.setTerminalId(getIsoField(isoMsg, 41));
        transaction.setMerchantId(getIsoField(isoMsg, 42));
        transaction.setTerminalLocation(getIsoField(isoMsg, 43));
        transaction.setLocalDateTime(ISODate.parseISODate(getIsoField(isoMsg, 12) + getIsoField(isoMsg, 13)));
        transaction.setSettlementDate(ISODate.parseISODate(getIsoField(isoMsg, 15)));
        transaction.setCaptureDate(ISODate.parseISODate(getIsoField(isoMsg, 17) + "000000"));
        return transaction;
    }

    private String getIsoField(ISOMsg isoMsg, int i) {

        String msgString = null;
        if (isoMsg.hasField(i))
            msgString = isoMsg.getString(i);

        return msgString;

    }


    public ISOMsg PrepareResponse(ISOMsg msg) {
        msg.set(39,"00");
        return msg;
    }
}

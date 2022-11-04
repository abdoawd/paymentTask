package com.example.paymentTask.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jpos.core.CardHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
@RequestScope
public class FinancialTransaction {
    private int actionCode;
    private CardHolder cardHolder;
    private double transactionAmount;
    private int transactionCurrency;
    private double remainingBalance;
    private String rrn;
    private String terminalId;
    private String merchantId;
    private Date localDateTime;
    private String terminalLocation;
    private Date captureDate;
    private Date settlementDate;
    private String responseCode;
    private String autNumber;
    private String messageType;

}

package com.phan.codeexercise.afterpay.model;

import lombok.Data;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;

@Data
public class Transaction {
    /*
    hashed credit card number
     */
    private final String hashedCreditCard;
    /*
    timestamp - of format 'year-month-dayThour:minute:second'
    Notes, in our case, we only care date but no time.
     */
    private final LocalDate timestamp;
    /*
    price - of format 'dollars.cents'
     */
    private final Double price;

    public Transaction(String hashedCreditCard, LocalDate timestamp, Double price) {
        this.hashedCreditCard = hashedCreditCard;
        this.timestamp = timestamp;

        final NumberFormat formatter = new DecimalFormat("#0.00");
        this.price = Double.valueOf(formatter.format(price));
    }

}

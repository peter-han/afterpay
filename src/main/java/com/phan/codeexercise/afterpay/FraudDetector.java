package com.phan.codeexercise.afterpay;

import com.phan.codeexercise.afterpay.model.Transaction;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

interface FraudDetector {

    /**
     * when given a list transactions, a date and a price threshold T,
     * returns a list of hashed credit card numbers that have been identified as fraudulent for that day.
     *
     * @param transactions
     * @param date         <code>LocalDate</code> ignore time.
     * @param threshold
     * @return
     */
    Set<String> identifyFraudulent(List<Transaction> transactions, LocalDate date, Double threshold);
}

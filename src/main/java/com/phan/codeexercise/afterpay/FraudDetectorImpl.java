package com.phan.codeexercise.afterpay;

import com.phan.codeexercise.afterpay.model.Transaction;
import org.apache.commons.collections4.CollectionUtils;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FraudDetectorImpl implements FraudDetector {

    /**
     * when given a list transactions, a date and a price threshold T,
     * returns a list of hashed credit card numbers that have been identified as fraudulent for that day.
     *
     * @param transactions
     * @param date
     * @param threshold
     * @return
     */
    @Override
    public Set<String> identifyFraudulent(List<Transaction> transactions, LocalDate date, Double threshold) {

        if (null == date || null == threshold) {
            throw new IllegalArgumentException("have to give a date and threshold");
        }

        if (CollectionUtils.isEmpty(transactions)) {
            return Collections.emptySet();
        }

        return transactions.stream()
                // 1. filter by the given date
                .filter(transaction -> date.isEqual(transaction.getTimestamp()))
                // 2. group by credit card number, Map<String, List<transaction>>
                .collect(Collectors.groupingBy(Transaction::getHashedCreditCard))
                // 3. for each entry inside Map, filter by subtotal > threshold
                .entrySet()
                .stream()
                .filter(map -> {
                    final Double subtotal = map.getValue()
                            .stream()
                            .mapToDouble(Transaction::getPrice)
                            .sum();
                    return subtotal > threshold;
                })
                // 4. map to list of credit card
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

}

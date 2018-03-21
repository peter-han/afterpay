package com.phan.codeexercise.afterpay.model;

import com.phan.codeexercise.afterpay.utils.FormatUtils;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class TransactionFactory {

    /*
    eg. '10d7ce2f43e35fa57d1bbf8b1e2, 2014-04-29T13:15:54, 10.00'
     */
    private static final String REGEX_VALID_TRANSACTION_PATTERN = "^\\w*,[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}:[0-9]{2},[+-]?[0-9]{1,3}(?:,?[0-9]{3})*\\.[0-9]{2}$";
    private static final String COMMA = ",";

    private TransactionFactory() {
    }

    public static Transaction createTransaction(String record) {

        /*
        parse values
         */
        String[] txDetails = parseTransaction(record);
        String hashedCreditCard = txDetails[0];
        LocalDate timestamp = FormatUtils.parseDate(txDetails[1]);
        Double price = Double.parseDouble(txDetails[2]);

        return new Transaction(hashedCreditCard, timestamp, price);
    }

    /**
     * Transactions are to be received as a comma separated string of elements eg. '10d7ce2f43e35fa57d1bbf8b1e2, 2014-04-29T13:15:54, 10.00'
     *
     * @param tx
     * @return
     */
    static String[] parseTransaction(String tx) {
        if (StringUtils.isEmpty(tx)) {
            throw new IllegalArgumentException();
        }

        final String input = tx.replaceAll("\\s+", "");
        final Pattern pattern = Pattern.compile(REGEX_VALID_TRANSACTION_PATTERN);
        if (!pattern.matcher(input).matches()) {
            throw new IllegalArgumentException("invalid transaction string");
        }

        return input.split(COMMA);
    }
}

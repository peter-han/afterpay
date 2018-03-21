package com.phan.codeexercise.afterpay;

import com.phan.codeexercise.afterpay.model.Transaction;
import com.phan.codeexercise.afterpay.model.TransactionFactory;
import com.phan.codeexercise.afterpay.utils.FormatUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class FraudDetectorTest {

    private final FraudDetector detector = new FraudDetectorImpl();
    private final LocalDate date = FormatUtils.parseDate("2014-04-29T13:15:54");
    private final Double threshold = 700.00;

    @Test
    public void testIdentifyFraudulent() {
        List<Transaction> transactions = loadTestTransaction();

        Set<String> cards = detector.identifyFraudulent(transactions, date, threshold);

        Assert.assertNotNull(cards);
        Assert.assertEquals(1, cards.size());
        Assert.assertTrue(cards.contains("10d7ce2f43e35fa57d1bbf8b1e2"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIdentifyFraudulentMissingDate() {
        detector.identifyFraudulent(Collections.EMPTY_LIST, null, threshold);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIdentifyFraudulentMissingThreshold() {
        detector.identifyFraudulent(Collections.EMPTY_LIST, date, null);
    }

    @Test
    public void testIdentifyFraudulentEmptyTransactions() {
        Set<String> result = detector.identifyFraudulent(Collections.EMPTY_LIST, date, threshold);

        Assert.assertNotNull(result);
        Assert.assertEquals(0, result.size());
    }

    /**
     * load predefined transactions from txt file.
     *
     * @return
     */
    private List<Transaction> loadTestTransaction() {
        //Get file from resources folder
        InputStream inputStream = getClass().getResourceAsStream("test-transactions.txt");
        List<String> transactions = new ArrayList<>();

        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            transactions.add(line);
        }

        scanner.close();

        return transactions.stream()
                .map(TransactionFactory::createTransaction)
                .collect(Collectors.toList());
    }
}
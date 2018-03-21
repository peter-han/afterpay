package com.phan.codeexercise.afterpay.model;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class TransactionTest {

    @Test
    public void testInstance() {
        String hashedCreditCard = "23249ce2f43e35fa57d1bbf8b1e";
        LocalDate timestamp = LocalDate.now();
        Double price = 100.00;

        final Transaction tx = new Transaction(hashedCreditCard, timestamp, price);
        Assert.assertNotNull(tx);
    }

    @Test
    public void testPriceAmountRoundCents() {
        String hashedCreditCard = "23249ce2f43e35fa57d1bbf8b1e";
        LocalDate timestamp = LocalDate.now();
        Double price = 100.879;

        final Transaction tx = new Transaction(hashedCreditCard, timestamp, price);
        Assert.assertTrue(100.88 == tx.getPrice());
    }

    @Test
    public void testEquals() {
        final Transaction tx1 = TransactionFactory.createTransaction("23249ce2f43e35fa57d1bbf8b1e, 2014-04-29T13:15:54, 87.47");
        final Transaction tx3 = TransactionFactory.createTransaction("23249ce2f43e35fa57d1bbf8b1e, 2014-04-29T18:15:54, 87.47");

        /*
        same cards, date, amount, but different time, we think they are equals
         */
        Assert.assertEquals(tx1, tx3);
    }
}
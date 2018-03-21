package com.phan.codeexercise.afterpay.model;

import org.junit.Assert;
import org.junit.Test;

public class TransactionFactoryTest {

    @Test
    public void testParseTransactionString() {
        String[] tx = TransactionFactory.parseTransaction("10d7ce2f43e35fa57d1bbf8b1e2, 2014-04-29T13:15:54, 10.00");

        Assert.assertEquals(3, tx.length);
        Assert.assertEquals("10d7ce2f43e35fa57d1bbf8b1e2", tx[0]);
        Assert.assertEquals("2014-04-29T13:15:54", tx[1]);
        Assert.assertEquals("10.00", tx[2]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseTransactionStringEmptyString() {
        TransactionFactory.parseTransaction(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseTransactionStringInvalidString() {
        TransactionFactory.parseTransaction("this is an invalid transaction string");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseTransactionStringInvalidDate() {
        TransactionFactory.parseTransaction("10d7ce2f43e35fa57d1bbf8b1e2, 2014/04/29, 10.00");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseTransactionStringInvalidPrice() {
        TransactionFactory.parseTransaction("10d7ce2f43e35fa57d1bbf8b1e2,  2014-04-29T13:15:54, a100");
    }

    @Test
    public void testCreateTransaction() {
        final Transaction tx = TransactionFactory.createTransaction("23249ce2f43e35fa57d1bbf8b1e, 2014-04-29T13:15:54, 87.47");
        Assert.assertNotNull(tx);
    }
}
package com.phan.codeexercise.afterpay.utils;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class FormatUtilsTest {

    @Test
    public void testFormatDate() {
        final LocalDate date = FormatUtils.parseDate("2014-04-29T13:15:54");

        Assert.assertEquals(2014, date.getYear());
        Assert.assertEquals(4, date.getMonthValue());
        Assert.assertEquals(29, date.getDayOfMonth());
    }

    @Test(expected = DateTimeParseException.class)
    public void testFormatDateInvalid() {
        FormatUtils.parseDate("04/29/2014");
    }

    @Test(expected = DateTimeParseException.class)
    public void testFormatDateInvalidWithoutTime() {
        FormatUtils.parseDate("2014-04-29");
    }

}
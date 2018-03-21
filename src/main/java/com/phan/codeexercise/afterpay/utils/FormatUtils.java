package com.phan.codeexercise.afterpay.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatUtils {

    private static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";

    private FormatUtils() {
    }

    /**
     * String to Date by format pattern 'year-month-dayThour:minute:second'
     * eg. '2014-04-29T13:15:54'
     *
     * @param date
     * @return
     */
    public static LocalDate parseDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN));
    }

}

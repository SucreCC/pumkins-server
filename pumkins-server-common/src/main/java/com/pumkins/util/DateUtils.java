package com.pumkins.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: dengKai
 * @date: 2022/02/15 22:09
 * @description:
 */

public class DateUtils {
    private static final Long TIME_FOR_A_DAY = (long) 24 * 60 * 60 * 1000;
    private static final int ONE_MONTH = 30;
    private static final int ONE_YEAR = 365;

    public static String getYMD() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }


    /**
     * compare the date to current date
     *
     * @param date
     * @return
     */
    public static String getDay(Date date) {
        int rawDay = (int) ((System.currentTimeMillis() - date.getTime()) / TIME_FOR_A_DAY);
        int year = rawDay / ONE_YEAR;
        int month = (rawDay - year * ONE_YEAR) / ONE_MONTH;
        int date1 = rawDay - year * ONE_YEAR - month * ONE_MONTH;

        String day = "";
        if (year > 0) {
            day = year + " years ";
        }
        if (month > 0) {
            day = day + month + " month ";
        }

        if (date1 > 0){
            day = day + date1 + " days ago";
        }

            return day;
    }
}

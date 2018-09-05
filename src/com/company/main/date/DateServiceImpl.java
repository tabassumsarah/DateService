package com.company.main.date;

import com.company.main.date.util.DateValidator;

public class DateServiceImpl implements DateService {
    private static DateValidator validator = new DateValidator();

    private int getYear(String date) {
        return Integer.parseInt(date.substring(0, 4));
    }

    private int getDay(String date) {
        return Integer.parseInt(date.substring(8, 10));

    }

    private int getMonth(String date) {
        return Integer.parseInt(date.substring(6, 7));

    }

    private double getJulianDays(String date) {
        int year = getYear(date);
        int day = getDay(date);
        int month = getMonth(date);
        double A = year / 100;
        double B = A / 4;
        double C = 2 - A + B;
        double E = 365.25 * (year + 4716);
        double F = 30.6001 * (month + 1);
        return C + day + E + F - 1524.5;
    }


    private int returnDaysBetweenDates(String day1, String day2) throws Exception {
        if (!day1.isEmpty() && !day2.isEmpty() && validator.isValid(day1) && validator.isValid(day2)) {
            return Math.abs((int) (getJulianDays(day1) - getJulianDays(day2))) - 1;
        } else {
            throw new Exception("Exception occurred, please try again later");
        }
    }

    public int getDaysBetweenTwoDates(String date1, String date2) throws Exception {
        return returnDaysBetweenDates(date1, date2);
    }
}

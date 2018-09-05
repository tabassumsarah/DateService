package com.company.test;
import com.company.main.date.DateServiceImpl;
import org.hamcrest.core.StringContains;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.assertEquals;


public class DateServiceTests {
    @Rule
    public ExpectedException ruleOfException = ExpectedException.none();

    @Test
    public void should_returnOneIfDateDifferenceIsTwo() {
        String dateOne = "2012-01-01";
        String dateTwo = "2012-01-03";

        LocalDate dateBefore = LocalDate.parse(dateOne);
        LocalDate dateAfter = LocalDate.parse(dateTwo);
        long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);

        DateServiceImpl service = new DateServiceImpl();
        try {
            assertEquals(noOfDaysBetween - 1, service.getDaysBetweenTwoDates(dateOne, dateTwo));
        } catch (Exception e) {
        }
    }

    @Test
    public void should_returnZeroIfDateDifferenceIsOne() {
        String dateOne = "2012-01-01";
        String dateTwo = "2012-01-02";

        LocalDate dateBefore = LocalDate.parse(dateOne);
        LocalDate dateAfter = LocalDate.parse(dateTwo);
        long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);

        DateServiceImpl service = new DateServiceImpl();
        try {
            assertEquals(noOfDaysBetween - 1, service.getDaysBetweenTwoDates(dateOne, dateTwo));
        } catch (Exception e) {
        }
    }

    @Test
    public void should_returnFalseIfDateFormatIsNotYYYYDDMM() throws Exception {
        String dateOne = "01-01-2001";
        String dateTwo = "2012-01-03";
        ruleOfException.expect(NumberFormatException.class);
        ruleOfException.expectMessage(StringContains.containsString("Date format is invalid: "));
        ruleOfException.expectMessage("Date format is invalid: " + dateOne + " Please use yyyy-mm-dd");
        DateServiceImpl service = new DateServiceImpl();
        service.getDaysBetweenTwoDates(dateOne, dateTwo);
    }

    @Test
    public void should_returnFalseIfDateContainsNonNumericCharracter() throws Exception {
        String dateOne = "201x-01-01";
        String dateTwo = "2012-01-03";
        ruleOfException.expect(NumberFormatException.class);
        ruleOfException.expectMessage("Date format is invalid: " + dateOne + " Please use yyyy-mm-dd");
        DateServiceImpl service = new DateServiceImpl();
        service.getDaysBetweenTwoDates(dateOne, dateTwo);
    }

    @Test
    public void should_returnFalseIfMonthIsGreaterThan12() throws Exception {
        String dateOne = "2011-13-01";
        String dateTwo = "2012-01-03";
        ruleOfException.expect(Exception.class);
        ruleOfException.expectMessage("Date range is invalid. Please use dates between " +
                "1901-01-01 and " + "2999-12-31.");
        DateServiceImpl service = new DateServiceImpl();
        service.getDaysBetweenTwoDates(dateOne, dateTwo);
    }

    @Test
    public void should_returnFalseIf30DaysMonthHas31Days() throws Exception {
        String[] datesFor30DaysMonth = new String[4];
        // Apr, June, Jul, Sep
        datesFor30DaysMonth[0] = "2012-04-31";
        datesFor30DaysMonth[1] = "2012-06-31";
        datesFor30DaysMonth[2] = "2012-09-31";
        datesFor30DaysMonth[3] = "2012-11-31";
        for (String date : datesFor30DaysMonth) {
            ruleOfException.expect(Exception.class);
            ruleOfException.expectMessage("Month for" + date + " is 30 day only!");

            DateServiceImpl service = new DateServiceImpl();
            service.getDaysBetweenTwoDates(date, date);
        }
    }

    @Test
    public void should_returnFalseIfFebruaryHasMoreThan29Days() throws Exception {
        String dateOne = "2011-02-31";
        String dateTwo = "2012-02-31";
        ruleOfException.expect(Exception.class);
        ruleOfException.expectMessage(StringContains.containsString("Non Leap Year can not have more than 28 days in February "));
        DateServiceImpl service = new DateServiceImpl();
        service.getDaysBetweenTwoDates(dateOne, dateTwo);
    }

    @Test
    public void should_ReturnFalseIfFebruaryHas28DaysIfLEapYear() throws Exception {
        String dateOne = "2016-02-31";
        String dateTwo = "2016-02-31";
        ruleOfException.expect(Exception.class);
        ruleOfException.expectMessage(StringContains.containsString("Leap years can not have more than 29 days in " +
                "February! "));
        DateServiceImpl service = new DateServiceImpl();
        service.getDaysBetweenTwoDates(dateOne, dateTwo);
    }

    @Test
    public void should_shouldLorErrorIfDateIsBefore19010101() throws Exception {
        String dateOne = "1900-01-01";
        String dateTwo = "2012-01-03";
        ruleOfException.expect(Exception.class);
        ruleOfException.expectMessage(StringContains.containsString("Date range is invalid. Please use dates between " +
                "1901-01-01 and " + "2999-12-31."));
        DateServiceImpl service = new DateServiceImpl();
        service.getDaysBetweenTwoDates(dateOne, dateTwo);
    }

    @Test
    public void should_shouldLorErrorIfDateIsAfter29991231() throws Exception {
        String dateOne = "3000-01-01";
        String dateTwo = "2012-01-03";
        ruleOfException.expect(Exception.class);
        ruleOfException.expectMessage(StringContains.containsString("Date range is invalid. Please use dates between " +
                "1901-01-01 and " + "2999-12-31."));
        DateServiceImpl service = new DateServiceImpl();
        service.getDaysBetweenTwoDates(dateOne, dateTwo);
    }
}

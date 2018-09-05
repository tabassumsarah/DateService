package com.company.main.date.util;
public class DateValidator implements Validator{

    private boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    // Logic for calculating days in a month.
    private int returnDaysOfMonth(String date) {
        int daysInMonth;
        boolean leapYear;

        String date1Year = date.substring(0, 4);
        int year = Integer.parseInt(date1Year);

        String date1Month = date.substring(5, 7);
        int month = Integer.parseInt(date1Month);

        leapYear = isLeapYear(year);
        if (month == 4 || month == 6 || month == 9 || month == 11){
            daysInMonth = 30;
        }else if(month == 2){
            daysInMonth = (leapYear) ? 29 : 28;
        }else{
            daysInMonth = 31;
        }
        return daysInMonth;
    }

    /**
     This private method delegates some of the validation logic to DateFormatValidator and
     DateRangeValidator. This method contains logic for validating correct days in a month.
     @see DateFormatValidator
     @see DateRangeValidator
     **/

    private boolean isValidDate(String date, Validator dateFormat, Validator dateRange) throws Exception {
        if (dateFormat.isValid(date)) {
            if (dateRange.isValid(date)) {
                int daysOfMonth = returnDaysOfMonth(date);
                String date1Day = date.substring(8, 10);
                int day = Integer.parseInt(date1Day);
                switch (daysOfMonth) {
                    case 29:
                        if(day>29){
                            throw new Exception("Leap years can not have more than 29 days in February! ");
                        }
                        return true;
                    case 28:
                        if(day>28){
                            throw new Exception("Non Leap Year can not have more than 28 days in February ");
                        }
                        return true;
                    case 30:
                        if(day>30){
                            throw new Exception("Month for" + date + " is 30 day only!");
                        }
                        return true;

                    case 31:
                        return day <= 31;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param date
     * @return true if date passes all the validation and false otherwise
     * @throws Exception
     */
     public boolean isValid(String date) throws Exception {
        Validator dateFormatValidator = new DateFormatValidator();
        Validator dateRangeValidator = new DateRangeValidator();
        return isValidDate(date, dateFormatValidator,dateRangeValidator);
    }
}

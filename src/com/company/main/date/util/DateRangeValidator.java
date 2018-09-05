package com.company.main.date.util;
import java.util.regex.Pattern;

class DateRangeValidator implements Validator{
    private static Pattern DATE_PATTERN = Pattern.compile(
            "^((19[0-9][1-9]|2[0-9][0-9]{2}))-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$");

    @Override
    public boolean isValid(String date) throws Exception {
        if(!DATE_PATTERN.matcher(date).matches()){
            throw new Exception("Date range is invalid. Please use dates between " +
                    "1901-01-01 and " + "2999-12-31.");
        }
        return true;
    }
}

package com.company.main.date.util;
import java.util.regex.Pattern;

class DateFormatValidator implements Validator{
    private static Pattern DATE_PATTERN = Pattern.compile(
            "^\\d{4}-\\d{2}-\\d{2}$");

    @Override
    public boolean isValid(String date) throws Exception {
        if(!DATE_PATTERN.matcher(date).matches()){
            throw new NumberFormatException("Date format is invalid: "+ date +" Please use yyyy-mm-dd");
        }
        return true;
    }
}

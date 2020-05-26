package com.epam.webdriver.utils;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    protected DateUtils dateUtils = new DateUtils();

    public String getCurrentTimeAsString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "uuuu-MM-dd_HH-mm-ss" );
        return ZonedDateTime.now().format(formatter);
    }
}

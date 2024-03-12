package org.example.ranks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvertor {
    public static void main(String[] args) throws ParseException {
        System.out.println(timeConversion("10:30:00PM"));
        System.out.println(timeConversion("07:05:45PM"));
    }

    public static String timeConversion(String s) throws ParseException {
        // Write your code here
        SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm:ssa");
        Date date = parseFormat.parse(s);
        parseFormat.format(date);
        return displayFormat.format(date);
    }
}

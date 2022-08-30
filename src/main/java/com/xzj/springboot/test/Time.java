package com.xzj.springboot.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Time {
    public static void main(String[] args) throws ParseException {
        String time = "2021-03-01 00:00:00";
        String endTime = "2021-04-01 11:00:00";
        DateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date startDate = simpleFormat.parse(time);
        Date endDate = simpleFormat.parse(endTime);
        long start = startDate.getTime();
        long end = endDate.getTime();
        Double days = ((end - start) / (1000 * 60 * 60 * 24.0));
        System.out.println(days);
    }
}

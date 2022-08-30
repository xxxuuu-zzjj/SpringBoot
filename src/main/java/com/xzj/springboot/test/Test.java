package com.xzj.springboot.test;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String day = "2020/08/07";
        String endDay = "2020/09/13 00:00:00";
        String startDay = "2020/08/07 03:00:00";
        int flag1 = day.compareTo(startDay);
        int flag2 = day.compareTo(endDay);
        System.out.println(flag1);
        System.out.println(flag2);
    }
}

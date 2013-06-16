package com.gao.first;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * User: wangchen.gpx
 * Date: 13-6-15
 * Time: 下午7:09
 */
public class tets {
    public static void main(String[] args) throws ParseException {
        Calendar instance = Calendar.getInstance();
//        instance.setTime();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse("2013-04-25 00:00:00");
        System.out.println(date);
    }
}

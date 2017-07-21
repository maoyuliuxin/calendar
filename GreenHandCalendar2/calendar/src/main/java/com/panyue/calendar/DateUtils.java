package com.panyue.calendar;

import android.support.annotation.NonNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/21.
 */

public class DateUtils {
    @NonNull
    public static Long getDaysBetween(Date startDate, Date endDate) {
        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTime(startDate);
        fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
        fromCalendar.set(Calendar.MINUTE, 0);
        fromCalendar.set(Calendar.SECOND, 0);
        fromCalendar.set(Calendar.MILLISECOND, 0);

        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTime(endDate);
        toCalendar.set(Calendar.HOUR_OF_DAY, 0);
        toCalendar.set(Calendar.MINUTE, 0);
        toCalendar.set(Calendar.SECOND, 0);
        toCalendar.set(Calendar.MILLISECOND, 0);
        //将获取的日期转换为天数。
        return (toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / (1000 * 60 * 60 * 24);
    }

    //根据指定日期获取当月一号

    /***
     *  if (c.get(Calendar.DAY_OF_WEEK) == 1) {
     Week += "天";
     }
     if (c.get(Calendar.DAY_OF_WEEK) == 2) {
     Week += "一";
     }
     if (c.get(Calendar.DAY_OF_WEEK) == 3) {
     Week += "二";
     }
     if (c.get(Calendar.DAY_OF_WEEK) == 4) {
     Week += "三";
     }
     if (c.get(Calendar.DAY_OF_WEEK) == 5) {
     Week += "四";
     }
     if (c.get(Calendar.DAY_OF_WEEK) == 6) {
     Week += "五";
     }
     if (c.get(Calendar.DAY_OF_WEEK) == 7) {
     Week += "六";
     }
     */
    public static int getWeek(String pTime) {
        //  String pTime = "2012-03-12";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(format.parse(pTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek;
    }

    //获取应该显示的月份与年份
    public static int[] getPTime(int position) {
        Calendar c = Calendar.getInstance();//
        int year = c.get(Calendar.YEAR);// 获取当前年份
        int month = c.get(Calendar.MONTH) + 1;// 获取当前月份
        int newMonth = Math.abs(month + position) % 12 == 0 ? 12 : Math.abs(month + position) % 12;
        int newYear = (month + position) / 12 + year;
        int dayOfWeek = getWeek(newYear + "-" + newMonth + "-" + "01");

        //获取某月有几天
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, newYear);//先指定年份
        calendar.set(Calendar.MONTH, newMonth - 1);//再指定月份 Java月份从0开始算
        int daysCountOfMonth = calendar.getActualMaximum(Calendar.DATE);//获取指定年份中指定月份有几天

        return new int[]{dayOfWeek, daysCountOfMonth};
    }


}

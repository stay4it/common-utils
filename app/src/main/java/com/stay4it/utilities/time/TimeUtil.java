package com.stay4it.utilities.time;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * *          _       _
 * *   __   _(_)_   _(_) __ _ _ __
 * *   \ \ / / \ \ / / |/ _` | '_ \
 * *    \ V /| |\ V /| | (_| | | | |
 * *     \_/ |_| \_/ |_|\__,_|_| |_|
 * <p/>
 * Created by vivian on 16/5/18.
 */
public class TimeUtil {

    public static long DAY = 24 * 60 * 60;

    /**
     * long转成2015.01.03格式
     *
     * @param time 单位ms s的话需要*1000
     * @return
     */
    public static String LongtoStringFormat(long time) {
        Date currentTime = new Date(time);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * String(yyyy-MM-dd HH:mm:ss)转10位时间戳
     *
     * @param time
     * @return
     */
    public static Integer StringToTimestamp(String time) {

        int times = 0;
        try {
            times = (int) ((Timestamp.valueOf(time).getTime()) / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (times == 0) {
            System.out.println("String转10位时间戳失败");
        }
        return times;

    }


    /**
     * long转成2015-01-03格式
     *
     * @param time 单位ms s的话需要*1000
     * @return
     */
    public static String LongtoStringFormat2(long time) {
        Date currentTime = new Date(time);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * long转成2015.07.28 07:10格式
     *
     * @param time 单位ms s的话需要*1000
     * @return
     */
    public static String LongtoFullStringFormat(long time) {
        Date currentTime = new Date(time);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    public static String LongtoMonth(long time) {
        Date currentTime = new Date(time);
        SimpleDateFormat formatter = new SimpleDateFormat("M");
        String dateString = formatter.format(currentTime);
        return dateString + "月";
    }

    public static String getHourAndMinute(long time) {
        Date currentTime = new Date(time);
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    public static long getMorningLong(long time) {
        Date date = new Date(time * 1000);
        return getMorningLong(date);
    }

    /**
     * 获取当天凌晨的时间戳（单位：s）
     */
    public static long getMorningLong() {
        return getMorningLong(new Date());
    }

    /**
     * 获取指定时间当天的凌晨的时间戳（单位：s）
     *
     * @param date
     * @return
     */
    public static long getMorningLong(Date date) {
        Date d = getMorning(date);
        long time = d.getTime();
        return time / 1000;
    }

    /**
     * 获取今天凌晨
     *
     * @return
     */
    public static Date getMorning() {
        return getMorning(new Date());
    }

    /**
     * 获取指定时间当天的凌晨
     *
     * @param date 给定时间当天的凌晨
     * @return
     */
    public static Date getMorning(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    public static boolean isTimeOut(long endTime) {
        Date date = new Date();
        long now = date.getTime() / 1000;
        return now > endTime / 1000;
    }

    /**
     * 计算时间
     *
     * @param startTime
     * @return
     */
    public static String timeCounter(long startTime) {
        long currentTmieWithSecond = System.currentTimeMillis() / 1000;
        long timeD_Value = currentTmieWithSecond - startTime / 1000;// 与现在时间相差秒数
        String time;
        if (timeD_Value > 30 * 24 * 60 * 60) {// 月天以上
            time = LongtoStringFormat(startTime);
        } else if (timeD_Value > 24 * 60 * 60) {// 1天以上
            time = LongtoStringFormat(startTime);
        } else if (timeD_Value > 60 * 60) {// 1小时前
            time = timeD_Value / (60 * 60) + "小时前";
        } else if (timeD_Value > 60) {// 1分钟前
            time = timeD_Value / 60 + "分钟前";
        } else {// 1秒钟-59秒钟
            time = "刚刚";
        }
        return time;
    }

    /**
     * 计算时间
     *
     * @param startTime
     * @return
     */
    public static String timeDisparity(long startTime) {
        long currentTmieWithSecond = System.currentTimeMillis() / 1000;
        long timeD_Value = currentTmieWithSecond - startTime / 1000;// 与现在时间相差秒数
        String time;
        if (timeD_Value > 12 * 30 * 24 * 60 * 60) {
            time = timeD_Value / (12 * 30 * 24 * 60 * 60) + "年以前";
        } else if (timeD_Value > 30 * 24 * 60 * 60) {// 月天以上
            time = timeD_Value / (30 * 24 * 60 * 60) + "个月以前";
        } else if (timeD_Value > 7 * 24 * 60 * 60) {
            time = timeD_Value / (7 * 24 * 60 * 60) + "周以前";
        } else if (timeD_Value > 24 * 60 * 60) {// 1天以上
            time = timeD_Value / (24 * 60 * 60) + "天以前";
        } else if (timeD_Value > 60 * 60) {// 1小时前
            time = timeD_Value / (60 * 60) + "小时前";
        } else if (timeD_Value > 60) {// 1分钟前
            time = timeD_Value / 60 + "分钟前";
        } else if (timeD_Value > 1) {
            time = timeD_Value + "秒以前";
        } else {// 1秒钟-59秒钟
            time = "刚刚";
        }
        return time;
    }

}

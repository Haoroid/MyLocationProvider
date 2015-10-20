package com.haoroid.mylocationprovider;

import android.util.Log;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Administrator on 2015/10/20.
 */
public class DateToWeekUtils {
    public static String dateToWeek(String strDate)
    {
        String week = "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd", Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        try {
            ParsePosition pos = new ParsePosition(0);
            calendar.setTime(simpleDateFormat.parse(strDate,pos));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.e("星期",calendar.get(Calendar.DAY_OF_WEEK)+"");
        switch (calendar.get(Calendar.DAY_OF_WEEK))
        {
            case 1:
                week = "星期天";break;
            case 2:
                week = "星期一";break;
            case 3:
                week = "星期二";break;
            case 4:
                week = "星期三";break;
            case 5:
                week = "星期四";break;
            case 6:
                week = "星期五";break;
            case 7:
                week = "星期六";break;
            default:
                break;
        }
        return week;
    }
    public static Date strToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }
    public static String getWeek(String sdate){
        // 再转换为时间
        Date date = strToDate(sdate);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        // int hour=c.get(Calendar.DAY_OF_WEEK);
        // hour中存的就是星期几了，其范围 1~7
        // 1=星期日 7=星期六，其他类推
        return new SimpleDateFormat("EEEE").format(c.getTime());
    }
    public static String getWeekStr(String sdate){
        sdate = sdate.replaceAll(".","-");
        String str = "";
        str = getWeek(sdate);
        if("1".equals(str)){
            str = "星期日";
        }else if("2".equals(str)){
            str = "星期一";
        }else if("3".equals(str)){
            str = "星期二";
        }else if("4".equals(str)){
            str = "星期三";
        }else if("5".equals(str)){
            str = "星期四";
        }else if("6".equals(str)){
            str = "星期五";
        }else if("7".equals(str)){
            str = "星期六";
        }
        return str;
    }
}

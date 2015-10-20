package com.haoroid.mylocationprovider;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2015/10/15.
 */
public class MySharedPreferences {

    private  String cookie;
    private String avatar;
    private String nickname;
    private String identity;
    private String contact_phone;
    private String gender;//性别
    private String register_time;
    private String is_student = "0";
    private String is_personal = "0";
    private String is_teacher = "0";
    private String start_point;
    private String middle_points;
    private String static_status;
    private String end_point;
    private String weekly;
    private String mytriptime;
    private String myhuodongnum = "(0)";
    private String mychuxingnum = "(0)";


    public static void stuSaveSharePreferences(Context context,String cookie, String nickname,String avatar,
                                               String is_student,String contact,String gender,String register_time)
    {
        SharedPreferences sharedPrefernces = context.getSharedPreferences("login_info",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefernces.edit();
        editor.clear();
        editor.putString("cookie",cookie);
        editor.putString("nickname",nickname);
        editor.putString("avatar",avatar);
        editor.putString("is_student",is_student);
        editor.putString("contact",contact);
        editor.putString("gender",gender);
        editor.putString("register_time",register_time);
        editor.commit();
    }
    public static void teacherSaveSharePreferences(Context context,String cookie, String nickname,String avatar,
                                                   String is_teacher,String contact,String gender,String register_time,
                                                   String start_point,String middle_points,String end_point,String weekly,
                                                   String mytriptime,String status)
    {
        SharedPreferences sharedPrefernces = context.getSharedPreferences("login_info",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefernces.edit();
        editor.clear();
        editor.putString("cookie",cookie);
        editor.putString("nickname",nickname);
        editor.putString("avatar",avatar);
        editor.putString("is_teacher",is_teacher);
        editor.putString("contact",contact);
        editor.putString("gender",gender);
        editor.putString("register_time",register_time);
        editor.putString("start_point",start_point);
        editor.putString("middle_points",middle_points);
        editor.putString("end_point",end_point);
        editor.putString("weekly",weekly);
        editor.putString("mytriptime",mytriptime);
        editor.putString("status",status);
        editor.commit();
    }
    public static void personalSaveSharePreferences(Context context,String cookie, String nickname,String avatar,
                                                    String is_personal,String contact,String gender,String register_time,
                                                    String start_point,String middle_points,String end_point,String weekly,
                                                    String mytriptime,String status)
    {
        SharedPreferences sharedPrefernces = context.getSharedPreferences("info",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefernces.edit();
        editor.clear();
        editor.putString("cookie",cookie);
        editor.putString("nickname",nickname);
        editor.putString("avatar",avatar);
        editor.putString("is_personal",is_personal);
        editor.putString("contact",contact);
        editor.putString("gender",gender);
        editor.putString("register_time",register_time);
        editor.putString("start_point",start_point);
        editor.putString("middle_points",middle_points);
        editor.putString("end_point",end_point);
        editor.putString("weekly",weekly);
        editor.putString("mytriptime",mytriptime);
        editor.putString("status",status);
        editor.commit();
    }
    public static void activityAndTripSaveSharePreferences(Context context,String myhuodongnum,String mychuxingnum)
    {
        SharedPreferences sharedPrefernces = context.getSharedPreferences("activity_and_trip_info",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefernces.edit();
        editor.clear();
        editor.putString("myhuodongnum",myhuodongnum);
        editor.putString("mychuxingnum",mychuxingnum);
        editor.commit();
    }


    public MySharedPreferences()
    {}

    public MySharedPreferences(Context context,String loginOrtrip)
    {
        if (loginOrtrip.equals("login"))
        {
            SharedPreferences sharedPreferences = context.getSharedPreferences("login_info", Context.MODE_PRIVATE);
            String cookie = sharedPreferences.getString("cookie", "");
            String nickname = sharedPreferences.getString("nickname", "");
            String avatar = sharedPreferences.getString("avatar", "");
            String is_teacher =sharedPreferences.getString("is_teacher", "");
            String is_student = sharedPreferences.getString("is_student","");
            String is_personal = sharedPreferences.getString("is_personal","");
            String contact = sharedPreferences.getString("contact", "");
            String gender = sharedPreferences.getString("gender", "");
            String register_time = sharedPreferences.getString("register_time", "");
            String start_point =sharedPreferences.getString("start_point", "");
            String middle_points = sharedPreferences.getString("middle_points", "");
            String end_point = sharedPreferences.getString("end_point", "");
            String weekly = sharedPreferences.getString("weekly", "");
            String mytriptime = sharedPreferences.getString("time","");
            String status = sharedPreferences.getString("status","");
            this.cookie = cookie;
            this.avatar = avatar;
            this.nickname = nickname;
            this.is_personal = is_personal;
            this.is_student = is_student;
            this.is_teacher = is_teacher;
            this.contact_phone = contact;
            this.gender = gender;
            this.register_time = register_time;
            this.start_point = start_point;
            this.middle_points = middle_points;
            this.end_point = end_point;
            this.weekly = weekly;
            this.mytriptime = mytriptime;
            this.static_status = status;
        }
        else
        {
            SharedPreferences sharedPrefernces = context.getSharedPreferences("activity_and_trip_info",Context.MODE_PRIVATE);
            String mychuxingnum = sharedPrefernces.getString("mychuxingnum","");
            String myhuodongnum = sharedPrefernces.getString("myhuodongnum","");
            this.mychuxingnum = mychuxingnum;
            this.myhuodongnum = myhuodongnum;
        }


    }


    public String getCookie() {
        return cookie;
    }
    public String getAvatar() {
        return avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public String getIdentity() {
        return identity;
    }

    public String getContact_phone() {
        return contact_phone;
    }

    public String getGender() {
        return gender;
    }

    public String getRegister_time() {
        return register_time;
    }

    public String getIs_student() {
        return is_student;
    }

    public String getIs_personal() {
        return is_personal;
    }

    public String getIs_teacher() {
        return is_teacher;
    }

    public String getStart_point() {
        return start_point;
    }

    public String getMiddle_points() {
        return middle_points;
    }

    public String getStatic_status() {
        return static_status;
    }

    public String getEnd_point() {
        return end_point;
    }

    public String getWeekly() {
        return weekly;
    }

    public String getMytriptime() {
        return mytriptime;
    }

    public String getMyhuodongnum() {
        return myhuodongnum;
    }

    public String getMychuxingnum() {
        return mychuxingnum;
    }
}

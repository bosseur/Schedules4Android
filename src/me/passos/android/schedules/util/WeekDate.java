package me.passos.android.schedules.util;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class WeekDate {

    private final int week;
    private final Calendar calendar;
    // TODO by locate
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public WeekDate(int week) {
        this.week = week;
        calendar = Calendar.getInstance();
        calendar.set(Calendar.WEEK_OF_YEAR, week);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Log.d("Schedules", calendar.getTime().toString());
    }

    private String getDay(int dayOfWeek) {
        calendar.set(Calendar.DAY_OF_WEEK, dayOfWeek);
        return format.format(calendar.getTime());
    }

    private Date getDate(int dayOfWeek) {
        calendar.set(Calendar.DAY_OF_WEEK, dayOfWeek);
        return calendar.getTime();
    }

    public String getMonday() {
        return getDay(Calendar.MONDAY);
    }

    public Date getMondayDate() {
        return getDate(Calendar.MONDAY);
    }

    public String getTuesday() {
        return getDay(Calendar.TUESDAY);
    }

    public Date getTuesdayDate() {
        return getDate(Calendar.TUESDAY);
    }

    public String getWednesday() {
        return getDay(Calendar.WEDNESDAY);
    }

    public Date getWednesdayDate() {
        return getDate(Calendar.WEDNESDAY);
    }

    public String getThursday() {
        return getDay(Calendar.THURSDAY);
    }

    public Date getThursdayDate() {
        return getDate(Calendar.THURSDAY);
    }

    public String getFriday() {
        return getDay(Calendar.FRIDAY);
    }

    public Date getFridayDate() {
        return getDate(Calendar.FRIDAY);
    }

    public String getSaturday() {
        return getDay(Calendar.SATURDAY);
    }

    public Date getSaturdayDate() {
        return getDate(Calendar.SATURDAY);
    }

    public String getSunday() {
        return format.format(getSundayDate());
    }

    public Date getSundayDate() {
        Calendar sundayCalendar = Calendar.getInstance();
        sundayCalendar.setTime(getSaturdayDate());
        sundayCalendar.add(Calendar.DAY_OF_MONTH, 1);
        return sundayCalendar.getTime();
    }

    public static int getThisWeek() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    public static int getLastWeekOfYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.MONTH, Calendar.DECEMBER);
        calendar.set(Calendar.HOUR, 1);
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    public static List<Integer> getListOfWeekOnThisYear() {

        List<Integer> weeks = new ArrayList<Integer>();
        for (int i = 1; i <= getLastWeekOfYear(); i++) {
            weeks.add(i);
        }
        return weeks;

    }
}

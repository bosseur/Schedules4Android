package me.passos.android.schedules;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WeekDate {

	private final int week;
	private final Calendar calendar;
	// TODO by locate
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	
	public WeekDate(int week) {
		this.week = week;
		calendar = Calendar.getInstance();
		calendar.set(Calendar.WEEK_OF_MONTH, week);
	}
	
	private String getDayOfTheWeek(int dayOfWeek) {
		calendar.set(Calendar.DAY_OF_WEEK, dayOfWeek);
		return format.format(calendar.getTime());
	}
	
	public String getMondayOfTheWeek() {
		return getDayOfTheWeek(Calendar.MONDAY);
	}

	public String getTuesdayOfTheWeek() {
		return getDayOfTheWeek(Calendar.TUESDAY);
	}
	
	public String getWednesdayOfTheWeek() {
		return getDayOfTheWeek(Calendar.WEDNESDAY);
	}

	public String getThursdayOfTheWeek() {
		return getDayOfTheWeek(Calendar.THURSDAY);
	}

	public String getFridayOfTheWeek() {
		return getDayOfTheWeek(Calendar.FRIDAY);
	}
	
	public String getSaturdayOfTheWeek() {
		return getDayOfTheWeek(Calendar.SATURDAY);
	}
	
	public String getSundayOfTheWeek() {
		Calendar sundayCalendar = Calendar.getInstance();
		sundayCalendar.set(Calendar.WEEK_OF_MONTH, week + 1);
		sundayCalendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return format.format(sundayCalendar.getTime());
	}
	
}

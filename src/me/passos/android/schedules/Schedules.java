package me.passos.android.schedules;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class Schedules extends Activity {

	private TextView mondayDateHeader;
	private TextView weekNumber;
	private TextView sundayDateHeader;
	
	private TextView mondayDate;
	private TextView tuesdayDate;
	private TextView wednesdayDate;
	private TextView thursdayDate;
	private TextView fridayDate;
	private TextView saturdayDate;
	private TextView sundayDate;
	
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		loadComponents();
		
		Calendar calendar = Calendar.getInstance();
		int week = calendar.get(Calendar.WEEK_OF_YEAR);
		setDatesOfTheWeek(week);
		
	}
	
	private void loadComponents() {

		mondayDateHeader = (TextView) findViewById(R.id.mondayDateHeader);
		weekNumber = (TextView) findViewById(R.id.weekNumber);
		sundayDateHeader = (TextView) findViewById(R.id.sundayDateHeader);
		
		mondayDate = (TextView) findViewById(R.id.mondayDate);
		tuesdayDate = (TextView) findViewById(R.id.tuesdayDate);
		wednesdayDate = (TextView) findViewById(R.id.wednesdayDate);
		thursdayDate = (TextView) findViewById(R.id.thursdayDate);
		fridayDate = (TextView) findViewById(R.id.fridayDate);
		saturdayDate = (TextView) findViewById(R.id.saturdayDate);
		sundayDate = (TextView) findViewById(R.id.sundayDate);

	}

	private void setDatesOfTheWeek(int week) {
		
		WeekDate weekDate = new WeekDate(week);

		mondayDateHeader.setText(weekDate.getMondayOfTheWeek());
		weekNumber.setText(String.valueOf(week));
		sundayDateHeader.setText(weekDate.getSundayOfTheWeek());
	
		mondayDate.setText(weekDate.getMondayOfTheWeek());
		tuesdayDate.setText(weekDate.getTuesdayOfTheWeek());
		wednesdayDate.setText(weekDate.getWednesdayOfTheWeek());
		thursdayDate.setText(weekDate.getThursdayOfTheWeek());
		fridayDate.setText(weekDate.getFridayOfTheWeek());
		saturdayDate.setText(weekDate.getSaturdayOfTheWeek());
		sundayDate.setText(weekDate.getSundayOfTheWeek());
		
	}
	
}
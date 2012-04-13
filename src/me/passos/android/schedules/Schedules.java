package me.passos.android.schedules;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class Schedules extends Activity {

	private TextView firstDateOfWeek;
	private TextView weekNumber;
	private TextView lastDateOfWeek;
	
	private TextView mondayDate;
    private TextViewTimePicker mondayHourStart;
    private TextViewTimePicker mondayHourEnd;

	private TextView tuesdayDate;
    private TextViewTimePicker tuesdayHourStart;
    private TextViewTimePicker tuesdayHourEnd;

	private TextView wednesdayDate;
    private TextViewTimePicker wednesdayHourStart;
    private TextViewTimePicker wednesdayHourEnd;

	private TextView thursdayDate;
    private TextViewTimePicker thursdayHourStart;
    private TextViewTimePicker thursdayHourEnd;

	private TextView fridayDate;
    private TextViewTimePicker fridayHourStart;
    private TextViewTimePicker fridayHourEnd;

	private TextView saturdayDate;
    private TextViewTimePicker saturdayHourStart;
    private TextViewTimePicker saturdayHourEnd;

	private TextView sundayDate;
    private TextViewTimePicker sundayHourStart;
    private TextViewTimePicker sundayHourEnd;
	
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		loadComponents();
		setDates();
		
	}

    private void loadComponents() {

		firstDateOfWeek = (TextView) findViewById(R.id.firstDateOfWeek);
		weekNumber = (TextView) findViewById(R.id.weekNumber);
		lastDateOfWeek = (TextView) findViewById(R.id.lastDateHeader);
		
		mondayDate = (TextView) findViewById(R.id.mondayDate);
        mondayHourStart = (TextViewTimePicker) findViewById(R.id.mondayHourStart);
        mondayHourEnd = (TextViewTimePicker) findViewById(R.id.mondayHourEnd);
        
		tuesdayDate = (TextView) findViewById(R.id.tuesdayDate);
        tuesdayHourStart = (TextViewTimePicker) findViewById(R.id.tuesdayHourStart);
        tuesdayHourEnd = (TextViewTimePicker) findViewById(R.id.tuesdayHourEnd);

		wednesdayDate = (TextView) findViewById(R.id.wednesdayDate);
        wednesdayHourStart = (TextViewTimePicker) findViewById(R.id.wednesdayHourStart);
        wednesdayHourEnd = (TextViewTimePicker) findViewById(R.id.wednesdayHourEnd);

		thursdayDate = (TextView) findViewById(R.id.thursdayDate);
        thursdayHourStart = (TextViewTimePicker) findViewById(R.id.thursdayHourStart);
        thursdayHourEnd = (TextViewTimePicker) findViewById(R.id.thursdayHourEnd);

		fridayDate = (TextView) findViewById(R.id.fridayDate);
        fridayHourStart = (TextViewTimePicker) findViewById(R.id.fridayHourStart);
        fridayHourEnd = (TextViewTimePicker) findViewById(R.id.fridayHourEnd);

        saturdayDate = (TextView) findViewById(R.id.saturdayDate);
        saturdayHourStart = (TextViewTimePicker) findViewById(R.id.saturdayHourStart);
        saturdayHourEnd = (TextViewTimePicker) findViewById(R.id.saturdayHourEnd);

		sundayDate = (TextView) findViewById(R.id.sundayDate);
        sundayHourStart = (TextViewTimePicker) findViewById(R.id.sundayHourStart);
        sundayHourEnd = (TextViewTimePicker) findViewById(R.id.sundayHourEnd);

	}

	private void setDates() {

        Calendar calendar = Calendar.getInstance();
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
		
		WeekDate weekDate = new WeekDate(week);

		firstDateOfWeek.setText(weekDate.getMonday());
		weekNumber.setText(String.valueOf(week));
		lastDateOfWeek.setText(weekDate.getSunday());
	
		mondayDate.setText(weekDate.getMonday());
        mondayHourStart.setDate(weekDate.getMondayDate());
        mondayHourEnd.setDate(weekDate.getMondayDate());
        
		tuesdayDate.setText(weekDate.getTuesday());
        tuesdayHourStart.setDate(weekDate.getTuesdayDate());
        tuesdayHourEnd.setDate(weekDate.getTuesdayDate());

		wednesdayDate.setText(weekDate.getWednesday());
        wednesdayHourStart.setDate(weekDate.getWednesdayDate());
        wednesdayHourEnd.setDate(weekDate.getWednesdayDate());

		thursdayDate.setText(weekDate.getThursday());
        thursdayHourStart.setDate(weekDate.getThursdayDate());
        thursdayHourEnd.setDate(weekDate.getThursdayDate());

		fridayDate.setText(weekDate.getFriday());
        fridayHourStart.setDate(weekDate.getFridayDate());
        fridayHourEnd.setDate(weekDate.getFridayDate());

		saturdayDate.setText(weekDate.getSaturday());
        saturdayHourStart.setDate(weekDate.getSaturdayDate());
        saturdayHourEnd.setDate(weekDate.getSaturdayDate());

		sundayDate.setText(weekDate.getSunday());
        sundayHourStart.setDate(weekDate.getSundayDate());
        sundayHourEnd.setDate(weekDate.getSundayDate());
		
	}
	
}
package me.passos.android.schedules.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import me.passos.android.schedules.R;
import me.passos.android.schedules.components.TextViewTimePicker;
import me.passos.android.schedules.dao.ScheduleDAO;
import me.passos.android.schedules.util.WeekDate;

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

        ScheduleDAO scheduleDAO = new ScheduleDAO(this);

		firstDateOfWeek.setText(weekDate.getMonday());
		weekNumber.setText(String.valueOf(week));
		lastDateOfWeek.setText(weekDate.getSunday());
	
		mondayDate.setText(weekDate.getMonday());
        mondayHourStart.setDate(weekDate.getMondayDate());
        mondayHourStart.setText(scheduleDAO.getHourStart(weekDate.getMondayDate()));
        mondayHourEnd.setDate(weekDate.getMondayDate());
        mondayHourEnd.setText(scheduleDAO.getHourEnd(weekDate.getMondayDate()));

		tuesdayDate.setText(weekDate.getTuesday());
        tuesdayHourStart.setDate(weekDate.getTuesdayDate());
        tuesdayHourStart.setText(scheduleDAO.getHourStart(weekDate.getTuesdayDate()));
        tuesdayHourEnd.setDate(weekDate.getTuesdayDate());
        tuesdayHourEnd.setText(scheduleDAO.getHourEnd(weekDate.getTuesdayDate()));

		wednesdayDate.setText(weekDate.getWednesday());
        wednesdayHourStart.setDate(weekDate.getWednesdayDate());
        wednesdayHourStart.setText(scheduleDAO.getHourStart(weekDate.getWednesdayDate()));
        wednesdayHourEnd.setDate(weekDate.getWednesdayDate());
        wednesdayHourEnd.setText(scheduleDAO.getHourEnd(weekDate.getWednesdayDate()));

		thursdayDate.setText(weekDate.getThursday());
        thursdayHourStart.setDate(weekDate.getThursdayDate());
        thursdayHourStart.setText(scheduleDAO.getHourStart(weekDate.getThursdayDate()));
        thursdayHourEnd.setDate(weekDate.getThursdayDate());
        thursdayHourEnd.setText(scheduleDAO.getHourEnd(weekDate.getThursdayDate()));

		fridayDate.setText(weekDate.getFriday());
        fridayHourStart.setDate(weekDate.getFridayDate());
        fridayHourStart.setText(scheduleDAO.getHourStart(weekDate.getFridayDate()));
        fridayHourEnd.setDate(weekDate.getFridayDate());
        fridayHourEnd.setText(scheduleDAO.getHourEnd(weekDate.getFridayDate()));

		saturdayDate.setText(weekDate.getSaturday());
        saturdayHourStart.setDate(weekDate.getSaturdayDate());
        saturdayHourStart.setText(scheduleDAO.getHourStart(weekDate.getSaturdayDate()));
        saturdayHourEnd.setDate(weekDate.getSaturdayDate());
        saturdayHourEnd.setText(scheduleDAO.getHourEnd(weekDate.getSaturdayDate()));

		sundayDate.setText(weekDate.getSunday());
        sundayHourStart.setDate(weekDate.getSundayDate());
        sundayHourStart.setText(scheduleDAO.getHourStart(weekDate.getSundayDate()));
        sundayHourEnd.setDate(weekDate.getSundayDate());
        sundayHourEnd.setText(scheduleDAO.getHourEnd(weekDate.getSundayDate()));

        scheduleDAO.close();
		
	}
	
}
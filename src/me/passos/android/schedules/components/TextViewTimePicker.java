package me.passos.android.schedules.components;

import android.app.TimePickerDialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import me.passos.android.schedules.dao.ScheduleDAO;
import me.passos.android.schedules.util.HourType;

import java.util.Date;

public class TextViewTimePicker extends TextView implements View.OnClickListener, TimePickerDialog.OnTimeSetListener {

    private final Context context;
    private Date date;
    private HourType type;

    public TextViewTimePicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setOnClickListener(this);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setType(HourType type) {
        this.type = type;
    }

    public void onClick(View view) {
        new TimePickerDialog(context, this, getHour(), getMinute(), true).show();
    }

    public void onTimeSet(TimePicker timePicker, int hour, int minute) {

        StringBuffer newHour = new StringBuffer();
        newHour.append(pad(hour))
               .append(":")
               .append(pad(minute));

        this.setText(newHour.toString());

        ScheduleDAO scheduleDAO = new ScheduleDAO(context);
        scheduleDAO.setHour(date, newHour.toString(), type);
        scheduleDAO.close();

    }

    private int getHour() {
        return ( this.getText() == null ) ? 0 : Integer.valueOf(this.getText().toString().split(":")[0]);
    }

    private int getMinute() {
        return ( this.getText() == null ) ? 0 : Integer.valueOf(this.getText().toString().split(":")[1]);
    }

    private static String pad(int c) {
        if (c >= 10) {
            return String.valueOf(c);
        } else {
            return "0" + String.valueOf(c);
        }
    }

}
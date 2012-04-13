package me.passos.android.schedules;

import android.app.TimePickerDialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Date;

public class TextViewTimePicker extends TextView implements View.OnClickListener, TimePickerDialog.OnTimeSetListener {

    private final Context context;
    private Date date;

    public TextViewTimePicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setOnClickListener(this);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void onClick(View view) {
        new TimePickerDialog(context, this, getHour(), getMinute(), true).show();
    }

    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
        this.setText(
                new StringBuilder()
                        .append(pad(hour)).append(":")
                        .append(pad(minute))
        );
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
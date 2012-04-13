package me.passos.android.schedules;

import android.app.TimePickerDialog.OnTimeSetListener;
import android.widget.EditText;
import android.widget.TimePicker;

public class TimeSetListener implements OnTimeSetListener {

	private final EditText editText;
	
	public TimeSetListener(EditText editText) {
		this.editText = editText;
	}
	
	public void onTimeSet(TimePicker arg0, int hour, int minute) {
		editText.setText(new StringBuilder().append(pad(hour)).append(":").append(pad(minute)));
	}
	
	private static String pad(int c) {
	    if (c >= 10) {
	        return String.valueOf(c);
	    } else {
	        return "0" + String.valueOf(c);
	    }
	}

}

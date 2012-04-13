package me.passos.android.schedules.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import me.passos.android.schedules.util.HourType;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScheduleDAO extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "Schedules";
    private static final int TABLE_VERSION = 4;

    private static final String DEFAULT_HOUR = "00:00";

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public ScheduleDAO(Context context) {
        super(context, TABLE_NAME, null, TABLE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        StringBuilder sb = new StringBuilder();
        sb.append(" CREATE TABLE " + TABLE_NAME);
        sb.append(" ( ");
        sb.append(" date DATE UNIQUE NOT NULL, ");
        sb.append(" start TEXT, ");
        sb.append(" end TEXT ");
        sb.append(" ) ");
        database.execSQL(sb.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        database.execSQL(sql);
        onCreate(database);
    }

    private Cursor getHours(Date date) {
        String[] columns = new String[] { "start", "end" };
        String selection = "date=?";
        String[] selectionArgs = new String[] { dateFormat.format(date) };
        String groupBy = null;
        String having = null;
        String order = null;

        return getWritableDatabase().query(TABLE_NAME, columns, selection, selectionArgs, groupBy, having, order);
    }

    private boolean exists(Date date) {
        Cursor c = getHours(date);
        boolean exists = (c.getCount() > 0);
        c.close();
        return exists;
    }

    private String getHour(Date date, HourType hourType) {

        Cursor c = getHours(date) ;

        c.moveToFirst();

        String hourStart = DEFAULT_HOUR;
        String hourEnd = DEFAULT_HOUR;

        if( c.getCount() > 0 ) {
            c.moveToFirst();
            hourStart = c.getString(0);
            hourEnd = c.getString(1);
        }

        c.close();

        if( HourType.START.equals(hourType) ) {
            return (hourStart != null) ? hourStart : DEFAULT_HOUR;
        } else {
            return (hourEnd != null) ? hourEnd: DEFAULT_HOUR;
        }
    }

    public void setHour(Date date, String hour, HourType hourType) {

        ContentValues values = new ContentValues();
        if( HourType.START.equals(hourType) ) {
       		values.put("start", hour);
        } else {
       		values.put("end", hour);
        }

        if( exists(date) ) {
            update(date, values);
        } else  {
            insert(date, values);
        }

    }

    public String getHourStart(Date date) {
        return getHour(date, HourType.START);
    }

    public String getHourEnd(Date date) {
        return getHour(date, HourType.END);
    }

    private void insert(Date date, ContentValues values) {
        values.put("date", dateFormat.format(date));
        getWritableDatabase().insert(TABLE_NAME, null, values);
    }

    private void update(Date date, ContentValues values) {
        values.put("date", dateFormat.format(date));
        getWritableDatabase().update(TABLE_NAME, values, "date=?", new String[]{dateFormat.format(date)});
    }

}

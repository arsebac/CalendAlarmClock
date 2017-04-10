package arsebac.alarm.clock.model;

import android.content.Context;
import android.provider.BaseColumns;
import android.provider.CalendarContract;

import java.util.Calendar;

/**
 * Created by Hasaghi on 10/04/2017.
 */

public class CalendarProvider {
	public CalendarProvider(Context ctx) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2014, Calendar.MAY, 14, 0, 0, 0);
		long startDay = calendar.getTimeInMillis();
		calendar.set(2014, Calendar.MAY, 14, 23, 59, 59);
		long endDay = calendar.getTimeInMillis();

		String[] projection = new String[] { BaseColumns._ID, CalendarContract.Events.TITLE, CalendarContract.Events.DTSTART };
		String selection = CalendarContract.Events.DTSTART + " >= ? AND " + CalendarContract.Events.DTSTART + "<= ?";
		String[] selectionArgs = new String[] { Long.toString(startDay), Long.toString(endDay) };

	}
}

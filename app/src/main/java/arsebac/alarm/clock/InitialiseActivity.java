package arsebac.alarm.clock;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class InitialiseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initialise);
        final String[] EVENT_PROJECTION = new String[]{
                CalendarContract.Calendars._ID,
                CalendarContract.Calendars.CALENDAR_DISPLAY_NAME,
                CalendarContract.Calendars.CALENDAR_COLOR
        };

        final ContentResolver cr = getContentResolver();
        final Uri uri = CalendarContract.Calendars.CONTENT_URI;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CALENDAR) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        List<CalendarInfos> infos = new ArrayList<>();
        Cursor cur = cr.query(uri, EVENT_PROJECTION, null, null, null);
        while (cur.moveToNext()) {
            String name = cur.getString(1);
            Long id = cur.getLong(0);
            int color = cur.getInt(2);
            infos.add(new CalendarInfos(id,name,color));
        }
        cur.close();
        ListView list = (ListView) findViewById(R.id.listView);
        list.setAdapter(new CalendarListAdapter(this,android.R.layout.activity_list_item,infos));
    }
}

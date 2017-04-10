package arsebac.alarm.clock;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import arsebac.alarm.clock.model.CalendarInfos;

import java.util.List;

/**
 * @author Francois Melkonian
 */

class CalendarListAdapter extends ArrayAdapter<CalendarInfos> {

    public CalendarListAdapter(Context context, int resource, List<CalendarInfos> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        CalendarInfos calInfo = getItem(position);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.cal_infos, null);
        }
        TextView text = ((TextView) convertView.findViewById(R.id.calName));
        text.setText(calInfo.getName());
        text.setTextColor(calInfo.getColor());
        System.out.println(calInfo.getName());
        return convertView;
    }
}

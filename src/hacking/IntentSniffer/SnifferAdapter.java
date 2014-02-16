package hacking.IntentSniffer;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class SnifferAdapter extends ArrayAdapter<ActivityManager.RecentTaskInfo> {

    public SnifferAdapter(Context context, List<ActivityManager.RecentTaskInfo> objects) {
        super(context, R.layout.sniffer_item, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.sniffer_item,parent,false);

        ActivityManager.RecentTaskInfo item = getItem(position);
        Intent baseIntent = item.baseIntent;
        String text = baseIntent.toString();
        if(baseIntent.getClipData() != null)
            text = text + "\n" + baseIntent.getClipData();
        if(baseIntent.getExtras() != null)
            text = text + "\n" + baseIntent.getExtras().toString();
        ((TextView)convertView).setText(text);
        return convertView;
    }
}

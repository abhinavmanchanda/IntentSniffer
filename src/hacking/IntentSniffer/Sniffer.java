package hacking.IntentSniffer;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.List;

public class Sniffer extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void sniff(View view){
        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        List<ActivityManager.RecentTaskInfo> recentTasks = activityManager.getRecentTasks(10, 0);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new SnifferAdapter(this, recentTasks));
    }
}

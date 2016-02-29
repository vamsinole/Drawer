package com.example.vamashikrishna.drawer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Vamashikrishna on 2/15/2016.
 */
public class AlarmService extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent myIntent = new Intent(context, NotificationService.class);
        context.startService(myIntent);
    }
}

package com.haoroid.mylocationprovider;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.widget.Toast;

/**
 * Created by Administrator on 2015/10/14.
 */
public class ProximityAlertReciver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        boolean isEnter = intent.getBooleanExtra(LocationManager.KEY_PROXIMITY_ENTERING,false);
        if (isEnter)
        {
            Toast.makeText(context,"½øÈë",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context,"ÍË³ö",Toast.LENGTH_SHORT).show();
        }
    }
}

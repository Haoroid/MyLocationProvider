package com.haoroid.mylocationprovider;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;

import java.net.HttpURLConnection;
import java.util.List;


public class AllProviderTest extends Activity {

    private TextView tv_provider_name;
    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allproviderstest);
        ListView lv_provider_show = (ListView)findViewById(R.id.listview_AllProviderTest_show);
         tv_provider_name = (TextView)findViewById(R.id.textview_AllProviderTest_providername);
        locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);

        List<String> list = locationManager.getAllProviders();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        lv_provider_show.setAdapter(arrayAdapter);
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        updateView(location);

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 1, new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                updateView(location);
               
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {
                updateView(locationManager.getLastKnownLocation(provider));
            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        });


    }

    private void updateView(Location newlocation) {
        if (newlocation != null)
        {

            int i = HttpURLConnection.HTTP_OK;
            StringBuilder builder = new StringBuilder();
            builder.append(i+"实时的位置信息：\n");
            builder.append("经度：");
            builder.append(newlocation.getLongitude());
            builder.append("\n纬度:");
            builder.append(newlocation.getLatitude());
            builder.append("\n高度："+newlocation.getAltitude() +"\n速度："+newlocation.getSpeed()+"\n方向："+newlocation.getBearing());
            tv_provider_name.setText(builder.toString());
            double longi = 103.36;
            double lati = 30.75;
            float raduias = 5000;
            Intent intent = new Intent(AllProviderTest.this, ProximityAlertReciver.class);
            PendingIntent pi = PendingIntent.getBroadcast(AllProviderTest.this, -1, intent, 0);
            locationManager.addProximityAlert(lati, longi, raduias, -1, pi);
        }
        else
        {
            tv_provider_name.setText("");
        }
    }


}

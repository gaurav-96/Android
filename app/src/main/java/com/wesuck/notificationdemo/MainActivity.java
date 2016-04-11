package com.wesuck.notificationdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setContentText("Here is my first ever Notification!");
        mBuilder.setContentTitle("My Notification");
        mBuilder.setSmallIcon(android.R.drawable.sym_def_app_icon);

        Intent i = new Intent(this,SecondActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,1,i,PendingIntent.FLAG_ONE_SHOT);

        mBuilder.setContentIntent(pendingIntent);

        Notification mNotification = mBuilder.build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0,mNotification);

    }
}

package com.zh.young.notificationdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    private NotificationManager manager;
    private Notification notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    protected void onStart() {
        super.onStart();
        makeNotification();
    }

    public void send(View view){

        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(0,notification);
    }

    private void makeNotification() {
        PendingIntent intent = PendingIntent.getActivity(this, 0, new Intent(this, receivedPageActivity.class), PendingIntent.FLAG_CANCEL_CURRENT);
        Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("message")
                .setContentText("这是发送的通知")
                .setContentIntent(intent);

        notification = builder.build();

    }
}

package com.zh.young.bindservicedemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ObtainSumService.MyBinder mService;
    boolean isBind;
    ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService = (ObtainSumService.MyBinder) service;
            isBind = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBind = false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, ObtainSumService.class);
        bindService(intent,mConnection,BIND_AUTO_CREATE);

    }

    @Override
    protected void onStop() {
        super.onStop();
        if(isBind){
            unbindService(mConnection);
            isBind = false;
        }

    }
    public void click(View view){
        int sum = mService.getService().obtainSum();
        Toast.makeText(this, "sum = " + sum, Toast.LENGTH_SHORT).show();
    }
}

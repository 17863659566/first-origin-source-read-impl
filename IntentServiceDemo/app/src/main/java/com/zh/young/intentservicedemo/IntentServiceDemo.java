package com.zh.young.intentservicedemo;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by young on 2017/6/5.
 */

public class IntentServiceDemo extends IntentService {

    private String TAG = "IntentServiceDemo";

    public IntentServiceDemo(){
        super(null);
    }
    public IntentServiceDemo(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i(TAG,intent.getStringExtra("process"));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy");
    }
}

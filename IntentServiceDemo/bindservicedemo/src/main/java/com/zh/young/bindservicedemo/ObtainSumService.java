package com.zh.young.bindservicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.Random;


public class ObtainSumService extends Service {

    Random mGenerate = new Random(10);
    public final MyBinder myBinder = new MyBinder();
    public class MyBinder extends Binder{
        ObtainSumService getService(){
            return ObtainSumService.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    public int obtainSum(){
        return mGenerate.nextInt() + mGenerate.nextInt();
    }
}

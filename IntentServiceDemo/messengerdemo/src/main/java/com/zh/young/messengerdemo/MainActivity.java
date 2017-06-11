package com.zh.young.messengerdemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    static final int MSG_SAY_HELLO = 1;
    boolean isBound;
    Messenger mService;
    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    ServiceConnection mConnection = new ServiceConnection(){

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService =  new Messenger(service);
            isBound = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void sayHello(){
        try {
            if(isBound){
                Message obtain = Message.obtain(null, MSG_SAY_HELLO, 0, 0);

                //利用同样的方法就可以实现双方通信了
                Messenger messenger = new Messenger(mHandler);
                obtain.replyTo = messenger;
                mService.send(obtain);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }


    }
    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent("com.zh.young.messengerdemo");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        bindService(intent,mConnection,BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(isBound)
            unbindService(mConnection);
    }
}

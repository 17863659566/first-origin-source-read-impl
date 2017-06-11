package com.zh.young.messengerdemo;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by young on 2017/6/5.
 */

public class MessengerServiceDemo extends Service {
    static final int MSG_SAY_HELLO = 1;

    class ServiceHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what){
                case MSG_SAY_HELLO :
                    Toast.makeText(MessengerServiceDemo.this, "hello", Toast.LENGTH_SHORT).show();
                    Messenger messenger = msg.replyTo;
                    break;
                default:
                    super.handleMessage(msg);
                    break;
            }
        }
    }

    final Messenger messenger = new Messenger(new ServiceHandler());
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this, "binding", Toast.LENGTH_SHORT).show();
        return messenger.getBinder();
    }
}

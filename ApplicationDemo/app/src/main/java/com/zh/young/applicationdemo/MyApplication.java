package com.zh.young.applicationdemo;

import android.app.Application;

/**
 * Created by young on 2017/6/7.
 */

public class MyApplication extends Application {
    public String string = "hello world";

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}

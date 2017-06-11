package com.zh.young.applicationdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by young on 2017/6/7.
 */

public class SecondActivity extends Activity {
    private EditText mEtData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        mEtData = (EditText) findViewById(R.id.et_data);

    }

    @Override
    protected void onStart() {
        super.onStart();
        MyApplication myApplication = (MyApplication) getApplicationContext();
        String string = myApplication.getString();
        mEtData.setText(string);
    }
}

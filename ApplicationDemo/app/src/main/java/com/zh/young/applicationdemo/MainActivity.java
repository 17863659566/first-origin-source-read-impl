package com.zh.young.applicationdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEtData = (EditText) findViewById(R.id.et_data);
    }

    public void updateData(View view){
        String data = mEtData.getText().toString();
        MyApplication myApplication = (MyApplication) getApplicationContext();
        myApplication.setString(data);
        Toast.makeText(myApplication, "已修改", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}

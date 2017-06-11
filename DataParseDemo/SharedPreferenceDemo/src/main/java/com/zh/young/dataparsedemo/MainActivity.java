package com.zh.young.dataparsedemo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private String DATA_USER = "data_user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.et_username);
        password = (EditText) findViewById(R.id.et_password);


    }

    @Override
    protected void onStart() {
        super.onStart();
        readFromSharedPreference();
    }

    private void readFromSharedPreference() {
        SharedPreferences preferences = getSharedPreferences(DATA_USER, MODE_PRIVATE);
        String _username = preferences.getString("username", "");
        String _password = preferences.getString("password", "");
        username.setText(_username);
        password.setText(_password);
    }


    public void submit(View view){
        writeToSharedPreference();
    }

    private void writeToSharedPreference() {
        String _username = username.getText().toString();
        String _password = password.getText().toString();
        boolean isSuccessed = false;
        if(_username != null && _password != null){
            SharedPreferences preferences = getSharedPreferences(DATA_USER, MODE_PRIVATE);
            SharedPreferences.Editor edit = preferences.edit();
            edit.putString("username",_username);
            edit.putString("password",_password);
            isSuccessed = edit.commit();
        }

        if(isSuccessed){
            Toast.makeText(this, "写入成功", Toast.LENGTH_SHORT).show();
        }
    }


}

package com.zh.young.textinputlayoutdemo;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextInputLayout mTILUsernameWrapper;
    private TextInputLayout mTILPasswordWrapper;
    private Button mSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

    }

    private void findViews() {
        mTILUsernameWrapper = (TextInputLayout) findViewById(R.id.usernameWrapper);
        mTILPasswordWrapper = (TextInputLayout) findViewById(R.id.passwordWrapper);
        mSubmit = (Button) findViewById(R.id.btn);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mTILUsernameWrapper.setHint("username");
        mTILPasswordWrapper.setHint("password");
        mSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn :
                ((InputMethodManager)getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(mTILPasswordWrapper.getWindowToken(),0);
                ((InputMethodManager)getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(mTILUsernameWrapper.getWindowToken(),0);

                break;
        }
    }
}

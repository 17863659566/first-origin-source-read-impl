package com.zh.young.inputmethoddemo;

import android.hardware.input.InputManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import static android.view.inputmethod.InputMethodManager.SHOW_IMPLICIT;

public class MainActivity extends AppCompatActivity {

    private EditText mEtInput;
    private InputMethodManager mInputManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEtInput = (EditText) findViewById(R.id.et_input);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mInputManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        mEtInput.requestFocus();
    }

    public void popKeyBoard(View view){
        View inflate = View.inflate(this, R.layout.item_input, null);

       mInputManager.showSoftInput(mEtInput,0);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mInputManager.hideSoftInputFromWindow(mEtInput.getWindowToken(),0);
        return super.onTouchEvent(event);
    }
}

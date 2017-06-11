package com.zh.young.materialdatepickerdemo;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements com.wdullaer.materialdatetimepicker.date.DatePickerDialog.OnDateSetListener {

    private com.wdullaer.materialdatetimepicker.date.DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar now = Calendar.getInstance();
        datePickerDialog = com.wdullaer.materialdatetimepicker.date.DatePickerDialog.newInstance(this, now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));

    }

    @Override
    public void onDateSet(com.wdullaer.materialdatetimepicker.date.DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        Toast.makeText(this, "year : " + year + "monthOfYear : " + monthOfYear + "dayOfMonth : " + dayOfMonth, Toast.LENGTH_SHORT).show();
    }

    public void dialog(View view){
        datePickerDialog.show(getFragmentManager(),"Date");
    }
}

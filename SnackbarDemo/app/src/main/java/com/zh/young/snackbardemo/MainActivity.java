package com.zh.young.snackbardemo;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = (LinearLayout) findViewById(R.id.ll);
    }

    public void popSnackbar(View view){
        //1. 导入com.android.support:design:版本号  这个版本号要和com.android.support:appcompat-v7版本号一致，避免出错
        //2. Snackbar就可以使用了，
        // Snackbar
        //      .make(父布局,要显示的内容,时间长度)
        //      .setAction()(可选，用于执行多于Toast的操作步骤)
        //      .show();
        Snackbar.make(linearLayout,"hello snackbar",Snackbar.LENGTH_LONG)
                .setAction("回退", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "回退成功", Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }
}

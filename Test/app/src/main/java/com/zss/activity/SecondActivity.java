package com.zss.activity;

import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zss.test.MainActivity;
import com.zss.test.R;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        System.out.println("第二页面测试");

        Button btn = findViewById(R.id.backBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                //跳转至主界面
                startActivity(intent);
            }
        });

        Button btn2 = findViewById(R.id.closeBtn);
        btn2.setOnClickListener(this);

        Button btn03 = findViewById(R.id.btn03);
        btn03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent2);
            }
        });

    }

    @Override
    public void onClick(View v) {
            finish();//关闭
    }
}

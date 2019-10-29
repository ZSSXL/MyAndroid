package com.zss.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.zss.test.R;

public class FourthActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FourthActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });

        Button close = findViewById(R.id.btn02);
        close.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}

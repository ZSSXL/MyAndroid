package com.zss.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;

import com.zss.kanmeitu.R;

public class SplashActivity extends AppCompatActivity {

    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            next();
        }
    };

    private void next() {
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);
        //关闭当前页面
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //去除状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
                ,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        handler.postAtTime(new Runnable() {
            @Override
            public void run() {
                //3秒后调用这里
                //这里调用的是子线程，不能直接操作UI，需要用handler切换到主线程
                //用多个线程的目的的解决，如果有耗时任务，那么就会卡界面
                //而用了多线程后，将耗时任务放到子线程，那么主线程（UI）就不会卡住
                handler.sendEmptyMessage(0);
            }
        },3000);
    }
}

package com.zss.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zss.activity.FourthActivity;
import com.zss.activity.RecyclerActivity;
import com.zss.activity.SecondActivity;
import com.zss.activity.ThirdActivity;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * 该界面对应的布局是activity_main
         * R表示一个类，layout是一个内部类，activity_main是一个int类型的常量
         * R类是动态生成的
         */
        setContentView(R.layout.activity_main);

        //根据id为tv的textView控件
        TextView tv = findViewById(R.id.testView);
        //然后可以进行一些设置，不同的控件有不同的设置方法
        tv.setText("控件传值测试");   //这个才重要了

        //根据id为btn的Button空间
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击按钮后，它就会执行这个方法
                //基本上所有的Android都是这样一个使用方法
                //显示一个提示，就是Android特有的吐司
                Toast.makeText(MainActivity.this,"点击成功",Toast.LENGTH_SHORT).show(); //注意，创建吐司一定要调用show()方法
            }
        });

        //点击按钮2跳转至另外一个页面,打开新界面
        Button btn2 = findViewById(R.id.secBtn);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                //启动这个意图里面的activity
                startActivity(intent);
            }
        });

    }

    public void openNewActivity(View view) {
        Intent intent03 = new Intent(MainActivity.this, ThirdActivity.class);
        startActivity(intent03);
    }

    public void getText(View view) {
        final EditText et = findViewById(R.id.editText);
        String text = et.getText().toString().trim();
        Toast.makeText(MainActivity.this,text,Toast.LENGTH_SHORT).show();
    }

    public void showImage(View view) {
        Intent intent04 = new Intent(MainActivity.this, FourthActivity.class);
        startActivity(intent04);
    }

    public void goToList(View view) {
        Intent intent05 = new Intent(MainActivity.this, RecyclerActivity.class);
        startActivity(intent05);
    }

    //请求百度网站
    public void getNetworkData(View view) {
        //创建一个线程
        //android不允许在主线程中请求网络
        //也可以在AsyncTask这样的异步任务里同步调用
        new Thread(){
            @Override
            public void run() {
                super.run();
                //创建一个Request，里面包括要请求的网址等信息
                //同时这个类是构建这模式，
                Request request = new Request.Builder().url("http://www.baidu.com/").build();

                try{
                    //然后调用newCall方法，传入刚刚创建的Request对象
                    //然后调用execute方法来执行这个请求
                    Response response = client.newCall(request).execute();
                    //通过调用response的body上的string方法可以得到流的字符串
                    String result = response.body().string();

                    //将返回的字符串打印到日志
                    //这里不能直接将数据设置到界面上
                    //因为子线程不能操作界面（android规定）
                    //如果要更新，需要通过其他方式
                    Log.d("TAG",result);
                }catch (IOException e){
                    e.printStackTrace();
                }

            }
        }.start();
    }
}

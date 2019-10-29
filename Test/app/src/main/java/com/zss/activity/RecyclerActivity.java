package com.zss.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.zss.adapter.ListAdapter;
import com.zss.test.R;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);


        RecyclerView rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        //设置一个布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        //创建一个ArrayList
        //添加一下测试数据

        ArrayList<String> strings = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            strings.add("Android的ArrayList数据测试："+i);
        }

        //设置一个适配器,通过适配器
        ListAdapter listAdapter = new ListAdapter(this,strings);
        rv.setAdapter(listAdapter);
    }
}


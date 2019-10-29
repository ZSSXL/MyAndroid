package com.zss.squirrelmusic.activities;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zss.squirrelmusic.R;
import com.zss.squirrelmusic.adapters.MusicGridAdapter;
import com.zss.squirrelmusic.adapters.MusicListAdapter;
import com.zss.squirrelmusic.views.GridSpaceItemDecoration;

public class MainActivity extends BaseActivity {

    private RecyclerView mRvGrid,mRvList;
    private MusicGridAdapter mGridAdapter;
    private MusicListAdapter mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView(){
        initNavBar(false,"松鼠音乐",true);

        mRvGrid = fd(R.id.rv_grid);
        // 同一行展示三个元素
        mRvGrid.setLayoutManager(new GridLayoutManager(this,3));

        mRvGrid.addItemDecoration(new GridSpaceItemDecoration(getResources().getDimensionPixelSize(R.dimen.albumMarginSize),mRvGrid));
        mRvGrid.setNestedScrollingEnabled(false);
        mGridAdapter = new MusicGridAdapter(this);
        mRvGrid.setAdapter(mGridAdapter);


        /**
         * 1、假如已知列表高度的情况下，可以直接在布局中把RecyclerView的高度定义上
         * 2、不知道列表高度的情况下，需要收订计算RecyclerView的高度
         */

        mRvList = fd(R.id.rv_list);
        mRvList.setLayoutManager(new LinearLayoutManager(this));
        mRvList.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mRvList.setNestedScrollingEnabled(false);
        mListAdapter = new MusicListAdapter(this,mRvList);

        mRvList.setAdapter(mListAdapter);
    }
}

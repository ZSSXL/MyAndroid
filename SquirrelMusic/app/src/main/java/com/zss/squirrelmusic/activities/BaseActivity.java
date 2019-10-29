package com.zss.squirrelmusic.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zss.squirrelmusic.R;

public class BaseActivity extends Activity {

    private ImageView mIvBack,mIvMe;
    private TextView mTvTitle;

    /**
     * 封装findViewById方法
     * @param id
     * @param <T>
     * @return
     */
    protected <T extends View> T fd(@IdRes int id){
        return findViewById(id);
    }

    /**
     * 初始化NavigationBar
     * @param isShowBack
     * @param title
     * @param isShowMe
     */
    protected void initNavBar(boolean isShowBack,String title,boolean isShowMe){

        mIvBack = fd(R.id.iv_back);
        mIvMe = fd(R.id.iv_me);
        mTvTitle = fd(R.id.tv_title);

        mIvBack.setVisibility(isShowBack ? View.VISIBLE:View.GONE);
        mIvMe.setVisibility(isShowMe ? View.VISIBLE:View.GONE);
        mTvTitle.setText(title);

        // 返回箭头功能实现
        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mIvMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BaseActivity.this,MeActivity.class));
            }
        });
    }

}

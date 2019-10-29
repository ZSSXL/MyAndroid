package com.zss.squirrelmusic.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.widget.ImageView;


// AppCompatImageView
public class WEqualsHImageViw extends AppCompatImageView {

    public WEqualsHImageViw(Context context) {
        super(context);
    }

    public WEqualsHImageViw(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public WEqualsHImageViw(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);



       /* // 获取View宽度
        int width = MeasureSpec.getSize(widthMeasureSpec);

        // 获取View模式 match_parent、war_content、具体dp
        int mode = MeasureSpec.getMode(widthMeasureSpec);*/



    }
}

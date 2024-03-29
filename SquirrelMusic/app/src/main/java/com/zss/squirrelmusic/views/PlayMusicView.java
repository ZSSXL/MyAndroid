package com.zss.squirrelmusic.views;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zss.squirrelmusic.R;
import com.zss.squirrelmusic.helps.MediaPlayerHelper;

public class PlayMusicView extends FrameLayout {

    private Context mContext;
    private boolean isPaying;
    private View mView;
    private FrameLayout mFlPlayMusic;
    private ImageView mIvIcon,mIVNeedle,mIvPlay;
    private MediaPlayerHelper mMediaPlayerHelper;
    private String mPath;
    private Animation mPlayMusicAnim,mPlayNeedleAnim,mStopNeedleAnim;


    public PlayMusicView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public PlayMusicView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PlayMusicView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public PlayMusicView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context){
        mContext = context;

        mView = LayoutInflater.from(mContext).inflate(R.layout.play_music, this, false);
        mFlPlayMusic = mView.findViewById(R.id.fl_play_music);



        mIvIcon = mView.findViewById(R.id.iv_cover);
        mIVNeedle = mView.findViewById(R.id.iv_needle);
        mIvPlay = mView.findViewById(R.id.iv_play);


        mFlPlayMusic.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                trigger();
            }
        });
        /**
         * 1、定义所需要执行的的动画
         *    1、光盘转动的动画
         *    2、指针指向光盘的动画
         *    3、指针离开光盘的动画
         * 2、startAnimation
         */
        mPlayMusicAnim = AnimationUtils.loadAnimation(mContext,R.anim.play_music_anim);
        mPlayNeedleAnim = AnimationUtils.loadAnimation(mContext,R.anim.play_needle_anim);
        mStopNeedleAnim= AnimationUtils.loadAnimation(mContext,R.anim.stop_needle_anim);

        addView(mView);

        mMediaPlayerHelper = MediaPlayerHelper.getInstance(mContext);
    }

    /**
     * 切换播放状态
     */
    private void trigger(){
        if(isPaying){
            stopMusic();
        }else{
            playMusic(mPath);
        }
    }

    /**
     * 播放音乐
     */
    public void playMusic(String path){
        mPath = path;
        isPaying = true;
        mIvPlay.setVisibility(View.GONE);
        mFlPlayMusic.startAnimation(mPlayMusicAnim);
        mIVNeedle.startAnimation(mPlayNeedleAnim);


        /**
         * 1、判断当前音乐是否是已经在播放的音乐
         * 2、如果当前音乐是已经在播放的音乐，执行start方法
         * 3、如果当前音乐不是已经在播放的音乐，执行setPath方法
         */

        if(mMediaPlayerHelper.getPath() != null && mMediaPlayerHelper.getPath().equals(path)){
            mMediaPlayerHelper.start();// 继续播放音乐
        }else{
            mMediaPlayerHelper.setPath(path);
            mMediaPlayerHelper.setOnMediaPlayerHelperListener(new MediaPlayerHelper.OnMediaPlayerHelperListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mMediaPlayerHelper.start();
                }
            });
        }
    }

    /**
     * 停止播放
     */
    public void stopMusic(){
        isPaying = false;
        mIvPlay.setVisibility(View.VISIBLE);
        mFlPlayMusic.clearAnimation();
        mIVNeedle.startAnimation(mStopNeedleAnim);
        mMediaPlayerHelper.pause();
    }

    /**
     * 设置光盘中显示的音乐封面图片
     */
    public void setMusicIcon(String icon){
        Glide.with(mContext)
                .load(icon)
                .into(mIvIcon);
    }


}

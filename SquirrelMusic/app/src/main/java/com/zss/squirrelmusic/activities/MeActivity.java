package com.zss.squirrelmusic.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zss.squirrelmusic.R;
import com.zss.squirrelmusic.helps.UserHelp;
import com.zss.squirrelmusic.utils.UserUtils;

public class MeActivity extends BaseActivity {

    private TextView mTvUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        initView();
    }

    private void initView(){
        initNavBar(true,"个人中心",false);

        mTvUser = fd(R.id.tv_user);
        mTvUser.setText("用户名:"+ UserHelp.getInstance().getPhone());
    }


    /**
     * 修改密码点击事件
     * @param view
     */
    public void onChangeClick(View view) {
        Intent intent = new Intent(this, ChangePasswordActivity.class);
        startActivity(intent);
    }

    /**
     * 退出登录点击事件
     * @param view
     */
    public void onLogoutClick(View view) {
        UserUtils.logout(this);
    }
}

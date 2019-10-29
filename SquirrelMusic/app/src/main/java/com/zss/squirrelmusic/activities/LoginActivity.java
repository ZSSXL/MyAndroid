package com.zss.squirrelmusic.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zss.squirrelmusic.R;
import com.zss.squirrelmusic.utils.UserUtils;
import com.zss.squirrelmusic.views.InputView;

public class LoginActivity extends BaseActivity {

    private InputView  mInputPhone,mInputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    /**
     * 初始化view
     */
    private void initView(){
        initNavBar(false,"登录",false);

        mInputPhone = fd(R.id.input_phone);
        mInputPassword = fd(R.id.input_password);
    }

    /**
     * 跳转注册页面点击事件
     * @param view
     */
    public void onRegisterClick(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    /**
     *
     * @param view
     */
    public void onCommitClick(View view) {

        String password = mInputPassword.getInputStr();
        String phone = mInputPhone.getInputStr();

        // 验证身份输入是否合法
       if(!UserUtils.validateLogin(this,phone,password)){
            return;
        }

        // 跳转到应用主页
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}

package com.zss.squirrelmusic.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.zss.squirrelmusic.R;
import com.zss.squirrelmusic.utils.UserUtils;
import com.zss.squirrelmusic.views.InputView;

public class ChangePasswordActivity extends BaseActivity {

    private InputView mOldPassword,mPassword,mPasswordConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        initView();
    }

    private void initView() {
        initNavBar(true,"修改密码",false);

        mOldPassword = fd(R.id.input_old_password);
        mPassword = fd(R.id.input_password);
        mPasswordConfirm = fd(R.id.input_password_confirm);


    }

    /**
     * 修改密码确定按钮
     * @param view
     */
    public void onChangePasswordClick(View view) {

        String oldPassword = mOldPassword.getInputStr();
        String password = mPassword.getInputStr();
        String passwordConfirm = mPasswordConfirm.getInputStr();

        boolean result = UserUtils.changePassword(this, oldPassword, password, passwordConfirm);
        if(!result){
            return;
        }

        // 返回登陆页面
        UserUtils.logout(this);
    }
}

package com.zss.squirrelmusic.activities;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Toast;

import com.zss.squirrelmusic.R;
import com.zss.squirrelmusic.utils.UserUtils;
import com.zss.squirrelmusic.views.InputView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class RegisterActivity extends BaseActivity {

    private InputView mInputPhone,mInputPassword,mInputPasswordConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();
    }


    /**
     * 初始化View
     */
    private void initView(){
        initNavBar(true,"注册",false);

        mInputPhone = fd(R.id.input_phone);
        mInputPassword = fd(R.id.input_password);
        mInputPasswordConfirm = fd(R.id.input_password_confirm);

    }


    /**
     * 注册按钮点击事件
     * 1、用户输入合法性验证
     * 2、用户输入的手机号是否合法
     * 3、是否已经输入了密码和确认密码，两者是否相同
     * 4、判断用户输入的手机号是否已经被注册
     * 5、保存用户输入的手机号和密码
     * @param view
     */
    public void onRegisterClick(View view) {

        String phone = mInputPhone.getInputStr();
        String password = mInputPassword.getInputStr();
        String passwordConfirm = mInputPasswordConfirm.getInputStr();

        boolean result = UserUtils.registerUser(this, phone, password, passwordConfirm);

        if(!result){
            return;
        }

        // 后退页面
        onBackPressed();
    }

}

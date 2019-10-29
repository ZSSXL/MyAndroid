package com.zss.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zss.kanmeitu.MainActivity;
import com.zss.kanmeitu.R;
import com.zss.utils.Constants;
import com.zss.utils.RegexUtil;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        Button btn = findViewById(R.id.btn_login);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                login();
                break;

        }
    }

    private void login() {
        //获取用户输入的邮箱，密码，做校验
        String user = username.getText().toString().trim();

        //判断是否输入了邮箱
        if(TextUtils.isEmpty(user)){
            Toast.makeText(this,R.string.email_hint,Toast.LENGTH_SHORT).show();
            return;
        }

        //通过正则表达式判断邮箱格式是否正确
       if(!RegexUtil.isEmail(user)){
           Toast.makeText(this,R.string.email_error,Toast.LENGTH_SHORT).show();;
            return;
       }

       //获取用户的密码
       String pass = password.getText().toString().trim();

       //判断是否输入了密码
        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this,R.string.password_hint,Toast.LENGTH_SHORT).show();
            return;
        }

        //判断密码长度是否位6~15位
        if(pass.length()<6||password.length()>15){
            Toast.makeText(this,R.string.password_length_error,Toast.LENGTH_SHORT).show();;
            return;
        }

        if(Constants.USERNAME.equals(user) && Constants.PASSWORD.equals(pass)){
            //登录成功，进入首页
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

            //关闭当前界面
            finish();
        }else{
            //登录失败，进行提示
            Toast.makeText(this,R.string.username_or_password_error,Toast.LENGTH_SHORT).show();
        }
    }
}

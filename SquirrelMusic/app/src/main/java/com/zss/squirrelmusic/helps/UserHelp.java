package com.zss.squirrelmusic.helps;


import android.content.Context;
import android.content.SharedPreferences;

import com.zss.squirrelmusic.constants.SPConstants;

/**
 * 实现自动登录功能
 * 1、用户登录
 *      1、当用户登录时，利用SharedPreferences 保存用户的登录的用户标记（手机号码）
 *      2、利用全局单例类UserHelp保存用户的登录信息
 *              1、用户登录之后
 *              2、用户重新打开应用程序，检测SharedPreferences 中是否存在登录用户标记
 *                 ，如果存在则未UserHelp进行赋值，并且进入主页面，如果不存在，则进入登录页面
 * 2、用户退出
 *      1、删除掉SharedPreferences 保存的用户标记，退出到登录页面
 *
 */
public class UserHelp {

    private static UserHelp instance;

    private UserHelp(){};

    public static UserHelp getInstance(){
        if(instance == null){
            synchronized (UserHelp.class){
                if(instance == null){
                    instance = new UserHelp();
                }
            }
        }
        return instance;
    }

    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}

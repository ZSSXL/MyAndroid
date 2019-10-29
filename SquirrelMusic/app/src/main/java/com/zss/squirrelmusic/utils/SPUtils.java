package com.zss.squirrelmusic.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.textservice.TextInfo;

import com.zss.squirrelmusic.constants.SPConstants;
import com.zss.squirrelmusic.helps.UserHelp;

public class SPUtils {

    /**
     * 当用户登录时，利用SharedPreferences 保存用户的登录的用户标记（手机号码）
     */
    public static boolean saveUser(Context context,String phone){
        SharedPreferences sp = context.getSharedPreferences(SPConstants.SP_NAME_USER, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(SPConstants.SP_KEY_PHONE,phone);
        boolean result = editor.commit();

        return result;
    }


    /**
     * 验证是否存在已登录用户
     */
    public static boolean isLoginUser(Context context){
        boolean result = false;
        SharedPreferences sp = context.getSharedPreferences(SPConstants.SP_NAME_USER, Context.MODE_PRIVATE);
        String phone = sp.getString(SPConstants.SP_KEY_PHONE, "");
        if(!TextUtils.isEmpty(phone)){
            result = true;
            UserHelp.getInstance().setPhone(phone);
        }

        return result;
    }

    /**
     * 删除用户标记
     */

    public static boolean removeUser(Context context){
        SharedPreferences sp = context.getSharedPreferences(SPConstants.SP_NAME_USER, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(SPConstants.SP_KEY_PHONE);
        boolean result = editor.commit();
        return result;
    }

}

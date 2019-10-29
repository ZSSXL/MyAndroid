package com.zss.squirrelmusic.helps;

import com.zss.squirrelmusic.models.UserModel;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class RealmHelp{

    private Realm mRealm;

    public RealmHelp(){
        mRealm = Realm.getDefaultInstance();
    }

    /**
     * 保存用户信息
     */
    public void saveUser(UserModel userModel){
        mRealm.beginTransaction();
        mRealm.insert(userModel); // 无则插入，有则报错
//        mRealm.insertOrUpdate(userModel); // 无则插入，有则更新
        mRealm.commitTransaction();

    }

    /**
     * 关闭数据库
     */
    public void close(){

        if(mRealm != null && !mRealm.isClosed()){
            mRealm.close();
        }

    }

    /**
     * 返回所有用户
     */
    public List<UserModel> getAllUser(){
        RealmQuery<UserModel> query = mRealm.where(UserModel.class);
        RealmResults<UserModel> results = query.findAll();
        return results;
    }

    /**
     * 验证用户信息
     */
    public boolean validateUser(String phone,String password){
        boolean result = false;

        RealmQuery<UserModel> query = mRealm.where(UserModel.class);
        query = query.equalTo("phone", phone).equalTo("password", password);
        UserModel userModel = query.findFirst();

        if(userModel != null){
            result = true;
        }
        return result;
    }

    /**
     * 获取当前用户，匹配原密码
     */
    public UserModel getUser(){
        RealmQuery<UserModel> query = mRealm.where(UserModel.class);
        UserModel userModel = query.equalTo("phone", UserHelp.getInstance().getPhone()).findFirst();
        return userModel;
    }


    /**
     * 修改密码
     */
    public void changePassword(String password){
        UserModel userModel = getUser();
        mRealm.beginTransaction();
        userModel.setPassword(password);
        mRealm.commitTransaction();
    }

}

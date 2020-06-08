package com.zjp.base.aop;

import android.content.Context;

/**
 * Created by zjp on 2020/6/8 16:23
 */
public class LoginManager {

    private static LoginManager instance;
    private LoginManager(){}

    public static LoginManager getInstance(){
        if (null == instance){
            synchronized (LoginManager.class){
                if (null == instance){
                    instance = new LoginManager();
                }
            }
        }
        return instance;
    }


    public void init(Context context, ILoginFilter iLoginFilter){
        LoginAssistant.getInstance().setApplicationContext(context);
        LoginAssistant.getInstance().setILoginFilter(iLoginFilter);
    }
}

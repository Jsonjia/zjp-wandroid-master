package com.zjp.base.aop;

import android.content.Context;

/**
 * Created by zjp on 2020/6/8 16:22
 */
public class LoginAssistant {

    private LoginAssistant() {
    }

    private static LoginAssistant instance;

    public static final LoginAssistant getInstance() {
        if (instance == null) {
            synchronized (LoginAssistant.class) {
                if (null == instance) {
                    instance = new LoginAssistant();
                }
            }
        }
        return instance;
    }

    private ILoginFilter iLoginFilter;

    public ILoginFilter getILoginFilter() {
        return iLoginFilter;
    }

    public void setILoginFilter(ILoginFilter iLoginFilter) {
        this.iLoginFilter = iLoginFilter;
    }

    private Context applicationContext;

    public Context getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(Context applicationContext) {
        this.applicationContext = applicationContext;
    }
}

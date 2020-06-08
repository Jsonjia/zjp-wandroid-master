package com.zjp.base.aop;

import android.content.Context;

/**
 * Created by zjp on 2020/6/8 16:21
 */
public interface ILoginFilter  {

    void login(Context ctx, int loginDefine);

    boolean isLogin(Context ctx);

    void clearLoginStatus(Context ctx);
}

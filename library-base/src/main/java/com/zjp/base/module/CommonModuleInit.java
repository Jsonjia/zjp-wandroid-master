package com.zjp.base.module;

import android.content.Context;
import android.content.Intent;

import com.alibaba.android.arouter.launcher.ARouter;
import com.kingja.loadsir.core.LoadSir;
import com.tencent.mmkv.MMKV;
import com.zjp.base.aop.ILoginFilter;
import com.zjp.base.aop.LoginManager;
import com.zjp.base.application.BaseApplication;
import com.zjp.base.loadsir.EmptyCallback;
import com.zjp.base.loadsir.ErrorCallback;
import com.zjp.base.loadsir.LoadingCallback;

import org.aspectj.lang.annotation.Around;

/**
 * Created by zjp on 2020/5/9 16:37
 */
public class CommonModuleInit implements IModuleInit {

    @Override
    public boolean onInitAhead(BaseApplication application) {

        MMKV.initialize(application);

        LoadSir.beginBuilder()
                .addCallback(new ErrorCallback())
                .addCallback(new LoadingCallback())
                .addCallback(new EmptyCallback())
                .setDefaultCallback(LoadingCallback.class)
                .commit();

        if (application.isDebug()) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(application);

        LoginManager.getInstance().init(application, iLoginFilter);
//        LoginManger.getInstance().init(this,iLoginFilter);
        return false;
    }

    @Override
    public boolean onInitLow(BaseApplication application) {
        return false;
    }

    ILoginFilter iLoginFilter = new ILoginFilter() {
        @Override
        public void login(Context ctx, int loginDefine) {
            switch (loginDefine) {
                case 0:
//                    ARouter.getInstance().build(RouterActivityPath.Login.LOGIN).navigation();
                    break;

            }
        }

        @Override
        public boolean isLogin(Context ctx) {
            return false;
        }

        @Override
        public void clearLoginStatus(Context ctx) {

        }
    };
}

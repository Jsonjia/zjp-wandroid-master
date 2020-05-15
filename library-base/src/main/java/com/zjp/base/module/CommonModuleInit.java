package com.zjp.base.module;

import com.alibaba.android.arouter.launcher.ARouter;
import com.kingja.loadsir.core.LoadSir;
import com.zjp.base.application.BaseApplication;
import com.zjp.base.loadsir.EmptyCallback;
import com.zjp.base.loadsir.ErrorCallback;
import com.zjp.base.loadsir.LoadingCallback;

/**
 * Created by zjp on 2020/5/9 16:37
 */
public class CommonModuleInit implements IModuleInit {

    @Override
    public boolean onInitAhead(BaseApplication application) {

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
        return false;
    }

    @Override
    public boolean onInitLow(BaseApplication application) {
        return false;
    }
}

package com.zjp.base.module;

import com.alibaba.android.arouter.launcher.ARouter;
import com.zjp.base.application.BaseApplication;

/**
 * Created by zjp on 2020/5/9 16:37
 */
public class CommonModuleInit implements IModuleInit {

    @Override
    public boolean onInitAhead(BaseApplication application) {
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

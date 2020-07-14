package com.zjp.wandroid;

import com.zjp.base.application.BaseApplication;
import com.zjp.base.config.ModuleLifecycleConfig;

/**
 * Created by zjp on 2020/4/30 16:33
 */
public class WanAndroidApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        setDebug(BuildConfig.DEBUG);
        // 初始化需要初始化的组件
        ModuleLifecycleConfig.getInstance().initModuleAhead(this);
    }
}

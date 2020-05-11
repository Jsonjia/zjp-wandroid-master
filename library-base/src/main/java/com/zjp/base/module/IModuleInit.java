package com.zjp.base.module;

import com.zjp.base.application.BaseApplication;

/**
 * Created by zjp on 2020/5/9 16:36
 * 类描述: 动态配置组件Application,有需要初始化的组件实现该接口,统一在宿主app 的Application进行初始化
 */
public interface IModuleInit {

    /**
     * 需要优先初始化的
     */
    boolean onInitAhead(BaseApplication application);

    /**
     * 可以后初始化的
     */
    boolean onInitLow(BaseApplication application);
}

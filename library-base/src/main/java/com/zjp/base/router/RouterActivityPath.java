package com.zjp.base.router;

/**
 * Created by zjp on 2020/5/6 17:04
 * 类描述: 用于在组件化开发中,利用ARouter 进行Activity跳转的统一路径注册, 注册时请写好注释、标注界面功能业务
 */
public class RouterActivityPath {

    /**
     * Login 组件
     */
    public static class Login {
        public static final String LOGIN = "/login/Login";
    }

    /**
     * main组件
     */
    public static class Main {

        private static final String MAIN = "/main";

        /**
         * 主页面
         */
        public static final String PAGER_MAIN = MAIN + "/Main";


        /**
         * 引导页
         */
        public static final String PAGER_GUIDE = MAIN + "/Guide";
    }
}

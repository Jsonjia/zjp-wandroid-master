package com.zjp.common.router;

/**
 * Created by zjp on 2020/5/6 17:05
 */
public class RouterFragmentPath {

    /**
     * 首页组件
     */
    public static class Home {
        private static final String HOME = "/home";

        /**
         * 首页
         */
        public static final String PAGER_HOME = HOME + "/Home";

    }

    /**
     * 项目 组件
     */
    public static class Project {
        private static final String PROJECT = "/project";

        /**
         * 项目 页面
         */
        public static final String PAGER_PROJECT = PROJECT + "/Project";
    }

    /**
     * 广场 组件
     */
    public static class Square {
        private static final String SQUARE = "/square";

        /**
         * 控制页
         */
        public static final String PAGER_SQUARE = SQUARE + "/Square";
    }

    /**
     * 公众号 组件
     */
    public static class OfficialAccount {
        private static final String OFFICIALACCOUNT = "/officialaccount";

        /**
         * 公众号 页面
         */
        public static final String PAGER_OFFICIALACCOUNT = OFFICIALACCOUNT + "/OfficialAccount";
    }

    /**
     * 我的 组件
     */
    public static class Mine {
        private static final String MINE = "/mine";

        /**
         * 我的 页面
         */
        public static final String PAGER_MINE = MINE + "/Mine";
    }
}

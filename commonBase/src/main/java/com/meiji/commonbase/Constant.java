package com.meiji.commonbase;

/**
 * 常量
 */
public class Constant {

    public static final String EXTRA_KEY = "key";

    public static final class Router {
        public static final String MODULE_HOME = "/moduleHome/";
        public static final String MODULE_DASH = "/moduleDashboard/";
        public static final String MODULE_NOTI = "/moduleNotifications/";

        // moduleHome
        public static final String toHomeProvider = MODULE_HOME + "HomeProvider";
        public static final String toHomeFragment = MODULE_HOME + "HomeFragment";

        // moduleDashboard
        public static final String toDashFragment = MODULE_DASH + "DashFragment";

        // moduleNotifications
        public static final String toNotiFragment = MODULE_NOTI + "NotiFragment";
    }
}

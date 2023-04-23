package com.zhb.zhbwebrtc.utils;

import android.os.Build;
import android.util.Log;


public class LogUtils {
    private static final String TAG = "ZHB_WEBRTC";
    private static final boolean IS_DEBUGGABLE = true;
//    private static final boolean IS_DEBUGGABLE = Build.IS_DEBUGGABLE;
    private static final boolean IS_PRODUCTION = false;
//    private static final boolean IS_PRODUCTION = SystemPropertiesHelper.getBoolean("ro.product.is_production", true);

    private static final boolean LOG_VERBOSE = isLoggableMoto(Log.VERBOSE);
    private static final boolean LOG_DEBUG = isLoggableMoto(Log.DEBUG);
    private static final boolean LOG_INFO = isLoggableMoto(Log.INFO);
    private static final boolean LOG_WARN = isLoggableMoto(Log.WARN);
    private static final boolean LOG_ERROR = isLoggableMoto(Log.ERROR);

    //    private static final int LOG_LEVEL = Log.VERBOSE;
    private static final int LOG_LEVEL = Log.DEBUG;
//    private static final int LOG_LEVEL = android.util.Log.INFO;

    private static boolean isLoggableMoto(int level) {
        //It`s used to verify the log level, don`t remove them.
//        Log.d(TAG, "--------->test log isLoggableMoto Build.IS_DEBUGGABLE="+ IS_DEBUGGABLE
//                + ", isProduction="+ IS_PRODUCTION + ", level=" + level);
        if(IS_DEBUGGABLE || !IS_PRODUCTION){
            return level >= LOG_LEVEL;
        }
        return Log.isLoggable(TAG, level);
    }

    public static boolean isPrintFileTransferLog() {
        if(IS_DEBUGGABLE || !IS_PRODUCTION){
            return true;
        }
        return false;
    }

    public static void v(String className, String msg) {
        if (LOG_VERBOSE) {
            Log.v(TAG, generateMsg(className, msg));
        }
    }

    public static void d(String className, String msg) {
        if (LOG_DEBUG) {
            Log.d(TAG, generateMsg(className, msg));
        }
    }

    public static void d(String className, String msg, Throwable tr) {
        if (LOG_DEBUG) {
            Log.d(TAG, generateMsg(className, msg), tr);
        }
    }

    public static void i(String className, String msg) {
        if (LOG_INFO) {
            Log.i(TAG, generateMsg(className, msg));
        }
    }

    public static void w(String className, String msg) {
        if (LOG_WARN) {
            Log.w(TAG, generateMsg(className, msg));
        }
    }

    public static void w(String className, String msg, Throwable tr) {
        if (LOG_WARN) {
            Log.w(TAG, generateMsg(className, msg), tr);
        }
    }

    public static void e(String className, String msg) {
        if (LOG_ERROR) {
            Log.e(TAG, generateMsg(className, msg));
        }
    }

    public static void e(String className, String msg, Throwable tr) {
        if (LOG_ERROR) {
            Log.e(TAG, generateMsg(className, msg), tr);
        }
    }

    public static void wtf(String className, String msg) {
        if (LOG_ERROR) {
            Log.wtf(TAG, generateMsg(className, msg));
        }
    }

    private static String generateMsg(String className, String msg) {
        return "[ " + className + " ] - " + msg;
    }
}

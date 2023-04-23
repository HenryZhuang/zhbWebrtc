package com.zhb.zhbwebrtc.webrtc;

import android.content.Context;

import com.zhb.zhbwebrtc.utils.LogUtils;

public class WebrtcManager {
    private static final String TAG = "WebrtcManager";

    private static WebrtcManager singleton;
    private Context mContext;

    private WebrtcManager(Context context) {
        LogUtils.d(TAG, "WebrtcManager constructor");
        mContext = context.getApplicationContext();
    }
    public static synchronized WebrtcManager getInstance(Context context) {
        if (singleton == null) {
            synchronized (WebrtcManager.class) {
                if (singleton == null) {
                    singleton = new WebrtcManager(context);
                }
            }
        }
        return singleton;
    }
}

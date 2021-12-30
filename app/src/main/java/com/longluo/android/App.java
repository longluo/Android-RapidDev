package com.longluo.android;

import android.app.Application;
import android.content.Context;

import io.github.longluo.library.umeng.UmengClient;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initSdk(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        // 清理所有图片内存缓存
//        GlideApp.get(this).onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        // 根据手机内存剩余情况清理图片内存缓存
//        GlideApp.get(this).onTrimMemory(level);
    }

    /**
     * 初始化一些第三方框架
     */
    public static void initSdk(Application application) {
        // 友盟统计、登录、分享 SDK
        UmengClient.init(application, true);

    }
}

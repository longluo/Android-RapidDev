package com.longluo.android;

import android.app.Application;
import android.content.Context;

import com.longluo.android.db.greendao.DbCore;
import com.umeng.commonsdk.UMConfigure;


public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        DbCore.init(this);
        DbCore.enableQueryBuilderLog();

        UMConfigure.preInit(this,"61bc361fe014255fcbbb8876","Mine");
    }

}

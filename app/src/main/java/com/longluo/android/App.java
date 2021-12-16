package com.longluo.android;

import android.app.Application;

import com.longluo.android.db.DbCore;


public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        DbCore.init(this);
        DbCore.enableQueryBuilderLog();
    }
}

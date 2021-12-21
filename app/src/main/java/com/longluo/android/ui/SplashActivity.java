package com.longluo.android.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.longluo.android.R;


public class SplashActivity extends AppCompatActivity {
    private static final String LOG_TAG = SplashActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        initData();
    }

    private void initData() {
        Log.d(LOG_TAG, "initData");
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        this.startActivity(intent);
        SplashActivity.this.finish();
    }
}

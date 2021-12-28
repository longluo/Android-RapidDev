package io.github.longluo.baseframework.interfaces;

import io.github.longluo.baseframework.BaseActivity;

public abstract class GlobalLifeCircleListener {
    public void onCreate(BaseActivity me, String className) {
    }

    public void onResume(BaseActivity me, String className) {
    }

    public void onPause(BaseActivity me, String className) {
    }

    public void onDestroy(BaseActivity me, String className) {
    }

    public void windowFocus(BaseActivity me, String className, boolean hasFocus) {
    }

    public void onStart(BaseActivity activity, String className) {
    }

    public void onStop(BaseActivity activity, String className) {
    }
}

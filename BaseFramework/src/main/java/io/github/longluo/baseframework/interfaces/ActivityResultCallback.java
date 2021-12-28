package io.github.longluo.baseframework.interfaces;

import android.content.Intent;

import androidx.annotation.Nullable;

public abstract class ActivityResultCallback {

    public ActivityResultCallback(int resultId) {
        this.resultId = resultId;
    }

    public ActivityResultCallback() {
    }

    public int resultId;

    public int getResultId() {
        return resultId;
    }

    public ActivityResultCallback setResultId(int resultId) {
        this.resultId = resultId;
        return this;
    }

    public abstract void onActivityResult(int requestCode, int resultCode, @Nullable Intent data);
}

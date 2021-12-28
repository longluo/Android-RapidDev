package io.github.longluo.baseframework.util;

public interface OnPermissionResponseListener {
    void onSuccess(String[] permissions);
    void onFail();
}

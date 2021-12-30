package com.longluo.android.http.api;

import com.hjq.http.config.IRequestApi;

/**
 * 获取用户信息
 */
public final class UserInfoApi implements IRequestApi {

    @Override
    public String getApi() {
        return "user/info";
    }

    public final class Bean {

    }
}
package me.longluo.android.http.api;

import com.hjq.http.config.IRequestApi;

/**
 * 退出登录
 */
public final class LogoutApi implements IRequestApi {

    @Override
    public String getApi() {
        return "user/logout";
    }
}
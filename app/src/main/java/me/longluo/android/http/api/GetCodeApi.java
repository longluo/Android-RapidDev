package me.longluo.android.http.api;

import com.hjq.http.config.IRequestApi;

/**
 * 获取验证码
 */
public final class GetCodeApi implements IRequestApi {

    @Override
    public String getApi() {
        return "code/get";
    }

    /**
     * 手机号
     */
    private String phone;

    public GetCodeApi setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
package com.longluo.android.http.api;

import com.hjq.http.config.IRequestApi;

/**
 * 验证码校验
 */
public final class VerifyCodeApi implements IRequestApi {

    @Override
    public String getApi() {
        return "code/checkout";
    }

    /**
     * 手机号
     */
    private String phone;
    /**
     * 验证码
     */
    private String code;

    public VerifyCodeApi setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public VerifyCodeApi setCode(String code) {
        this.code = code;
        return this;
    }
}
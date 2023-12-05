package me.longluo.android.http.api;

import com.hjq.http.config.IRequestApi;

import java.io.File;

/**
 * 上传图片
 */
public final class UpdateImageApi implements IRequestApi {

    @Override
    public String getApi() {
        return "update/image";
    }

    /**
     * 图片文件
     */
    private File image;

    public UpdateImageApi setImage(File image) {
        this.image = image;
        return this;
    }
}
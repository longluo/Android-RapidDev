package me.longluo.android.ui.popup;

import android.content.Context;

import me.longluo.android.R;

import io.github.longluo.base.BasePopupWindow;

/**
 * 可进行拷贝的副本
 */
public final class CopyPopup {

    public static final class Builder
            extends BasePopupWindow.Builder<Builder> {

        public Builder(Context context) {
            super(context);

            setContentView(R.layout.copy_popup);
        }
    }
}
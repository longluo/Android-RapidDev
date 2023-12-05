package me.longluo.android.ui.fragment;

import me.longluo.android.R;
import me.longluo.android.app.AppFragment;
import me.longluo.android.ui.activity.CopyActivity;

/**
 * 可进行拷贝的副本
 */
public final class CopyFragment extends AppFragment<CopyActivity> {

    public static CopyFragment newInstance() {
        return new CopyFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.copy_fragment;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
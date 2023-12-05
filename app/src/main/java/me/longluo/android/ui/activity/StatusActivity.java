package me.longluo.android.ui.activity;

import androidx.core.content.ContextCompat;

import me.longluo.android.R;
import me.longluo.android.action.StatusAction;
import me.longluo.android.app.AppActivity;
import me.longluo.android.ui.dialog.MenuDialog;
import me.longluo.android.widget.StatusLayout;

/**
 * 加载使用案例
 */
public final class StatusActivity extends AppActivity
        implements StatusAction {

    private StatusLayout mStatusLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.status_activity;
    }

    @Override
    protected void initView() {
        mStatusLayout = findViewById(R.id.hl_status_hint);
    }

    @Override
    protected void initData() {
        new MenuDialog.Builder(this)
                //.setAutoDismiss(false) // 设置点击按钮后不关闭对话框
                .setList("加载中", "请求错误", "空数据提示", "自定义提示")
                .setListener((dialog, position, object) -> {
                    switch (position) {
                        case 0:
                            showLoading();
                            postDelayed(this::showComplete, 2500);
                            break;
                        case 1:
                            showError(listener -> {
                                showLoading();
                                postDelayed(this::showEmpty, 2500);
                            });
                            break;
                        case 2:
                            showEmpty();
                            break;
                        case 3:
                            showLayout(ContextCompat.getDrawable(getActivity(), R.drawable.status_order_ic), "暂无订单", null);
                            break;
                        default:
                            break;
                    }
                })
                .show();
    }

    @Override
    public StatusLayout getStatusLayout() {
        return mStatusLayout;
    }
}
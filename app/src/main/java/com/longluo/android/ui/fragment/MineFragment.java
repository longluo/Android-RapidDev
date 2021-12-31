package com.longluo.android.ui.fragment;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.view.View;

import com.longluo.android.R;
import com.longluo.android.aop.SingleClick;
import com.longluo.android.app.TitleBarFragment;
import com.longluo.android.ui.activity.AboutActivity;
import com.longluo.android.ui.activity.BrowserActivity;
import com.longluo.android.ui.activity.DialogActivity;
import com.longluo.android.ui.activity.GuideActivity;
import com.longluo.android.ui.activity.HomeActivity;
import com.longluo.android.ui.activity.ImagePreviewActivity;
import com.longluo.android.ui.activity.ImageSelectActivity;
import com.longluo.android.ui.activity.LoginActivity;
import com.longluo.android.ui.activity.PasswordForgetActivity;
import com.longluo.android.ui.activity.PasswordResetActivity;
import com.longluo.android.ui.activity.PersonalDataActivity;
import com.longluo.android.ui.activity.PhoneResetActivity;
import com.longluo.android.ui.activity.RegisterActivity;
import com.longluo.android.ui.activity.SettingActivity;
import com.longluo.android.ui.activity.StatusActivity;
import com.longluo.android.ui.activity.VideoPlayActivity;
import com.longluo.android.ui.activity.VideoSelectActivity;
import com.longluo.android.ui.dialog.InputDialog;
import com.longluo.android.ui.dialog.MessageDialog;
import com.tencent.bugly.crashreport.CrashReport;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的 Fragment
 */
public final class MineFragment extends TitleBarFragment<HomeActivity> {

    public static MineFragment newInstance() {
        return new MineFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.mine_fragment;
    }

    @Override
    protected void initView() {
        setOnClickListener(R.id.btn_mine_dialog, R.id.btn_mine_hint, R.id.btn_mine_login, R.id.btn_mine_register, R.id.btn_mine_forget,
                R.id.btn_mine_reset, R.id.btn_mine_change, R.id.btn_mine_personal, R.id.btn_mine_setting, R.id.btn_mine_about,
                R.id.btn_mine_guide, R.id.btn_mine_browser, R.id.btn_mine_image_select, R.id.btn_mine_image_preview,
                R.id.btn_mine_video_select, R.id.btn_mine_video_play, R.id.btn_mine_crash, R.id.btn_mine_pay);
    }

    @Override
    protected void initData() {

    }

    @SingleClick
    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        if (viewId == R.id.btn_mine_dialog) {

            startActivity(DialogActivity.class);

        } else if (viewId == R.id.btn_mine_hint) {

            startActivity(StatusActivity.class);

        } else if (viewId == R.id.btn_mine_login) {

            startActivity(LoginActivity.class);

        } else if (viewId == R.id.btn_mine_register) {

            startActivity(RegisterActivity.class);

        } else if (viewId == R.id.btn_mine_forget) {

            startActivity(PasswordForgetActivity.class);

        } else if (viewId == R.id.btn_mine_reset) {

            startActivity(PasswordResetActivity.class);

        } else if (viewId == R.id.btn_mine_change) {

            startActivity(PhoneResetActivity.class);

        } else if (viewId == R.id.btn_mine_personal) {

            startActivity(PersonalDataActivity.class);

        } else if (viewId == R.id.btn_mine_setting) {

            startActivity(SettingActivity.class);

        } else if (viewId == R.id.btn_mine_about) {

            startActivity(AboutActivity.class);

        } else if (viewId == R.id.btn_mine_guide) {

            startActivity(GuideActivity.class);

        } else if (viewId == R.id.btn_mine_browser) {

            new InputDialog.Builder(getAttachActivity())
                    .setTitle("跳转到网页")
                    .setContent("http://www.longluo.me")
                    .setHint("请输入网页地址")
                    .setConfirm(getString(R.string.common_confirm))
                    .setCancel(getString(R.string.common_cancel))
                    .setListener((dialog, content) -> BrowserActivity.start(getAttachActivity(), content))
                    .show();

        } else if (viewId == R.id.btn_mine_image_select) {

            ImageSelectActivity.start(getAttachActivity(), new ImageSelectActivity.OnPhotoSelectListener() {

                @Override
                public void onSelected(List<String> data) {
                    toast("选择了" + data.toString());
                }

                @Override
                public void onCancel() {
                    toast("取消了");
                }
            });

        } else if (viewId == R.id.btn_mine_image_preview) {

            ArrayList<String> images = new ArrayList<>();
            images.add("https://www.baidu.com/img/bd_logo.png");
            images.add("https://avatars1.githubusercontent.com/u/28616817");
            ImagePreviewActivity.start(getAttachActivity(), images, images.size() - 1);

        } else if (viewId == R.id.btn_mine_video_select) {

            VideoSelectActivity.start(getAttachActivity(), new VideoSelectActivity.OnVideoSelectListener() {

                @Override
                public void onSelected(List<VideoSelectActivity.VideoBean> data) {
                    toast("选择了" + data.toString());
                }

                @Override
                public void onCancel() {
                    toast("取消了");
                }
            });

        } else if (viewId == R.id.btn_mine_video_play) {

            new VideoPlayActivity.Builder()
                    .setVideoTitle("速度与激情特别行动")
                    .setVideoSource("http://vfx.mtime.cn/Video/06/29/mp4/190629004821240734.mp4")
                    .setActivityOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
                    .start(getAttachActivity());

        } else if (viewId == R.id.btn_mine_crash) {

            // 上报错误到 Bugly 上
            CrashReport.postCatchedException(new IllegalStateException("are you ok?"));
            // 关闭 Bugly 异常捕捉
            CrashReport.closeBugly();
            throw new IllegalStateException("are you ok?");

        } else if (viewId == R.id.btn_mine_pay) {

            new MessageDialog.Builder(getAttachActivity())
                    .setTitle("捐赠")
                    .setMessage("如果你觉得这个开源项目很棒，希望它能更好地坚持开发下去，可否愿意花一点点钱（推荐 10.24 元）作为对于开发者的激励")
                    .setConfirm("支付宝")
                    .setCancel(null)
                    //.setAutoDismiss(false)
                    .setListener(dialog -> {
                        BrowserActivity.start(getAttachActivity(), "https://github.com/longluo/Android_Dev_Quick");
                        toast("AndroidProject 因为有你的支持而能够不断更新、完善，非常感谢支持！");
                        postDelayed(() -> {
                            try {
                                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("alipays://platformapi/startapp?saId=10000007&clientVersion=3.7.0.0718&qrcode=https%3A%2F%2Fqr.alipay.com%2FFKX04202G4K6AVCF5GIY66%3F_s%3Dweb-other"));
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            } catch (ActivityNotFoundException e) {
                                toast("打开支付宝失败，你可能还没有安装支付宝客户端");
                            }
                        }, 2000);
                    })
                    .show();
        }
    }

    @Override
    public boolean isStatusBarEnabled() {
        // 使用沉浸式状态栏
        return !super.isStatusBarEnabled();
    }
}
package com.longluo.android;

import android.content.DialogInterface;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.longluo.android.bean.User;

import java.io.File;

import io.github.longluo.baseframework.BaseApp;
import io.github.longluo.baseframework.BaseFrameworkSettings;
import io.github.longluo.baseframework.interfaces.OnBugReportListener;
import io.github.longluo.baseframework.interfaces.OnSDKInitializedCallBack;
import io.github.longluo.baseframework.util.AppManager;
import io.github.longluo.baseframework.util.SettingsUtil;

public class App extends BaseApp<App> {

    @Override
    public void init() {
        setOnSDKInitializedCallBack(new OnSDKInitializedCallBack() {
            @Override
            public void onInitialized() {
                log("onInitialized: ");
                Toast.makeText(me, "SDK已加载完毕", Toast.LENGTH_LONG).show();
            }
        });

        setOnCrashListener(new OnBugReportListener() {
            @Override
            public boolean onCrash(Exception e, final File crashLogFile) {
                if (AppManager.getInstance().getActiveActivity() == null || !AppManager.getInstance().getActiveActivity().isActive) {
                    return false;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(AppManager.getInstance().getActiveActivity());
                builder.setTitle("Ops！发生了一次崩溃！");
                builder.setMessage("您是否愿意帮助我们改进程序以修复此Bug？");
                builder.setPositiveButton("愿意", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        toast("请对file进行处理：" + crashLogFile.getAbsolutePath());
                    }
                });
                builder.setNegativeButton("不了", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setCancelable(false);
                AlertDialog dialog = builder.create();
                dialog.show();

                return false;
            }
        });

//        Bitmap bm = null;       //随便写的 Demo
//        App.cache.set("key","value");
//        App.cache.set("bitmap",bm);
//        App.cache.clean();

        User user = new User("张三", 18, "192.168.1.1");
        App.user.set("userInfo", user);
    }

    public static USER user = new USER();

    public static class USER extends SettingsUtil {

        public USER() {
            super("user");
        }
    }

    public static CACHE cache;

    public static class CACHE extends SettingsUtil {

        public CACHE() {
            super("cache");
        }
    }

    @Override
    public void initSDKs() {
        BaseFrameworkSettings.DEBUGMODE = true;
        BaseFrameworkSettings.BETA_PLAN = true;
        try {
            Thread.sleep(8000);
        } catch (Exception e) {
        }
    }
}

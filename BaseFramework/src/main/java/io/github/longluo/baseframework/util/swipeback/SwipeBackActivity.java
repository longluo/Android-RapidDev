package io.github.longluo.baseframework.util.swipeback;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import io.github.longluo.baseframework.util.swipeback.util.SwipeBackActivityBase;
import io.github.longluo.baseframework.util.swipeback.util.SwipeBackActivityHelper;
import io.github.longluo.baseframework.util.swipeback.util.SwipeBackLayout;
import io.github.longluo.baseframework.util.swipeback.util.SwipeBackUtil;

public class SwipeBackActivity extends AppCompatActivity implements SwipeBackActivityBase {
    private SwipeBackActivityHelper mHelper;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHelper = new SwipeBackActivityHelper(this);
        mHelper.onActivityCreate();
    }
    
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mHelper.onPostCreate();
    }
    
    @Override
    public SwipeBackLayout getSwipeBackLayout() {
        return mHelper.getSwipeBackLayout();
    }
    
    @Override
    public void setSwipeBackEnable(boolean enable) {
        getSwipeBackLayout().setEnableGesture(enable);
    }
    
    @Override
    public void scrollToFinishActivity() {
        SwipeBackUtil.convertActivityToTranslucent(this);
        getSwipeBackLayout().scrollToFinishActivity();
    }
}

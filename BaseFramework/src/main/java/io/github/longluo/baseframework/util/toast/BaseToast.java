package io.github.longluo.baseframework.util.toast;


public abstract class BaseToast {
    
    public abstract BaseToast show(String msg);
    
    public abstract BaseToast show(int layoutResId);
    
    public abstract BaseToast cancel();
    
}

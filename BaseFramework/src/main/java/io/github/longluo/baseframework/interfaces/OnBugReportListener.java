package io.github.longluo.baseframework.interfaces;

import java.io.File;

public abstract class OnBugReportListener {

    @Deprecated
    public void onReporter(File file) {

    }

    public abstract boolean onCrash(Exception e, File crashLogFile);
}
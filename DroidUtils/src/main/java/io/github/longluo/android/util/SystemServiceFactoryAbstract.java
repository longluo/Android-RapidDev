package io.github.longluo.android.util;

import android.content.Context;

public interface SystemServiceFactoryAbstract {
    Object get(Context context, String name);
}

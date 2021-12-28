package io.github.longluo.baseframework.interfaces;

import android.view.View;

import java.util.List;

public interface MultipleAdapterSettings<D> {
    Object setViewHolder(int type, View convertView);

    void setData(int type, Object vh, D data, List<D> dataList, int index);
}
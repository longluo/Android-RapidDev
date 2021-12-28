package io.github.longluo.baseframework.interfaces;

import android.view.View;

import java.util.List;

public interface SimpleAdapterSettings<V, D> {
    V setViewHolder(View convertView);

    void setData(V viewHolder, D data, List<D> dataList, int index);
}

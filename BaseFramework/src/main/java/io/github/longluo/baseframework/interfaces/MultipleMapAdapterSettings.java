package io.github.longluo.baseframework.interfaces;

import android.view.View;

import java.util.List;
import java.util.Map;

public interface MultipleMapAdapterSettings {
    Object setViewHolder(int type, View convertView);

    void setData(int type, Object vh, Map<String, Object> data, List<Map<String, Object>> dataList, int index);
}
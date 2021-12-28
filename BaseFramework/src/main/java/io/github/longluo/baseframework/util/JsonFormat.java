package io.github.longluo.baseframework.util;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static io.github.longluo.baseframework.BaseFrameworkSettings.DEBUGMODE;
import static io.github.longluo.baseframework.util.DebugLogG.getCodeLineStr;


public class JsonFormat {

    public static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static boolean formatJson(String msg) {
        if (!DEBUGMODE) {
            return false;
        }
        String message;
        try {
            if (msg.startsWith("{")) {
                JSONObject jsonObject = new JSONObject(msg);
                message = jsonObject.toString(4);//最重要的方法，就一行，返回格式化的json字符串，其中的数字4是缩进字符数
            } else if (msg.startsWith("[")) {
                JSONArray jsonArray = new JSONArray(msg);
                message = jsonArray.toString(4);
            } else {
                return false;
            }
        } catch (JSONException e) {
            return false;
        }
        Log.v(">>>>>>", getCodeLineStr(false) + message);
        return true;
    }

}
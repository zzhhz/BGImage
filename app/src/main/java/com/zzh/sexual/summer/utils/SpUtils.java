package com.zzh.sexual.summer.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.yyx.beautifylib.model.BLResultParam;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017/11/28.
 *
 * @date: 2017/11/28
 * @email: zzh_hz@126.com
 * @QQ: 1299234582
 * @author: zzh
 * @description: 数据持久化
 */
public class SpUtils {

    public static final String XML_NAME = "sexual_summer";
    public static final String XML_KEY_LIST_PICTURE = "list_picture";

    public static void putList(Context ctx, BLResultParam value) {
        SharedPreferences sp = ctx.getSharedPreferences(XML_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(XML_KEY_LIST_PICTURE, JSON.toJSONString(value));
        Log.d("---------", "putString: " + JSON.toJSONString(value));
        editor.commit();
    }

    public static void putString(Context ctx, List<String> value) {
        JSONArray array = new JSONArray();
        array.put(value);
        SharedPreferences sp = ctx.getSharedPreferences(XML_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(XML_KEY_LIST_PICTURE, array.toString());
        Log.d("---------", "putString: " + array.toString());
        editor.commit();
    }

    public static String getString(Context ctx) {
        SharedPreferences sp = ctx.getSharedPreferences(XML_NAME, Context.MODE_PRIVATE);
        return sp.getString(XML_KEY_LIST_PICTURE, "");
    }

    public static BLResultParam getList(Context ctx) {
        String string = getString(ctx);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        BLResultParam params = JSON.parseObject(string, BLResultParam.class);
        return params;
    }
}

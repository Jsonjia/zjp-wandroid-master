package com.zjp.common.storage;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.mmkv.MMKV;
import com.zjp.common.bean.UserInfo;
import com.zjp.network.constant.C;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by zjp on 2020/5/26 10:27
 */
public class MmkvHelper {

    private static MMKV mmkv;
    private final Gson mGson = new Gson();

    private MmkvHelper() {
        mmkv = MMKV.defaultMMKV();
    }

    public static MmkvHelper getInstance() {
        return MmkvHolder.INSTANCE;
    }

    private static class MmkvHolder {
        private static final MmkvHelper INSTANCE = new MmkvHelper();
    }

    public MMKV getMmkv() {
        return mmkv;
    }

    /**
     * 存入map集合
     */
    public void saveInfo(String key, Map<String, Object> map) {
        Gson gson = new Gson();
        JSONArray mJsonArray = new JSONArray();
        JSONObject object = null;
        try {
            object = new JSONObject(gson.toJson(map));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mJsonArray.put(object);
        mmkv.encode(key, mJsonArray.toString());
    }

    /**
     * 获取map集合
     */
    public Map<String, String> getInfo(String key) {
        Map<String, String> itemMap = new HashMap<>();
        String result = mmkv.decodeString(key, "");
        try {
            JSONArray array = new JSONArray(result);
            for (int i = 0; i < array.length(); i++) {
                JSONObject itemObject = array.getJSONObject(i);

                JSONArray names = itemObject.names();
                if (names != null) {
                    for (int j = 0; j < names.length(); j++) {
                        String name = names.getString(j);
                        String value = itemObject.getString(name);
                        itemMap.put(name, value);
                    }
                }
            }
        } catch (JSONException e) {

        }
        return itemMap;
    }

    /**
     * 保存list
     */
    public <T> void saveList(String tag, List<T> dataList) {
        if (null == dataList || dataList.size() <= 0)
            return;
        //转换成json数据，再保存
        String strJson = mGson.toJson(dataList);
        mmkv.encode(tag, strJson);
    }

    /**
     * 获取list
     */
    public <T> List<T> getDataList(String tag) {
        List<T> dataList = new ArrayList<>();
        String strJson = mmkv.decodeString(tag, null);
        if (null == strJson) {
            return dataList;
        }
        dataList = mGson.fromJson(strJson, new TypeToken<List<T>>() {
        }.getType());
        return dataList;
    }

    /**
     * 是否是第一次启动app
     */
    public boolean isFirst() {
//        MMKV mmkv = MMKV.defaultMMKV();
        return mmkv.encode(C.FIRST, false);
    }

    public boolean getFirst() {
//        MMKV mmkv = MMKV.defaultMMKV();
        return mmkv.decodeBool(C.FIRST, true);
    }

    /**
     * 保存用户信息
     */
    public void saveUserInfo(UserInfo userInfo) {
        mmkv.encode(C.USER_INFO, userInfo);
    }

    public UserInfo getUserInfo() {
        return mmkv.decodeParcelable(C.USER_INFO, UserInfo.class);
    }

    public void clearHistory(String key) {
        mmkv.remove(key);
    }

    public void removeKeywords(String keywords) {
        List<String> dataList = getDataList(C.SEARCH_HISTORY);
        if (null == dataList || dataList.size() == 0) {
            return;
        }
        //用这个方法出错，原因：https://www.cnblogs.com/zhuyeshen/p/10956822.html
//        for (String str : dataList) {
//            if (TextUtils.equals(keywords, str)) {
//                dataList.remove(str);
//                saveList(C.SEARCH_HISTORY, dataList);
//            }
//        }
        Iterator<String> iterator = dataList.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (TextUtils.equals(keywords, str)) {
                iterator.remove();
                saveList(C.SEARCH_HISTORY, dataList);
            }
        }
    }


    //首页文章是否显示置顶
    public boolean showTopArticle(boolean showTop) {
        return mmkv.encode(C.SHOW_TOP_ARTICLE, showTop);
    }

    public boolean getShowTopArticle() {
        return mmkv.decodeBool(C.SHOW_TOP_ARTICLE, true);
    }

}

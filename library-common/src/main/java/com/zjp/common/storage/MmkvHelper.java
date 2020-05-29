package com.zjp.common.storage;

import com.google.gson.Gson;
import com.tencent.mmkv.MMKV;
import com.zjp.common.bean.UserInfo;
import com.zjp.network.constant.ApiConstants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zjp on 2020/5/26 10:27
 */
public class MmkvHelper {

    private static MMKV mmkv;

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
     *
     * @param key 标识
     * @param map 数据集合
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
     * 是否是第一次启动app
     */
    public boolean isFirst() {
        MMKV mmkv = MMKV.defaultMMKV();
        return mmkv.encode("first", false);
    }

    public boolean getFirst() {
        MMKV mmkv = MMKV.defaultMMKV();
        return mmkv.decodeBool("first", true);
    }

    /**
     * 保存用户信息
     */
    public void saveUserInfo(UserInfo userInfo) {
        mmkv.encode(ApiConstants.USER_INFO, userInfo);
    }

    public UserInfo getUserInfo() {
        return mmkv.decodeParcelable(ApiConstants.USER_INFO, UserInfo.class);
    }

}

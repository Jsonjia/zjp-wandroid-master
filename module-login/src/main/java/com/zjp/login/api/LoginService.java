package com.zjp.login.api;

import com.zjp.common.bean.UserInfo;
import com.zjp.network.bean.BaseResponse;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by zjp on 2020/5/28 14:34
 */
public interface LoginService {

    //注册
    @FormUrlEncoded
    @POST("user/register")
    Observable<BaseResponse<UserInfo>> register(@FieldMap Map<String, Object> map);

    //登录
    @FormUrlEncoded
    @POST("user/login")
    Observable<BaseResponse<UserInfo>> login(@FieldMap Map<String, Object> map);
}

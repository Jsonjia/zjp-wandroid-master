package com.zjp.mine.api;

import com.zjp.mine.bean.Integral;
import com.zjp.network.bean.BaseResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by zjp on 2020/07/07 15:56
 */
public interface MineService {

    //获取个人积分
    @GET("lg/coin/userinfo/json")
    Observable<BaseResponse<Integral>> getIntegral();

    //退出登录
    @GET("user/logout/json")
    Observable<BaseResponse> logout();
}

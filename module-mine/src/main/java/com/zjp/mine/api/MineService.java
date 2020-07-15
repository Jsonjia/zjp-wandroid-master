package com.zjp.mine.api;

import com.zjp.mine.bean.Integral;
import com.zjp.mine.bean.Leaderboard;
import com.zjp.network.bean.BaseResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

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

    //积分排行榜接口
    @GET("coin/rank/{page}/json")
    Observable<BaseResponse<List<Leaderboard>>> getRankList(@Path("page") int page);
}

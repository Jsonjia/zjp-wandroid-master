package com.zjp.home.api;

import com.zjp.home.bean.BannerEntity;
import com.zjp.network.bean.BaseResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by zjp on 2020/5/10 14:19.
 */
public interface HomeService {

    //首页Banner
    @GET("/banner/json")
    Observable<BaseResponse<List<BannerEntity>>> getBanner();
}

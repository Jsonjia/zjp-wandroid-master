package com.zjp.home.api;

import com.zjp.home.bean.ArticleEntity;
import com.zjp.home.bean.BannerEntity;
import com.zjp.network.bean.BaseResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by zjp on 2020/5/10 14:19.
 */
public interface HomeService {

    //首页Banner
    @GET("banner/json")
    Observable<BaseResponse<List<BannerEntity>>> getBanner();

    //获取首页【置顶】文章数据
    @GET("article/top/json")
    Observable<BaseResponse<List<ArticleEntity.DatasBean>>> getTopList();

    //首页文章列表
    @GET("article/list/{page}/json")
    Observable<BaseResponse<ArticleEntity>> getHomeList(@Path("page") int pageNo);

}

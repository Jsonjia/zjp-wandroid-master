package com.zjp.home.api;

import com.zjp.common.bean.ArticleEntity;
import com.zjp.home.bean.BannerEntity;
import com.zjp.home.bean.HotSearchEntity;
import com.zjp.network.bean.BaseResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

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

    //热门搜索
    @GET("hotkey/json")
    Observable<BaseResponse<List<HotSearchEntity>>> hotSearch();

    //搜索内容
    @POST("article/query/{page}/json")
    Observable<BaseResponse<ArticleEntity>> search(@Path("page") int pageNo, @Query("k") String k);

    //收藏
    @POST("/lg/collect/{id}/json")
    Observable<BaseResponse> collect(@Path("id") int id);

    //取消收藏
    @POST("lg/uncollect_originId/{id}/json")
    Observable<BaseResponse> unCollect(@Path("id") int id);

}

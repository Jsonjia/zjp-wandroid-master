package com.zjp.project.api;

import com.zjp.common.bean.ArticleEntity;
import com.zjp.network.bean.BaseResponse;
import com.zjp.project.bean.ProjectTabBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by zjp on 2020/7/1 10:52
 */
public interface ProjectService {

    //获取项目tab
    @GET("/project/tree/json")
    Observable<BaseResponse<List<ProjectTabBean>>> getProjectTab();

    //获取项目list
    @GET("/project/list/{pageNum}/json")
    Observable<BaseResponse<ArticleEntity>> getProjectList(@Path("pageNum") int pageNum, @Query("cid") int cid);

    //收藏
    @POST("/lg/collect/{id}/json")
    Observable<BaseResponse> collect(@Path("id") int id);

    //取消收藏
    @POST("lg/uncollect_originId/{id}/json")
    Observable<BaseResponse> unCollect(@Path("id") int id);

}

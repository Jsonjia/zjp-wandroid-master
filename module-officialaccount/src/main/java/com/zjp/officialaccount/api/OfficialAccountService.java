package com.zjp.officialaccount.api;

import com.zjp.common.bean.ProjectTabBean;
import com.zjp.network.bean.BaseResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by zjp on 2020/08/21 11:32
 */
public interface OfficialAccountService {

    //获取公众号作者 tab
    @GET("wxarticle/chapters/json")
    Observable<BaseResponse<List<ProjectTabBean>>> getAuthorTabList();
}

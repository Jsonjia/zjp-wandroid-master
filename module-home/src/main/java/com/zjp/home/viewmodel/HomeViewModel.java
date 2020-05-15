package com.zjp.home.viewmodel;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.home.api.HomeService;
import com.zjp.home.bean.ArticleEntity;
import com.zjp.home.bean.BannerEntity;
import com.zjp.network.bean.BaseResponse;
import com.zjp.network.https.RetrofitHelper;
import com.zjp.network.observer.NetCallback;
import com.zjp.network.observer.NetHelperObserver;
import com.zjp.network.scheduler.IoMainScheduler;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zjp on 2020/5/11 14:37
 */
public class HomeViewModel extends BaseViewModel {

    public MutableLiveData<List<BannerEntity>> mBannerListMutable = new MutableLiveData<>();
    public MutableLiveData<List<ArticleEntity.DatasBean>> mArticleListMutable = new MutableLiveData<>();

    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    public void getBanner() {
        RetrofitHelper.getInstance().create(HomeService.class)
                .getBanner()
                .compose(new IoMainScheduler<>())
                .doOnSubscribe(this)  //  请求与ViewModel周期同步
                .subscribe(new NetHelperObserver<>(new NetCallback<BaseResponse<List<BannerEntity>>>() {
                    @Override
                    public void success(BaseResponse<List<BannerEntity>> response) {
                        if (response.getData() != null && response.getData().size() > 0) {
                            mBannerListMutable.postValue(response.getData());
                        } else {

                        }
                    }

                    @Override
                    public void error(String msg) {

                    }
                }));
    }

    @SuppressLint("CheckResult")
    public void getArticleList(int page) {
        HomeService homeService = RetrofitHelper.getInstance().create(HomeService.class);
        Observable.zip(homeService.getTopList(),
                homeService.getHomeList(page),
                // 注：创建BiFunction对象传入的第3个参数 = 合并后数据的数据类型
                new BiFunction<BaseResponse<List<ArticleEntity.DatasBean>>, BaseResponse<ArticleEntity>, List<ArticleEntity.DatasBean>>() {
                    @Override
                    public List<ArticleEntity.DatasBean> apply(BaseResponse<List<ArticleEntity.DatasBean>> listBaseResponse, BaseResponse<ArticleEntity> articleEntityBaseResponse) throws Exception {
                        List<ArticleEntity.DatasBean> data = listBaseResponse.getData();
                        data.addAll(articleEntityBaseResponse.getData().getDatas());
                        return data;
                    }
                }).compose(new IoMainScheduler<>())
                .doOnSubscribe(this)
                .subscribe(new Consumer<List<ArticleEntity.DatasBean>>() {
                    // 成功返回数据时调用
                    @Override
                    public void accept(List<ArticleEntity.DatasBean> datasBeans) throws Exception {
                        // 结合显示2个网络请求的数据结果
                        mArticleListMutable.postValue(datasBeans);
                    }
                }, new Consumer<Throwable>() {
                    // 网络请求错误时调用
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}

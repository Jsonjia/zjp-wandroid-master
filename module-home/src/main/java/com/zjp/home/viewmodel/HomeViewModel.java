package com.zjp.home.viewmodel;

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

    public MutableLiveData<List<BannerEntity>> mBannerList = new MutableLiveData<>();

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
                            mBannerList.postValue(response.getData());
                        } else {

                        }
                    }

                    @Override
                    public void error(String msg) {

                    }
                }));
    }

    public void getArticleList(int page) {
        HomeService homeService = RetrofitHelper.getInstance().create(HomeService.class);
        Observable.zip(homeService.getTopList(),
                homeService.getHomeList(page),
                new BiFunction<BaseResponse<List<ArticleEntity.DatasBean>>, BaseResponse<ArticleEntity>, List<ArticleEntity.DatasBean>>() {
                    @Override
                    public List<ArticleEntity.DatasBean> apply(BaseResponse<List<ArticleEntity.DatasBean>> listBaseResponse, BaseResponse<ArticleEntity> articleEntityBaseResponse) throws Exception {
                        List<ArticleEntity.DatasBean> data = new ArrayList<>();

                        data.addAll(0, listBaseResponse.getData());
                        ArticleEntity data1 = articleEntityBaseResponse.getData();
                        data.addAll(data1.getDatas());
                        return data;
                    }
                }).compose(new IoMainScheduler<>())
                .subscribe(new Consumer<List<ArticleEntity.DatasBean>>() {
                    @Override
                    public void accept(List<ArticleEntity.DatasBean> datasBeans) throws Exception {
                        Log.d("zjp1", "最终接收到的数据是：" + datasBeans.get(0).getTitle());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });

//
//        Observable<BaseResponse<List<ArticleEntity.DatasBean>>> topList = homeService.getTopList().subscribeOn(Schedulers.io());
//        Observable<BaseResponse<ArticleEntity>> homeList = homeService.getHomeList(page).subscribeOn(Schedulers.io());
//
//        Observable.zip(topList, homeList,
//                new BiFunction<BaseResponse<List<ArticleEntity.DatasBean>>, BaseResponse<ArticleEntity>,  List<ArticleEntity.DatasBean>>() {
//                    @Override
//                    public  List<ArticleEntity.DatasBean> apply(BaseResponse<List<ArticleEntity.DatasBean>> listBaseResponse, BaseResponse<ArticleEntity> articleEntityBaseResponse) throws Exception {
//
//                        List<ArticleEntity.DatasBean> data = new ArrayList<>();
//
////                        List<ArticleEntity.DatasBean> data = listBaseResponse.getData();
//
//                        data.addAll(0, listBaseResponse.getData());
//
//
//                        ArticleEntity data1 = articleEntityBaseResponse.getData();
//                        data.addAll(data1.getDatas());
//
//
//                        return data;
//                    }
//                }).observeOn(AndroidSchedulers.mainThread()) // 在主线程接收 & 处理数据
//                .subscribe(new Consumer< List<ArticleEntity.DatasBean>>() {
//                    @Override
//                    public void accept( List<ArticleEntity.DatasBean> s) throws Exception {
//                        Log.d("zjp1", "最终接收到的数据是：" + s.get(0).getTitle());
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//                        Log.d("zjp1", "throwable：" + throwable);
//                    }
//                });


    }

}

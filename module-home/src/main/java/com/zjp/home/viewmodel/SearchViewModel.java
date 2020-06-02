package com.zjp.home.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.home.api.HomeService;
import com.zjp.home.bean.ArticleEntity;
import com.zjp.home.bean.HotSearchEntity;
import com.zjp.network.bean.BaseResponse;
import com.zjp.network.https.RetrofitHelper;
import com.zjp.network.observer.NetCallback;
import com.zjp.network.observer.NetHelperObserver;
import com.zjp.network.scheduler.IoMainScheduler;

import java.util.List;

/**
 * Created by zjp on 2020/6/2 17:01
 */
public class SearchViewModel extends BaseViewModel {

    public MutableLiveData<ArticleEntity> mArticleSearch = new MutableLiveData<>();
    public MutableLiveData<List<HotSearchEntity>> mHotSearchMutable = new MutableLiveData<>();

    public SearchViewModel(@NonNull Application application) {
        super(application);
    }

    public void search(int page,String k){
        RetrofitHelper.getInstance().create(HomeService.class)
                .search(page,k)
                .compose(new IoMainScheduler<>())
                .doOnSubscribe(this)
                .subscribe(new NetHelperObserver<>(new NetCallback<BaseResponse<ArticleEntity>>() {
                    @Override
                    public void success(BaseResponse<ArticleEntity> response) {
                        if (response.getData() != null) {
                            mArticleSearch.postValue(response.getData());
                        }
                    }

                    @Override
                    public void error(String msg) {

                    }
                }));
    }

    public void hotSearch(){
        RetrofitHelper.getInstance().create(HomeService.class)
                .hotSearch()
                .compose(new IoMainScheduler<>())
                .doOnSubscribe(this)
                .subscribe(new NetHelperObserver<>(new NetCallback<BaseResponse<List<HotSearchEntity>>>() {
                    @Override
                    public void success(BaseResponse<List<HotSearchEntity>> response) {
                        if (response.getData() != null) {
                            mHotSearchMutable.postValue(response.getData());
                        }
                    }

                    @Override
                    public void error(String msg) {

                    }
                }));
    }

}

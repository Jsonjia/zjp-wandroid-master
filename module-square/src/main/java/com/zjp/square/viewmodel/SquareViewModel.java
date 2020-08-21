package com.zjp.square.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.common.bean.ArticleEntity;
import com.zjp.common.bean.ProjectTabBean;
import com.zjp.network.bean.BaseResponse;
import com.zjp.network.https.RetrofitHelper;
import com.zjp.network.observer.NetCallback;
import com.zjp.network.observer.NetHelperObserver;
import com.zjp.network.scheduler.IoMainScheduler;
import com.zjp.square.api.SquareService;
import com.zjp.square.bean.NaviBean;

import java.util.List;

/**
 * Created by zjp on 2020/08/20 14:17
 */
public class SquareViewModel extends BaseViewModel {

    public MutableLiveData<List<ProjectTabBean>> mSystemListMutable = new MutableLiveData<>();
    public MutableLiveData<ArticleEntity> mArticleMuTable = new MutableLiveData<>();
    public MutableLiveData<BaseResponse> mCollectMutable = new MutableLiveData<>();
    public MutableLiveData<BaseResponse> mUnCollectMutable = new MutableLiveData<>();
    public MutableLiveData<List<NaviBean>> mArticleListMuTable = new MutableLiveData<>();

    public SquareViewModel(@NonNull Application application) {
        super(application);
    }

    public void getSystemList() {
        RetrofitHelper.getInstance().create(SquareService.class)
                .getSystemList()
                .compose(new IoMainScheduler<>())
                .doOnSubscribe(this)  //  请求与ViewModel周期同步
                .subscribe(new NetHelperObserver<>(new NetCallback<BaseResponse<List<ProjectTabBean>>>() {
                    @Override
                    public void success(BaseResponse<List<ProjectTabBean>> response) {
                        if (response.getData() != null && response.getData().size() > 0) {
                            mSystemListMutable.postValue(response.getData());
                        } else {

                        }
                    }

                    @Override
                    public void error(String msg) {

                    }
                }));
    }

    public void getProjectList(int page, int cid) {
        RetrofitHelper.getInstance().create(SquareService.class)
                .getProjectList(page, cid)
                .compose(new IoMainScheduler<>())
                .doOnSubscribe(this)  //  请求与ViewModel周期同步
                .subscribe(new NetHelperObserver<>(new NetCallback<BaseResponse<ArticleEntity>>() {
                    @Override
                    public void success(BaseResponse<ArticleEntity> response) {
                        mArticleMuTable.setValue(response.getData());
                    }

                    @Override
                    public void error(String msg) {

                    }
                }));
    }

    public void collect(int id) {
        RetrofitHelper.getInstance().create(SquareService.class)
                .collect(id)
                .compose(new IoMainScheduler<>())
                .doOnSubscribe(this)
                .subscribe(new NetHelperObserver<>(new NetCallback<BaseResponse>() {
                    @Override
                    public void success(BaseResponse response) {
                        mCollectMutable.postValue(response);
                    }

                    @Override
                    public void error(String msg) {

                    }
                }));
    }

    public void unCollect(int id) {
        RetrofitHelper.getInstance().create(SquareService.class)
                .unCollect(id)
                .compose(new IoMainScheduler<>())
                .doOnSubscribe(this)
                .subscribe(new NetHelperObserver<>(new NetCallback<BaseResponse>() {
                    @Override
                    public void success(BaseResponse response) {
                        mUnCollectMutable.postValue(response);
                    }

                    @Override
                    public void error(String msg) {

                    }
                }));
    }

    public void getNavigation() {
        RetrofitHelper.getInstance().create(SquareService.class)
                .getNavigation()
                .compose(new IoMainScheduler<>())
                .doOnSubscribe(this)
                .subscribe(new NetHelperObserver<>(new NetCallback<BaseResponse<List<NaviBean>>>() {
                    @Override
                    public void success(BaseResponse<List<NaviBean>> response) {
                        if (response.getData() != null && response.getData().size() > 0) {
                            mArticleListMuTable.postValue(response.getData());
                        } else {

                        }
                    }

                    @Override
                    public void error(String msg) {

                    }
                }));
    }
}

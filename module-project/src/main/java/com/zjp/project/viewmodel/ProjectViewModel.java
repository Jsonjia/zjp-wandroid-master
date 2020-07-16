package com.zjp.project.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.common.bean.ArticleEntity;
import com.zjp.network.bean.BaseResponse;
import com.zjp.network.https.RetrofitHelper;
import com.zjp.network.observer.NetCallback;
import com.zjp.network.observer.NetHelperObserver;
import com.zjp.network.scheduler.IoMainScheduler;
import com.zjp.project.api.ProjectService;
import com.zjp.project.bean.ProjectTabBean;

import java.util.List;

/**
 * Created by zjp on 2020/7/1 10:50
 */
public class ProjectViewModel extends BaseViewModel {

    public MutableLiveData<List<ProjectTabBean>> mProjectListMutable = new MutableLiveData<>();
    public MutableLiveData<List<ArticleEntity.DatasBean>> mArticleListMutable = new MutableLiveData<>();
    public MutableLiveData<BaseResponse> mCollectMutable = new MutableLiveData<>();
    public MutableLiveData<BaseResponse> mUnCollectMutable = new MutableLiveData<>();

    public ProjectViewModel(@NonNull Application application) {
        super(application);
    }

    public void getProjectTab() {
        RetrofitHelper.getInstance().create(ProjectService.class)
                .getProjectTab()
                .compose(new IoMainScheduler<>())
                .doOnSubscribe(this)  //  请求与ViewModel周期同步
                .subscribe(new NetHelperObserver<>(new NetCallback<BaseResponse<List<ProjectTabBean>>>() {
                    @Override
                    public void success(BaseResponse<List<ProjectTabBean>> response) {
                        if (response.getData() != null && response.getData().size() > 0) {
                            mProjectListMutable.postValue(response.getData());
                        } else {

                        }
                    }

                    @Override
                    public void error(String msg) {

                    }
                }));
    }

    public void getProjectList(int pageNum, int id) {
        RetrofitHelper.getInstance().create(ProjectService.class)
                .getProjectList(pageNum, id)
                .compose(new IoMainScheduler<>())
                .doOnSubscribe(this)
                .subscribe(new NetHelperObserver<>(new NetCallback<BaseResponse<ArticleEntity>>() {
                    @Override
                    public void success(BaseResponse<ArticleEntity> response) {
                        ArticleEntity articleEntity = response.getData();
                        List<ArticleEntity.DatasBean> datas = articleEntity.getDatas();
                        if (datas != null &&datas.size() > 0) {
                            mArticleListMutable.postValue(datas);
                        } else {

                        }
                    }

                    @Override
                    public void error(String msg) {

                    }
                }));
    }

    public void collect(int id) {
        RetrofitHelper.getInstance().create(ProjectService.class)
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

    public void uncollect(int id) {
        RetrofitHelper.getInstance().create(ProjectService.class)
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
}

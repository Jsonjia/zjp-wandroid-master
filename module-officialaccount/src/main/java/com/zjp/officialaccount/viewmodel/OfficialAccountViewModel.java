package com.zjp.officialaccount.viewmodel;

import android.annotation.SuppressLint;
import android.app.Application;
import android.widget.RadioGroup;

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
import com.zjp.officialaccount.api.OfficialAccountService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zjp on 2020/08/21 11:09
 */
public class OfficialAccountViewModel extends BaseViewModel {

    public MutableLiveData<List<ProjectTabBean>> mProjectListMutable = new MutableLiveData<>();
    public MutableLiveData<List<Object>> mObjMutable = new MutableLiveData<>();
    public MutableLiveData<ArticleEntity> mArticleMutable = new MutableLiveData<>();

    public OfficialAccountViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<Integer> cId = new MutableLiveData<>();

    public void onCheckedChanged(RadioGroup group, int checkId) {
        cId.setValue(checkId);
    }

    public void loadData() {

    }

    public void refresh() {

    }

    public void loadMore() {
//        page.value = (page.value ?: 0) + 1
//        moreLoading.value = true
    }

    /**
     * 当TabLayout+ViewPager组合可以用这个，前提是不考虑懒加载的情况下
     *
     * @param pageNum
     */
    @SuppressLint("CheckResult")
    public void getAuthorInfo(int pageNum) {
        OfficialAccountService officialAccountService = RetrofitHelper.getInstance().create(OfficialAccountService.class);
        officialAccountService
                .getAuthorTabList()
                .subscribeOn(Schedulers.io())
                .flatMap(new Function<BaseResponse<List<ProjectTabBean>>, ObservableSource<ProjectTabBean>>() {
                    @Override
                    public ObservableSource<ProjectTabBean> apply(BaseResponse<List<ProjectTabBean>> listBaseResponse) throws Exception {
                        return Observable.fromIterable(listBaseResponse.getData());
                    }
                })
                .flatMap(new Function<ProjectTabBean, ObservableSource<List<Object>>>() {
                    @Override
                    public ObservableSource<List<Object>> apply(ProjectTabBean projectTabBean) throws Exception {
                        return officialAccountService.getAuthorArticleList(projectTabBean.getId(), pageNum)
                                .filter(new Predicate<BaseResponse<ArticleEntity>>() {
                                    @Override
                                    public boolean test(BaseResponse<ArticleEntity> articleBaseResponse) throws Exception {
                                        return articleBaseResponse.isSuccess();
                                    }
                                })
                                .observeOn(AndroidSchedulers.mainThread())
                                .map(new Function<BaseResponse<ArticleEntity>, List<Object>>() {
                                    @Override
                                    public List<Object> apply(BaseResponse<ArticleEntity> articleBaseResponse) throws Exception {
                                        List<Object> result = new ArrayList<>();
                                        result.add(projectTabBean);
                                        result.add(articleBaseResponse.getData());
                                        return result;
                                    }
                                });
                    }
                })
                .doOnSubscribe(this)
                .subscribe(new Consumer<List<Object>>() {
                    @Override
                    public void accept(List<Object> objects) throws Exception {
                        mObjMutable.postValue(objects);
                    }
                }, new Consumer<Throwable>() {
                    // 网络请求错误时调用
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    public void getAuthorTabList() {
        RetrofitHelper.getInstance().create(OfficialAccountService.class)
                .getAuthorTabList()
                .compose(new IoMainScheduler<>())
                .doOnSubscribe(this)
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

    public void getAuthorArticleList(int id, int pageNum) {
        RetrofitHelper.getInstance().create(OfficialAccountService.class)
                .getAuthorArticleList(id, pageNum)
                .compose(new IoMainScheduler<>())
                .doOnSubscribe(this)  //  请求与ViewModel周期同步
                .subscribe(new NetHelperObserver<>(new NetCallback<BaseResponse<ArticleEntity>>() {
                    @Override
                    public void success(BaseResponse<ArticleEntity> response) {
                        mArticleMutable.setValue(response.getData());
                    }

                    @Override
                    public void error(String msg) {

                    }
                }));
    }
}

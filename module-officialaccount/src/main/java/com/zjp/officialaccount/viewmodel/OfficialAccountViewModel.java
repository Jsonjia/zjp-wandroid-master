package com.zjp.officialaccount.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.common.bean.ProjectTabBean;
import com.zjp.network.bean.BaseResponse;
import com.zjp.network.https.RetrofitHelper;
import com.zjp.network.observer.NetCallback;
import com.zjp.network.observer.NetHelperObserver;
import com.zjp.network.scheduler.IoMainScheduler;
import com.zjp.officialaccount.api.OfficialAccountService;

import java.util.List;

/**
 * Created by zjp on 2020/08/21 11:09
 */
public class OfficialAccountViewModel extends BaseViewModel {

    public MutableLiveData<List<ProjectTabBean>> mProjectListMutable = new MutableLiveData<>();

    public OfficialAccountViewModel(@NonNull Application application) {
        super(application);
    }

    public void refresh() {

    }

    public void loadMore() {
//        page.value = (page.value ?: 0) + 1
//        moreLoading.value = true
    }

    public void getAuthorTabList() {
        RetrofitHelper.getInstance().create(OfficialAccountService.class)
                .getAuthorTabList()
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
}

package com.zjp.mine.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.common.bean.ArticleEntity;
import com.zjp.mine.api.MineService;
import com.zjp.mine.bean.Integral;
import com.zjp.network.bean.BaseResponse;
import com.zjp.network.https.RetrofitHelper;
import com.zjp.network.observer.NetCallback;
import com.zjp.network.observer.NetHelperObserver;
import com.zjp.network.scheduler.IoMainScheduler;

/**
 * Created by zjp on 2020/07/07 15:55
 */
public class MineViewModel extends BaseViewModel {

    public MutableLiveData<Integral> mIntegralLiveData = new MutableLiveData<>();

    public MineViewModel(@NonNull Application application) {
        super(application);
    }

    public void getIntegral() {
        RetrofitHelper.getInstance().create(MineService.class)
                .getIntegral()
                .compose(new IoMainScheduler<>())
                .doOnSubscribe(this)
                .subscribe(new NetHelperObserver<>(new NetCallback<BaseResponse<Integral>>() {
                    @Override
                    public void success(BaseResponse<Integral> response) {
                        mIntegralLiveData.postValue(response.getData());
                    }

                    @Override
                    public void error(String msg) {

                    }
                }));
    }
}

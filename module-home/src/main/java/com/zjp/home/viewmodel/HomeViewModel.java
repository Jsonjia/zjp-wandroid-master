package com.zjp.home.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.home.api.HomeService;
import com.zjp.home.bean.BannerEntity;
import com.zjp.network.bean.BaseResponse;
import com.zjp.network.https.RetrofitHelper;
import com.zjp.network.observer.NetCallback;
import com.zjp.network.observer.NetHelperObserver;
import com.zjp.network.scheduler.IoMainScheduler;

import java.util.List;

import io.reactivex.disposables.Disposable;

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
                        }else{

                        }
                    }

                    @Override
                    public void error(String msg) {

                    }
                }));
    }

}

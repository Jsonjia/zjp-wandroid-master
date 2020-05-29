package com.zjp.login.viewmodel;

import android.app.Application;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.blankj.utilcode.util.ToastUtils;
import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.common.bean.UserInfo;
import com.zjp.common.textwatcher.SimpleTextWatcher;
import com.zjp.login.api.LoginService;
import com.zjp.network.bean.BaseResponse;
import com.zjp.network.https.RetrofitHelper;
import com.zjp.network.observer.NetCallback;
import com.zjp.network.observer.NetHelperObserver;
import com.zjp.network.scheduler.IoMainScheduler;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zjp on 2020/5/28 14:32
 */
public class LoginViewModel extends BaseViewModel {

    public MutableLiveData<UserInfo> registerLiveData= new MutableLiveData<>();
    public MutableLiveData<UserInfo> loginLiveData= new MutableLiveData<>();

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public void register(String username, String pwd) {

        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("password", pwd);
        map.put("repassword", pwd);
        RetrofitHelper.getInstance().create(LoginService.class)
                .register(map)
                .compose(new IoMainScheduler<>())
                .doOnSubscribe(this)
                .subscribe(new NetHelperObserver<>(new NetCallback<BaseResponse<UserInfo>>() {
                    @Override
                    public void success(BaseResponse<UserInfo> response) {
                        registerLiveData.postValue(response.getData());
                    }

                    @Override
                    public void error(String msg) {
                        ToastUtils.showShort(msg);
                    }
                }));
    }

    public void login(String username, String pwd) {
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("password", pwd);
        RetrofitHelper.getInstance().create(LoginService.class)
                .login(map)
                .compose(new IoMainScheduler<>())
                .doOnSubscribe(this)
                .subscribe(new NetHelperObserver<>(new NetCallback<BaseResponse<UserInfo>>() {
                    @Override
                    public void success(BaseResponse<UserInfo> response) {
                        loginLiveData.postValue(response.getData());
                    }

                    @Override
                    public void error(String msg) {
                        ToastUtils.showShort(msg);
                    }
                }));
    }
}

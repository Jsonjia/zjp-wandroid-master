package com.zjp.network.observer;


import com.zjp.network.bean.BaseResponse;

import io.reactivex.disposables.Disposable;

public interface NetCallback<T extends BaseResponse> {

    void success(T response);

    void error(String msg);
}

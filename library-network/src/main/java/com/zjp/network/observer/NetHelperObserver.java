package com.zjp.network.observer;

import android.net.ParseException;
import android.os.NetworkOnMainThreadException;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleObserver;

import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.JsonParseException;
import com.zjp.network.bean.BaseResponse;

import org.json.JSONException;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.util.Objects;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

public class NetHelperObserver<T extends BaseResponse> implements Observer<T>, LifecycleObserver {

    private NetCallback<T> mCallback;

    public NetHelperObserver(NetCallback<T> callback) {
        mCallback = callback;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull T t) {
        if (mCallback != null) {
            if (t.isSuccess()) {
                mCallback.success(t);
            } else {
                mCallback.error(t.getErrorMsg());
            }
        }
    }

    @Override
    public void onError(@NonNull Throwable t) {
        Log.e("请求错误", Objects.requireNonNull(t.getMessage()));
        String msg = "未知错误";
        if (t instanceof UnknownHostException) {
            msg = "网络不可用";
        } else if (t instanceof SocketTimeoutException) {
            msg = "请求网络超时";
        } else if (t instanceof HttpException) {
            HttpException httpException = (HttpException) t;
            msg = convertStatusCode(httpException);
        } else if (t instanceof JsonParseException || t instanceof ParseException || t instanceof JSONException) {
            msg = "数据解析错误";
        } else if (t instanceof IllegalArgumentException) {
            IllegalArgumentException exception = (IllegalArgumentException) t;
            Log.e("错误", Objects.requireNonNull(exception.getMessage()));
            msg = exception.getMessage();
        } else if (t instanceof UnknownServiceException) {
            UnknownServiceException exception = (UnknownServiceException) t;
            msg = exception.getMessage();
        } else if (t instanceof NetworkOnMainThreadException) {
            NetworkOnMainThreadException exception = (NetworkOnMainThreadException) t;
            msg = "网络请求在主线程";
        }
//        Toast.makeText(AppGlobals.getApplication(), msg, Toast.LENGTH_SHORT).show();
        if (mCallback != null) {
            mCallback.error(msg);
        }
    }

    @Override
    public void onComplete() {

    }


    private String convertStatusCode(HttpException httpException) {
        String msg;
        if (httpException.code() == 500) {
            msg = "服务器发生错误";
        } else if (httpException.code() == 404) {
            msg = "请求地址不存在";
        } else if (httpException.code() == 403) {
            msg = "请求被服务器拒绝";
        } else if (httpException.code() == 307) {
            msg = "请求被重定向到其他页面";
        } else {
            msg = httpException.message();
        }
        return msg;
    }
}

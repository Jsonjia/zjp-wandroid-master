package com.zjp.network.https;


import com.zjp.base.application.BaseApplication;
import com.zjp.network.constant.C;

import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by zjp on 2020/4/29 15:46
 */
public class RetrofitHelper {

    private Retrofit mRetrofit;

    private RetrofitHelper() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor("OKHttp");
        httpLoggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY);
        httpLoggingInterceptor.setColorLevel(Level.INFO);

        File cacheFile = new File(BaseApplication.getInstance().getCacheDir(), "cache");
        //100Mb
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 100);

        OkHttpClient client = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .readTimeout(10000, TimeUnit.MILLISECONDS)
                .connectTimeout(10000, TimeUnit.MILLISECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .cache(cache)
                .build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(C.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private static class RetrofitHolder {
        private static final RetrofitHelper sInstance = new RetrofitHelper();
    }

    public static RetrofitHelper getInstance() {
        return RetrofitHolder.sInstance;
    }

    public <T> T create(Class<T> service) {
        return mRetrofit.create(service);
    }
}

package com.zjp.common.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.just.agentweb.IWebLayout;
import com.zjp.common.R;

/**
 * Created by zjp on 2020/6/2 13:52
 */
public class WebLayout implements IWebLayout {

    private WebView mWebView = null;

    public WebLayout(Activity activity) {
        mWebView = (WebView) LayoutInflater.from(activity).inflate(R.layout.fragment_twk_web, null);
    }

    @NonNull
    @Override
    public ViewGroup getLayout() {
        return mWebView;
    }

    @Nullable
    @Override
    public WebView getWebView() {
        return mWebView;
    }
}

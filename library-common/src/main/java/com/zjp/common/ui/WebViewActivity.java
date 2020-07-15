package com.zjp.common.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.LinearLayout;

import com.just.agentweb.AgentWeb;
import com.just.agentweb.DefaultWebClient;
import com.just.agentweb.WebChromeClient;
import com.just.agentweb.WebViewClient;
import com.zjp.base.activity.BaseActivity;
import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.common.R;
import com.zjp.common.databinding.ActivityWebviewBinding;
import com.zjp.common.view.WebLayout;

/**
 * Created by zjp on 2020/6/2 13:38
 */
public class WebViewActivity extends BaseActivity<ActivityWebviewBinding, BaseViewModel> {

    private String links;

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar
                .statusBarDarkFont(true)
                .init();
    }

    public static void start(Activity activity, String title, String link) {
        Intent intent = new Intent(activity, WebViewActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("link", link);
        activity.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_webview;
    }

    @Override
    protected void initView() {
        super.initView();
        if (getIntent() != null) {
            links = getIntent().getStringExtra("link");
        }

        AgentWeb.with(this)
                .setAgentWebParent(mViewDataBinding.container, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .setWebChromeClient(mWebChromeClient)
                .setWebViewClient(mWebViewClient)
                .setMainFrameErrorView(R.layout.agentweb_error_page, -1)
                .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
                .setWebLayout(new WebLayout(this))
                .setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.ASK)//打开其他应用时，弹窗咨询用户是否前往其他应用
                .interceptUnkownUrl() //拦截找不到相关页面的Scheme
                .createAgentWeb()
                .ready()
                .go(getUrl());
    }

    private WebViewClient mWebViewClient = new WebViewClient() {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            //do you  work
            Log.i("Info", "BaseWebActivity onPageStarted");
        }
    };

    private WebChromeClient mWebChromeClient = new WebChromeClient() {
        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            mViewDataBinding.title.setTitle(title);
        }
    };

    public String getUrl() {
        return links;
    }

}

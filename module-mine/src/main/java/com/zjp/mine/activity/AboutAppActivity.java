package com.zjp.mine.activity;

import android.content.Context;
import android.content.Intent;

import com.zjp.base.BuildConfig;
import com.zjp.base.activity.BaseActivity;
import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.common.ui.WebViewActivity;
import com.zjp.mine.R;
import com.zjp.mine.databinding.ActivityAboutAppBinding;

/**
 * Created by zjp on 2020/7/14 22:03.
 */
public class AboutAppActivity extends BaseActivity<ActivityAboutAppBinding, BaseViewModel> {

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar
                .statusBarDarkFont(true)
                .init();
    }

    public static void start(Context context){
        context.startActivity(new Intent(context,AboutAppActivity.class));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_about_app;
    }

    @Override
    protected void initView() {
        super.initView();
        mViewDataBinding.titleview.setTitle("关于我们");

        mViewDataBinding.tvVersionCode.setText(String.format("V%s(%d)",
                BuildConfig.BUILD_TYPE, BuildConfig.BUILD_TYPE));
    }

    @Override
    protected void initData() {
        super.initData();
        mViewDataBinding.setEventlistener(new EventListener());
    }

    public class EventListener {
//
        public void clickWebUrl(String url) {
            WebViewActivity.start(AboutAppActivity.this, mViewDataBinding.tvWeb.getText().toString(), url);
        }

        public void clickWebContent(String url) {
            WebViewActivity.start(AboutAppActivity.this, mViewDataBinding.tvAbout.getText().toString(), url);
        }

        public void clickWebGithub(String url) {
            WebViewActivity.start(AboutAppActivity.this, mViewDataBinding.tvGithub.getText().toString(), url);
        }
    }
}

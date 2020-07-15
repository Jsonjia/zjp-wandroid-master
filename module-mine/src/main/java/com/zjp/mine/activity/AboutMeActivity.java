package com.zjp.mine.activity;

import com.zjp.base.BuildConfig;
import com.zjp.base.activity.BaseActivity;
import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.common.ui.WebViewActivity;
import com.zjp.mine.R;
import com.zjp.mine.databinding.ActivityAboutmeBinding;

/**
 * Created by zjp on 2020/7/14 22:03.
 */
public class AboutMeActivity extends BaseActivity<ActivityAboutmeBinding, BaseViewModel> {

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar
                .statusBarDarkFont(true)
                .init();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_aboutme;
    }

    @Override
    protected void initView() {
        super.initView();
        mViewDataBinding.titleview.setTitle("关于我们");

        mViewDataBinding.tvVersionCode.setText(String.format("V%s(%d)",
                BuildConfig.VERSION_NAME, BuildConfig.VERSION_CODE));
    }

    @Override
    protected void initData() {
        super.initData();
        mViewDataBinding.setEventlistener(new EventListener());
    }

    public class EventListener {

        public void clickWebUrl(String url) {
            WebViewActivity.start(AboutMeActivity.this, mViewDataBinding.tvWeb.getText().toString(), url);
        }

        public void clickWebContent(String url) {
            WebViewActivity.start(AboutMeActivity.this, mViewDataBinding.tvAbout.getText().toString(), url);
        }

        public void clickWebGithub(String url) {
            WebViewActivity.start(AboutMeActivity.this, mViewDataBinding.tvGithub.getText().toString(), url);
        }
    }
}

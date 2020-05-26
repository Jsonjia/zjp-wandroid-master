package com.zjp.login.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.zjp.base.activity.BaseActivity;
import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.common.router.RouterActivityPath;
import com.zjp.login.R;
import com.zjp.login.databinding.ActivitySplashBinding;

public class SplashActivity extends BaseActivity<ActivitySplashBinding, BaseViewModel> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        super.initView();
//        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
        ARouter.getInstance().build(RouterActivityPath.Main.PAGER_MAIN).navigation();
        finish();
    }
}

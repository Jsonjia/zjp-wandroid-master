package com.zjp.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.zjp.base.activity.BaseActivity;
import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.login.databinding.ActivitySplashBinding;

public class SplashActivity extends BaseActivity<ActivitySplashBinding, BaseViewModel> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }
}

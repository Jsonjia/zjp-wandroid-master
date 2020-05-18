package com.zjp.login.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.zjp.base.activity.BaseActivity;
import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.login.R;
import com.zjp.login.databinding.ActivityLoginBinding;

/**
 * Created by zjp on 2020/5/16 23:24.
 */
public class LoginActivity extends BaseActivity<ActivityLoginBinding, BaseViewModel> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }
}

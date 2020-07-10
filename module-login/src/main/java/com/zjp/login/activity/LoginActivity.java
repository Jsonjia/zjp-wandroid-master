package com.zjp.login.activity;

import android.view.View;
import android.widget.TextView;

import androidx.navigation.fragment.NavHostFragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zjp.base.activity.BaseActivity;
import com.zjp.base.router.RouterActivityPath;
import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.login.R;
import com.zjp.login.databinding.ActivityLoginBinding;
import com.zjp.login.fragment.LoginFragment;

/**
 * Created by zjp on 2020/5/16 23:24.
 */
@Route(path = RouterActivityPath.Login.PAGER_LOGIN)
public class LoginActivity extends BaseActivity<ActivityLoginBinding, BaseViewModel> {

    public TextView tvRight;
    public View backView;

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar
                .statusBarDarkFont(true)
                .init();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        super.initView();
        tvRight = mViewDataBinding.headTitle.getTvRight();
        backView = mViewDataBinding.headTitle.getBackView();
        tvRight.setVisibility(View.VISIBLE);
        tvRight.setText("注册");
    }

    @Override
    public boolean onSupportNavigateUp() {
        LoginFragment loginFragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.container);
        return NavHostFragment.findNavController(loginFragment).navigateUp();
    }
}

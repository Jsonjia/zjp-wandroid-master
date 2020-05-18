package com.zjp.login.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zjp.base.activity.BaseActivity;
import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.login.R;
import com.zjp.login.databinding.ActivityLoginBinding;
import com.zjp.login.fragment.LoginFragment;

/**
 * Created by zjp on 2020/5/16 23:24.
 */
public class LoginActivity extends BaseActivity<ActivityLoginBinding, BaseViewModel> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        super.initView();
        TextView tvRight = mViewDataBinding.headTitle.getTvRight();

        tvRight.setVisibility(View.VISIBLE);
        tvRight.setText("注册");

        tvRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(tvRight).navigate(R.id.action_fragment_register);
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        LoginFragment loginFragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.container);
        return NavHostFragment.findNavController(loginFragment).navigateUp();
    }
}

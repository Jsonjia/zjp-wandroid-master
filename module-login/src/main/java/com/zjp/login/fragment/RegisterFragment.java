package com.zjp.login.fragment;

import android.text.Editable;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;

import androidx.navigation.Navigation;

import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.zjp.base.fragment.BaseFragment;
import com.zjp.common.storage.MmkvHelper;
import com.zjp.common.textwatcher.SimpleTextWatcher;
import com.zjp.login.R;
import com.zjp.login.activity.LoginActivity;
import com.zjp.login.databinding.FragmentRegisterBinding;
import com.zjp.login.viewmodel.LoginViewModel;

/**
 * Created by zjp on 2020/5/18 17:30
 */
public class RegisterFragment extends BaseFragment<FragmentRegisterBinding, LoginViewModel> {

    private LoginActivity activity;

    //密码是否显示明文
    private boolean isPasswordShow = false;

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar
                .statusBarDarkFont(true)
                .init();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_register;
    }

    @Override
    protected void initView() {
        super.initView();
        activity = (LoginActivity) getActivity();
        activity.backView.setBackgroundResource(R.drawable.back_left_black);
        activity.backView.setOnClickListener(v -> Navigation.findNavController(getView()).navigateUp());

        mViewDataBinding.etUsername.addTextChangedListener(new SimpleTextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                super.afterTextChanged(s);
                mViewDataBinding.ivClearName.setVisibility(TextUtils.isEmpty(s.toString()) ? View.GONE : View.VISIBLE);
            }
        });

        mViewDataBinding.etPwd.addTextChangedListener(new SimpleTextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                super.afterTextChanged(s);
                mViewDataBinding.ivClearPwd.setVisibility(TextUtils.isEmpty(s.toString()) ? View.GONE : View.VISIBLE);
                mViewDataBinding.ivPwdPrivate.setVisibility(TextUtils.isEmpty(s.toString()) ? View.GONE : View.VISIBLE);
            }
        });

        mViewDataBinding.ivPwdPrivate.setOnClickListener(v -> {
            if (isPasswordShow) {
                mViewDataBinding.etPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
            } else {
                mViewDataBinding.etPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
            mViewDataBinding.ivPwdPrivate.setImageResource(isPasswordShow ? R.mipmap.pwd_close : R.mipmap.pwd_open);
            mViewDataBinding.etPwd.setSelection(mViewDataBinding.etPwd.getText().length());
            isPasswordShow = !isPasswordShow;
            mViewDataBinding.etPwd.postInvalidate();
        });

        mViewDataBinding.ivClearName.setOnClickListener(v -> mViewDataBinding.etUsername.setText(""));
        mViewDataBinding.ivClearPwd.setOnClickListener(v -> mViewDataBinding.etPwd.setText(""));

        mViewDataBinding.btnRegister.setOnClickListener(v -> {
            String userName = mViewDataBinding.etUsername.getText().toString();
            if (userName.length() == 0) {
                ToastUtils.showShort("请输入用户名");
                return;
            }
            String pwd = mViewDataBinding.etPwd.getText().toString();
            if (pwd.length() == 0) {
                ToastUtils.showShort("请输入密码");
                return;
            }
            mViewDataBinding.btnRegister.setVisibility(View.GONE);
            mViewDataBinding.clLoading.setVisibility(View.VISIBLE);
            KeyboardUtils.hideSoftInput(getActivity());
            mViewModel.register(userName, pwd);
        });
    }

    @Override
    protected void initData() {
        super.initData();

        mViewModel.registerLiveData.observe(this, userInfo -> {
            if (userInfo != null) {
                MmkvHelper.getInstance().saveUserInfo(userInfo);
                getActivity().finish();
            } else {
                mViewDataBinding.btnRegister.setVisibility(View.VISIBLE);
                mViewDataBinding.clLoading.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        activity.tvRight.setVisibility(View.GONE);
    }
}

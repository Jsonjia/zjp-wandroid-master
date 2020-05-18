package com.zjp.login.fragment;

import com.zjp.base.fragment.BaseFragment;
import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.login.R;
import com.zjp.login.databinding.FragmentLoginBinding;

/**
 * Created by zjp on 2020/5/18 17:30
 */
public class LoginFragment extends BaseFragment<FragmentLoginBinding, BaseViewModel> {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_login;
    }
}

package com.zjp.login.fragment;

import com.zjp.base.fragment.BaseFragment;
import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.login.R;
import com.zjp.login.databinding.FragmentRegisterBinding;

/**
 * Created by zjp on 2020/5/18 17:30
 */
public class RegisterFragment extends BaseFragment<FragmentRegisterBinding, BaseViewModel> {
    @Override
    public int getLayoutId() {
        return R.layout.fragment_register;
    }
}

package com.zjp.login.fragment;

import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;

import com.zjp.base.fragment.BaseFragment;
import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.login.R;
import com.zjp.login.activity.LoginActivity;
import com.zjp.login.databinding.FragmentLoginBinding;

/**
 * Created by zjp on 2020/5/18 17:30
 */
public class LoginFragment extends BaseFragment<FragmentLoginBinding, BaseViewModel> {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initView() {
        super.initView();

        LoginActivity activity = (LoginActivity) getActivity();

        activity.tvRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(mViewDataBinding.btnLogin).navigate(R.id.action_fragment_register);
            }
        });
    }
}

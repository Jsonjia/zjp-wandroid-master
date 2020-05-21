package com.zjp.login.fragment;

import android.view.View;
import android.widget.TextView;

import androidx.navigation.Navigation;

import com.zjp.base.fragment.BaseFragment;
import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.login.R;
import com.zjp.login.activity.LoginActivity;
import com.zjp.login.databinding.FragmentRegisterBinding;

/**
 * Created by zjp on 2020/5/18 17:30
 */
public class RegisterFragment extends BaseFragment<FragmentRegisterBinding, BaseViewModel> {

    private LoginActivity activity;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_register;
    }

    @Override
    protected void initView() {
        super.initView();
        activity = (LoginActivity) getActivity();
        activity.backView.setBackgroundResource(R.drawable.back_left);
        activity.backView.setOnClickListener(v -> Navigation.findNavController(getView()).navigateUp());
    }

    @Override
    public void onResume() {
        super.onResume();
        activity.tvRight.setVisibility(View.GONE);
    }
}

package com.zjp.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.zjp.base.fragment.BaseFragment;
import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.home.databinding.HomeFragmentHomeBinding;

public class HomeFragment extends BaseFragment<HomeFragmentHomeBinding, BaseViewModel> {

    @Override
    public int getLayoutId() {
        return R.layout.home_fragment_home;
    }


}

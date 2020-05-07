package com.zjp.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zjp.base.fragment.BaseFragment;
import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.common.router.RouterFragmentPath;
import com.zjp.home.databinding.HomeFragmentHomeBinding;

@Route(path = RouterFragmentPath.Home.PAGER_HOME)
public class HomeFragment extends BaseFragment<HomeFragmentHomeBinding, BaseViewModel> {

    @Override
    public int getLayoutId() {
        return R.layout.home_fragment_home;
    }


}

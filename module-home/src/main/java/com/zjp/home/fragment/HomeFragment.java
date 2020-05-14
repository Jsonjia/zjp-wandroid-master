package com.zjp.home.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.youth.banner.config.BannerConfig;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.util.BannerUtils;
import com.zjp.base.fragment.BaseFragment;
import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.common.router.RouterFragmentPath;
import com.zjp.home.R;
import com.zjp.home.adapter.HomeHeadBannerAdapter;
import com.zjp.home.bean.BannerEntity;
import com.zjp.home.databinding.HomeFragmentHomeBinding;
import com.zjp.home.databinding.ProjectFragmentBinding;
import com.zjp.home.viewmodel.HomeViewModel;

import java.util.List;

@Route(path = RouterFragmentPath.Home.PAGER_HOME)
public class HomeFragment extends BaseFragment<HomeFragmentHomeBinding, HomeViewModel> {

    @Override
    public int getLayoutId() {
        return R.layout.home_fragment_home;
    }

    @Override
    protected void initView() {
        super.initView();

        mViewModel.getBanner();

        mViewModel.mBannerList.observe(this, bannerEntities -> {
            if (bannerEntities != null && bannerEntities.size() > 0) {
                mViewDataBinding.banner.setAdapter(new HomeHeadBannerAdapter(bannerEntities));
                mViewDataBinding.banner.setIndicator(new CircleIndicator(getActivity()));
                mViewDataBinding.banner.setIndicatorGravity(IndicatorConfig.Direction.RIGHT);
                mViewDataBinding.banner.setIndicatorMargins(new IndicatorConfig.Margins(0, 0,
                        BannerConfig.INDICATOR_MARGIN, (int) BannerUtils.dp2px(12)));
            }
        });


        mViewModel.getArticleList(1);

    }
}

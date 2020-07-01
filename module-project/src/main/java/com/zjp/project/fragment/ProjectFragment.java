package com.zjp.project.fragment;


import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.immersionbar.ImmersionBar;
import com.zjp.base.fragment.BaseFragment;
import com.zjp.base.router.RouterFragmentPath;
import com.zjp.common.adapter.TabPagerAdapter;
import com.zjp.common.callback.OnTabClickListener;
import com.zjp.common.callback.TabPagerListener;
import com.zjp.project.R;
import com.zjp.project.adapter.TabNavigatorAdapter;
import com.zjp.project.bean.ProjectTabBean;
import com.zjp.project.databinding.FragmentProjectFragmentBinding;
import com.zjp.project.viewmodel.ProjectViewModel;

import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.ArrayList;
import java.util.List;

@Route(path = RouterFragmentPath.Project.PAGER_PROJECT)
public class ProjectFragment extends BaseFragment<FragmentProjectFragmentBinding, ProjectViewModel>
        implements TabPagerListener, OnTabClickListener {

    private List<ProjectTabBean> tabBeanList = new ArrayList<>();
    private TabPagerAdapter tabPagerAdapter;

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar
                .statusBarDarkFont(true)
                .init();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_project_fragment;
    }

    @Override
    protected void initView() {
        super.initView();
        ViewGroup.LayoutParams layoutParams = mViewDataBinding.viewStatus.getLayoutParams();
        layoutParams.height = ImmersionBar.getStatusBarHeight(getActivity());
        mViewDataBinding.viewStatus.setLayoutParams(layoutParams);

        mViewModel.getProjectTab();
    }

    @Override
    protected void initData() {
        super.initData();

        mViewModel.mProjectListMutable.observe(this, projectTabBeans -> {
            if (projectTabBeans != null && projectTabBeans.size() > 0) {
                tabBeanList.clear();
                tabBeanList.addAll(projectTabBeans);
                initFragment();
            }
        });
    }

    private void initFragment() {
        tabPagerAdapter = new TabPagerAdapter(getChildFragmentManager(), tabBeanList.size());
        tabPagerAdapter.setListener(this::getFragment);
        mViewDataBinding.vp.setAdapter(tabPagerAdapter);
        mViewDataBinding.vp.setOffscreenPageLimit(tabBeanList.size() - 1);

        CommonNavigator commonNavigator = new CommonNavigator(getActivity());
        TabNavigatorAdapter tabNavigatorAdapter = new TabNavigatorAdapter(tabBeanList);
        tabNavigatorAdapter.setOnTabClickListener(this::onTabClick);
        commonNavigator.setAdapter(tabNavigatorAdapter);
        mViewDataBinding.magicInticator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(mViewDataBinding.magicInticator, mViewDataBinding.vp);
    }

    @Override
    public Fragment getFragment(int position) {
        ProjectListFragment projectListFragment = new ProjectListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("id", tabBeanList.get(position).getId());
        bundle.putString("name", tabBeanList.get(position).getName());
        projectListFragment.setArguments(bundle);
        return projectListFragment;
    }

    @Override
    public void onTabClick(View view, int index) {
        mViewDataBinding.vp.setCurrentItem(index);
    }
}

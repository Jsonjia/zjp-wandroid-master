package com.zjp.square.fragment;

import com.zjp.base.fragment.BaseLazyFragment;
import com.zjp.common.bean.ProjectTabBean;
import com.zjp.square.R;
import com.zjp.square.activity.SystemActivity;
import com.zjp.square.adapter.SystemListAdapter;
import com.zjp.square.databinding.FragmentListSystemBinding;
import com.zjp.square.viewmodel.SquareViewModel;

/**
 * Created by zjp on 2020/08/20 14:15
 */
public class SystemFragment extends BaseLazyFragment<FragmentListSystemBinding, SquareViewModel>
        implements SystemListAdapter.OnItemClickListener {

    private SystemListAdapter systemListAdapter;
    private boolean isLoading;

    public static SystemFragment newInstance() {
        return new SystemFragment();
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar
                .statusBarDarkFont(true)
                .init();
    }

    @Override
    protected void initView() {
        super.initView();
        mViewDataBinding.recy.setAdapter(systemListAdapter = new SystemListAdapter());
        systemListAdapter.setOnItemClickListener(this::onClick);
    }

    @Override
    protected void initData() {
        super.initData();
        mViewModel.mSystemListMutable.observe(this, projectTabBeans -> {
            if (isLoading)
                showContent();
            if (projectTabBeans != null && projectTabBeans.size() > 0) {
                systemListAdapter.setList(projectTabBeans);
            }
            isLoading = !isLoading;
        });
    }

    @Override
    protected void lazyLoadData() {
        isLoading = true;
        showLoading();
        onRetryBtnClick();
    }

    @Override
    protected void onRetryBtnClick() {
        super.onRetryBtnClick();
        mViewModel.getSystemList();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_list_system;
    }

    @Override
    public void onClick(ProjectTabBean projTabBean) {
        SystemActivity.start(getActivity(), projTabBean.getName(),projTabBean.getCourseId());
    }
}

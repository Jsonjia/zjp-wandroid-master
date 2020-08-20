package com.zjp.square.fragment;

import com.zjp.base.fragment.BaseLazyFragment;
import com.zjp.common.adapter.ArticleListAdapter;
import com.zjp.square.R;
import com.zjp.square.databinding.FragmentListSystemBinding;
import com.zjp.square.viewmodel.SquareViewModel;

/**
 * Created by zjp on 2020/08/20 14:47
 */
public class NavigationFragment extends BaseLazyFragment<FragmentListSystemBinding, SquareViewModel> {

    private ArticleListAdapter articleListAdapter;
    private boolean isLoading;

    public static NavigationFragment newInstance() {
        return new NavigationFragment();
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
        mViewDataBinding.recy.setAdapter(articleListAdapter = new ArticleListAdapter(null));
    }

    @Override
    protected void initData() {
        super.initData();
        mViewModel.mArticleListMuTable.observe(this, articleEntities -> {
            if (isLoading)
                showContent();
            if (articleEntities != null && articleEntities.size() > 0) {
                articleListAdapter.setList(articleEntities);
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
        mViewModel.getNavigation();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_list_system;
    }
}

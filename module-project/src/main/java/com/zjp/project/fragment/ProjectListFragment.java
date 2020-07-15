package com.zjp.project.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.zjp.base.fragment.BaseLazyFragment;
import com.zjp.common.adapter.ArticleListAdapter;
import com.zjp.common.bean.ArticleEntity;
import com.zjp.common.bean.page.PageInfo;
import com.zjp.common.ui.WebViewActivity;
import com.zjp.common.utils.CustomItemDecoration;
import com.zjp.project.R;
import com.zjp.project.databinding.FragmentProjectListBinding;
import com.zjp.project.viewmodel.ProjectViewModel;


/**
 * Created by zjp on 2020/7/1 10:17
 */
public class ProjectListFragment extends BaseLazyFragment<FragmentProjectListBinding, ProjectViewModel>
        implements OnRefreshLoadMoreListener {

    private int id;
    private String name;
    private PageInfo pageInfo;
    private ArticleListAdapter articleListAdapter;
    private boolean isLoading;

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar
                .statusBarDarkFont(true)
                .init();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_project_list;
    }

    @Override
    protected void initView() {
        super.initView();
        Bundle bundle = getArguments();
        if (null != bundle) {
            id = bundle.getInt("id", 0);
            name = bundle.getString("name");
        }
        mViewDataBinding.recy.setLayoutManager(new LinearLayoutManager(getActivity()));
        mViewDataBinding.recy.addItemDecoration(new CustomItemDecoration(getActivity(),
                CustomItemDecoration.ItemDecorationDirection.VERTICAL_LIST, R.drawable.linear_split_line));
        articleListAdapter = new ArticleListAdapter(null);
        mViewDataBinding.recy.setAdapter(articleListAdapter);
    }

    @Override
    protected void initData() {
        super.initData();

        mViewModel.mArticleListMutable.observe(this, datasBeans -> {
            if (mViewDataBinding.refresh.getState().isOpening) {
                mViewDataBinding.refresh.finishRefresh();
                mViewDataBinding.refresh.finishLoadMore();
            }
            if (isLoading)
                showContent();
            if (datasBeans != null && datasBeans.size() > 0) {
                if (pageInfo.isFirstPage()) {
                    articleListAdapter.setList(datasBeans);
                } else {
                    articleListAdapter.addData(datasBeans);
                }
//                pageInfo.nextPage();
            } else {
                if (pageInfo.isFirstPage()) {
                    showEmpty();
                } else {
                    mViewDataBinding.refresh.finishLoadMoreWithNoMoreData();
                }
            }
            isLoading = false;
        });
    }

    @Override
    protected void lazyLoadData() {
        pageInfo = new PageInfo();
        isLoading = true;
        showLoading();
        mViewDataBinding.refresh.setOnRefreshLoadMoreListener(this);
        articleListAdapter.setOnItemClickListener((adapter, view, position) -> {
            ArticleEntity.DatasBean datasBean = articleListAdapter.getData().get(position);
            WebViewActivity.start(getActivity(), datasBean.getTitle(), datasBean.getLink());
        });
        onRetryBtnClick();
    }

    @Override
    protected void onRetryBtnClick() {
        super.onRetryBtnClick();
        mViewModel.getProjectList(pageInfo.page, id);
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        pageInfo.nextPage();
        onRetryBtnClick();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        pageInfo.reset();
        onRetryBtnClick();
    }
}

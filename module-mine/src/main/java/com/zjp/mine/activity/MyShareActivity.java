package com.zjp.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.zjp.base.activity.BaseActivity;
import com.zjp.common.adapter.ArticleListAdapter;
import com.zjp.common.bean.ArticleEntity;
import com.zjp.common.bean.page.PageInfo;
import com.zjp.common.utils.CustomItemDecoration;
import com.zjp.mine.R;
import com.zjp.mine.databinding.ActivityMyshareBinding;
import com.zjp.mine.viewmodel.MineViewModel;

import java.util.List;

/**
 * Created by zjp on 2020/8/1 16:16.
 */
public class MyShareActivity extends BaseActivity<ActivityMyshareBinding, MineViewModel>
        implements OnRefreshLoadMoreListener {

    private ArticleListAdapter articleListAdapter;
    private PageInfo pageInfo;

    public static void start(Context context) {
        context.startActivity(new Intent(context, MyShareActivity.class));
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar
                .statusBarDarkFont(true)
                .init();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_myshare;
    }

    @Override
    protected void initView() {
        super.initView();

        mViewDataBinding.titleview.setTitle("我的分享");
        mViewDataBinding.titleview.getIvRight().setImageResource(R.mipmap.add);
        mViewDataBinding.titleview.setIvRightVisible(View.VISIBLE);
        mViewDataBinding.baseRefresh.recy.addItemDecoration(new CustomItemDecoration(this,
                CustomItemDecoration.ItemDecorationDirection.VERTICAL_LIST, R.drawable.linear_split_line));
        mViewDataBinding.baseRefresh.recy.setAdapter(articleListAdapter = new ArticleListAdapter(null));
        mViewDataBinding.baseRefresh.refresh.setOnRefreshLoadMoreListener(this);

        getData();

        mViewDataBinding.titleview.getIvRight().setOnClickListener(view -> AddArticleActivity.start(MyShareActivity.this));
    }

    @Override
    protected void initData() {
        super.initData();

        mViewModel.userCenterLiveData.observe(this, userCenter -> {
            if (mViewDataBinding.baseRefresh.refresh.getState().isOpening) {
                mViewDataBinding.baseRefresh.refresh.finishRefresh();
                mViewDataBinding.baseRefresh.refresh.finishLoadMore();
            }
            pageInfo.nextPage();

            ArticleEntity shareArticles = userCenter.getShareArticles();
            List<ArticleEntity.DatasBean> dataList = shareArticles.getDatas();

            if (dataList != null && dataList.size() > 0) {
                for (ArticleEntity.DatasBean articleBean : dataList) {
                    articleBean.setCollect(true);
                }
            }

            if (shareArticles.getCurPage() == 1) {
                if (dataList != null && dataList.size() > 0) {
                    showContent();
                    articleListAdapter.setList(dataList);
                } else {
                    showEmpty();
                }
            } else {
                articleListAdapter.addData(dataList);
            }
            if (shareArticles.isOver()) {
                mViewDataBinding.baseRefresh.refresh.finishLoadMoreWithNoMoreData();
            }
        });
//        mViewModel.userCenterLiveData.observe(this, articleEntity -> {
//            if (mViewDataBinding.baseRefresh.refresh.getState().isOpening) {
//                mViewDataBinding.baseRefresh.refresh.finishRefresh();
//                mViewDataBinding.baseRefresh.refresh.finishLoadMore();
//            }
//
//            List<ArticleEntity.DatasBean> dataList = articleEntity.getDatas();
//
//            if (dataList != null && dataList.size() > 0) {
//                for (ArticleEntity.DatasBean articleBean : dataList) {
//                    articleBean.setCollect(true);
//                }
//            }
//
//            pageInfo.nextPage();
//
//
//        });
    }

    private void loadData() {
        mViewModel.myShare(pageInfo.page);
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        loadData();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        pageInfo.reset();
        loadData();
    }

    @Override
    protected void onRetryBtnClick() {
        super.onRetryBtnClick();
        getData();
    }

    private void getData() {
        pageInfo = new PageInfo();
        setLoadSir(mViewDataBinding.baseRefresh.refresh);
        loadData();
    }
}

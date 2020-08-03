package com.zjp.mine.activity;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

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
        mViewDataBinding.baseRefresh.recy.setLayoutManager(new LinearLayoutManager(this));
        mViewDataBinding.baseRefresh.recy.addItemDecoration(new CustomItemDecoration(this,
                CustomItemDecoration.ItemDecorationDirection.VERTICAL_LIST, R.drawable.linear_split_line));
        mViewDataBinding.baseRefresh.recy.setAdapter(articleListAdapter = new ArticleListAdapter(null));
        mViewDataBinding.baseRefresh.refresh.setOnRefreshLoadMoreListener(this);

        pageInfo = new PageInfo();
        setLoadSir(mViewDataBinding.baseRefresh.refresh);
        loadData();
    }

    @Override
    protected void initData() {
        super.initData();
        mViewModel.articleLiveData.observe(this, articleEntity -> {
            if (mViewDataBinding.baseRefresh.refresh.getState().isOpening) {
                mViewDataBinding.baseRefresh.refresh.finishRefresh();
                mViewDataBinding.baseRefresh.refresh.finishLoadMore();
            }

            List<ArticleEntity.DatasBean> dataList = articleEntity.getDatas();

            if (dataList != null && dataList.size() > 0) {
                for (ArticleEntity.DatasBean articleBean : dataList) {
                    articleBean.setCollect(true);
                }
            }

            pageInfo.nextZeroPage();
            if (articleEntity.getCurPage() == 1) {
                if (dataList != null && dataList.size() > 0) {
                    showContent();
                    articleListAdapter.setList(dataList);
                } else {
                    showEmpty();
                }
            } else {
//                if ((dataList == null || dataList.size() == 0) && articleEntity.isOver()) {
//                    showEmpty();
//                } else {
//                    articleListAdapter.addData(dataList);
//                }
            }
            if (articleEntity.isOver()) {
                mViewDataBinding.baseRefresh.refresh.finishLoadMoreWithNoMoreData();
            }
        });
    }

    private void loadData() {
        mViewModel.myShare(pageInfo.mPage);
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
}

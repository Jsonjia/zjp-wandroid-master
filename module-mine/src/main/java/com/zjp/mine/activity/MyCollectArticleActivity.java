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
import com.zjp.mine.databinding.ActivityMycollectArticleBinding;
import com.zjp.mine.viewmodel.MineViewModel;

import java.util.List;

/**
 * Created by zjp on 2020/07/16 16:18
 */
public class MyCollectArticleActivity extends BaseActivity<ActivityMycollectArticleBinding, MineViewModel>
        implements OnRefreshLoadMoreListener {

    private PageInfo pageInfo;
    private ArticleListAdapter articleListAdapter;

    //记录当前点击收藏的position
    private int currentPosition = 0;

    public static void start(Context context) {
        context.startActivity(new Intent(context, MyCollectArticleActivity.class));
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
        return R.layout.activity_mycollect_article;
    }

    @Override
    protected void initView() {
        super.initView();
        mViewDataBinding.titleview.setTitle("我的收藏");
        pageInfo = new PageInfo();
        setLoadSir(mViewDataBinding.includeRefresh.refresh);
        loadData();

        mViewDataBinding.includeRefresh.recy.setLayoutManager(new LinearLayoutManager(this));
        mViewDataBinding.includeRefresh.recy.addItemDecoration(new CustomItemDecoration(this,
                CustomItemDecoration.ItemDecorationDirection.VERTICAL_LIST, R.drawable.linear_split_line));
        mViewDataBinding.includeRefresh.recy.setAdapter(articleListAdapter = new ArticleListAdapter(null));
        mViewDataBinding.includeRefresh.refresh.setOnRefreshLoadMoreListener(this);
    }

    private void loadData() {
        mViewModel.getCollectArticleList(pageInfo.mPage);
    }

    @Override
    protected void initData() {
        super.initData();

        mViewModel.articleLiveData.observe(this, articleEntity -> {
            if (mViewDataBinding.includeRefresh.refresh.getState().isOpening) {
                mViewDataBinding.includeRefresh.refresh.finishRefresh();
                mViewDataBinding.includeRefresh.refresh.finishLoadMore();
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
                articleListAdapter.addData(dataList);
            }
            if (articleEntity.isOver()) {
                mViewDataBinding.includeRefresh.refresh.finishLoadMoreWithNoMoreData();
            }
        });

        mViewModel.mUnCollectMutable.observe(this, baseResponse -> {
            if (baseResponse.getErrorCode() == 0) {
                if (currentPosition < articleListAdapter.getData().size()) {
                    articleListAdapter.cancelCollect(currentPosition);
                }
            }
        });

        articleListAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            if (view.getId() == R.id.iv_collect) {
                collectArticle(position);
            }
        });
    }

    private void collectArticle(int position) {
        if (position < articleListAdapter.getData().size()) {
            currentPosition = position;
            mViewModel.unCollect(articleListAdapter.getData().get(position).getId());
        }
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

package com.zjp.mine.activity;

import android.content.Context;
import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.zjp.base.activity.BaseActivity;
import com.zjp.common.adapter.ArticleListAdapter;
import com.zjp.common.bean.ArticleEntity;
import com.zjp.common.bean.page.PageInfo;
import com.zjp.mine.R;
import com.zjp.mine.adapter.MyCollectArticleAdapter;
import com.zjp.mine.databinding.ActivityMycollectArticleBinding;
import com.zjp.mine.viewmodel.MineViewModel;

import java.util.List;

/**
 * Created by zjp on 2020/07/16 16:18
 */
public class MyCollectArticleActivity extends BaseActivity<ActivityMycollectArticleBinding, MineViewModel> {

    private PageInfo pageInfo;
    private MyCollectArticleAdapter myCollectArticleAdapter;
    private ArticleListAdapter articleListAdapter;

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
        mViewDataBinding.includeRefresh.recy.setAdapter(articleListAdapter = new ArticleListAdapter(null));
//        mViewDataBinding.includeRefresh.refresh.setOnRefreshLoadMoreListener(this);
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

            List<ArticleEntity.DatasBean> datas = articleEntity.getDatas();
            if (datas != null && datas.size() > 0) {
                if (pageInfo.isZeroPage()) {
                    showContent();
                    articleListAdapter.setList(datas);
                } else {
                    articleListAdapter.addData(datas);
                }

            } else {
                if (pageInfo.isZeroPage()) {
                    showEmpty();
                } else {
//                        articleListAdapter.
                }
            }
        });

    }
}

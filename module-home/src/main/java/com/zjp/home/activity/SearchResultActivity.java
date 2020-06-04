package com.zjp.home.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.gyf.immersionbar.ImmersionBar;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.zjp.base.activity.BaseActivity;
import com.zjp.common.bean.page.PageInfo;
import com.zjp.common.utils.CustomItemDecoration;
import com.zjp.home.R;
import com.zjp.home.adapter.HomeArticleListAdapter;
import com.zjp.home.adapter.HotSearchAdapter;
import com.zjp.home.bean.ArticleEntity;
import com.zjp.home.databinding.ActivitySearchresultBinding;
import com.zjp.home.viewmodel.SearchViewModel;
import com.zjp.network.constant.C;

import java.util.List;

/**
 * Created by zjp on 2020/6/4 10:34
 */
public class SearchResultActivity extends BaseActivity<ActivitySearchresultBinding, SearchViewModel> {

    private String keyword;
    private PageInfo pageInfo;

    private HomeArticleListAdapter articleListAdapter;
    private boolean isLoading = true;

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar
                .statusBarDarkFont(true)
                .init();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_searchresult;
    }

    @Override
    protected void initView() {
        super.initView();

        ViewGroup.LayoutParams layoutParams = mViewDataBinding.viewStatus.getLayoutParams();
        layoutParams.height = ImmersionBar.getStatusBarHeight(this);
        mViewDataBinding.viewStatus.setLayoutParams(layoutParams);

        pageInfo = new PageInfo();
        Intent intent = getIntent();
        if (intent != null) {
            keyword = intent.getStringExtra("keyword");
            if (!TextUtils.isEmpty(keyword)) {
                mViewDataBinding.searchEt.setText(keyword);
                mViewDataBinding.searchEt.setFocusable(false);
                mViewDataBinding.searchEt.setSelection(mViewDataBinding.searchEt.length());
            }
        }

        mViewDataBinding.recy.setLayoutManager(new LinearLayoutManager(this));
        mViewDataBinding.recy.addItemDecoration(new CustomItemDecoration(this,
                CustomItemDecoration.ItemDecorationDirection.VERTICAL_LIST, R.drawable.linear_split_line));
        articleListAdapter = new HomeArticleListAdapter(null);
        mViewDataBinding.recy.setAdapter(articleListAdapter);

        loadData(keyword);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void initData() {
        super.initData();
        mViewModel.mArticleSearch.observe(this, articleEntity -> {

            if (mViewDataBinding.refresh.getState().isOpening) {
                mViewDataBinding.refresh.finishRefresh();
                mViewDataBinding.refresh.finishLoadMore();
            }
            List<ArticleEntity.DatasBean> datas = articleEntity.getDatas();

            if (pageInfo.isZeroPage()) {
                articleListAdapter.setList(datas);
            } else {
                articleListAdapter.addData(datas);
            }
            pageInfo.nextZeroPage();
        });

        articleListAdapter.setOnItemClickListener((adapter, view, position) -> {
            ArticleEntity.DatasBean datasBean = articleListAdapter.getData().get(position);
            Intent intent = new Intent(this, WebViewActivity.class);
            intent.putExtra("link", datasBean.getLink());
            startActivity(intent);
        });

        mViewDataBinding.refresh.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                loadData(keyword);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                pageInfo.resetZero();
                loadData(keyword);
            }
        });

        mViewDataBinding.searchEt.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                Intent intent = new Intent();
                intent.putExtra(C.KEYWORD, mViewDataBinding.searchEt.getText().toString());
                setResult(RESULT_OK, intent);
                finishAfterTransition();
            }
        });

        mViewDataBinding.searchEt.setOnTouchListener((view, motionEvent) -> {
            if (mViewDataBinding.searchEt == null) return false;
            mViewDataBinding.searchEt.setFocusable(true);
            mViewDataBinding.searchEt.setFocusableInTouchMode(true);
            mViewDataBinding.searchEt.requestFocus();
            return false;
        });
    }

    private void loadData(String keyword) {
        mViewModel.search(pageInfo.mPage, keyword);
    }

}
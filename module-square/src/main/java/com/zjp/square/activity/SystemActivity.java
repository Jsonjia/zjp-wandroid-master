package com.zjp.square.activity;

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
import com.zjp.network.constant.C;
import com.zjp.square.R;
import com.zjp.square.databinding.ActivityStstemBinding;
import com.zjp.square.viewmodel.SquareViewModel;

import java.util.List;

/**
 * Created by zjp on 2020/08/20 16:18
 */
public class SystemActivity extends BaseActivity<ActivityStstemBinding, SquareViewModel>
        implements OnRefreshLoadMoreListener {

    private PageInfo pageInfo;
    private ArticleListAdapter articleListAdapter;
    private int cid;
    //记录当前点击收藏的position
    private int currentPosition = 0;

    public static void start(Context context, String title, int cid) {
        Intent intent = new Intent(context, SystemActivity.class);
        intent.putExtra(C.TITLE, title);
        intent.putExtra(C.CID, cid);
        context.startActivity(intent);
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
        return R.layout.activity_ststem;
    }

    @Override
    protected void initView() {
        super.initView();
        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra(C.TITLE);
            cid = intent.getIntExtra(C.CID, 0);
            mViewDataBinding.title.setTitle(title);
        }

        pageInfo = new PageInfo();
        setLoadSir(mViewDataBinding.includeRefresh.refresh);
        loadData();

        mViewDataBinding.includeRefresh.recy.setLayoutManager(new LinearLayoutManager(this));
        mViewDataBinding.includeRefresh.recy.addItemDecoration(new CustomItemDecoration(this,
                CustomItemDecoration.ItemDecorationDirection.VERTICAL_LIST, R.drawable.linear_split_line));
        mViewDataBinding.includeRefresh.recy.setAdapter(articleListAdapter = new ArticleListAdapter(null));
        mViewDataBinding.includeRefresh.refresh.setOnRefreshLoadMoreListener(this);
    }

    @Override
    protected void initData() {
        super.initData();

        mViewModel.mArticleMuTable.observe(this, articleEntity -> {
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
            if (articleEntity.getCurPage() == 0) {
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

    private void loadData() {
        mViewModel.getProjectList(pageInfo.mPage, cid);
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

package com.zjp.mine.activity;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.gyf.immersionbar.ImmersionBar;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.zjp.base.activity.BaseActivity;
import com.zjp.common.adapter.ArticleListAdapter;
import com.zjp.common.bean.ArticleEntity;
import com.zjp.common.bean.page.PageInfo;
import com.zjp.common.utils.CustomItemDecoration;
import com.zjp.mine.R;
import com.zjp.mine.bean.Integral;
import com.zjp.mine.databinding.ActivityUsercenter1Binding;
import com.zjp.mine.viewmodel.MineViewModel;
import com.zjp.network.constant.C;

import java.util.List;

/**
 * Created by zjp on 2020/7/17 21:54.
 */
public class UserCenterActivity extends BaseActivity<ActivityUsercenter1Binding, MineViewModel> implements OnLoadMoreListener {

    private int userId;
    private PageInfo pageInfo;
    private ArticleListAdapter articleListAdapter;
    private int currentPosition = 0;
    /**
     * 点击收藏后将点击事件上锁,等接口有相应结果再解锁
     * 避免重复点击产生的bug
     */
    private boolean lockCollectClick = true;

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar
                .statusBarColorInt(getResources().getColor(R.color.colorPrimary))
                .statusBarDarkFont(false)
                .init();
    }

    public static void start(Context context, int userId) {
        Intent intent = new Intent(context, UserCenterActivity.class);
        intent.putExtra(C.USERID, userId);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_usercenter1;
    }

    @Override
    protected void initView() {
        super.initView();
        Intent intent = getIntent();
        if (null != intent) {
            userId = intent.getIntExtra(C.USERID, 0);
        }
        pageInfo = new PageInfo();
        mViewDataBinding.recy.setLayoutManager(new LinearLayoutManager(this));
        mViewDataBinding.recy.addItemDecoration(new CustomItemDecoration(this,
                CustomItemDecoration.ItemDecorationDirection.VERTICAL_LIST, R.drawable.linear_split_line));
        mViewDataBinding.recy.setAdapter(articleListAdapter = new ArticleListAdapter(null));
        mViewDataBinding.co.setPadding(0, ImmersionBar.getStatusBarHeight(this), 0, 0);
        setLoadSir(mViewDataBinding.co);
        loadData();
    }

    @Override
    protected void initData() {
        super.initData();
        mViewModel.userCenterLiveData.observe(this, userCenter -> {
            if (userCenter != null) {
                ArticleEntity shareArticles = userCenter.getShareArticles();
                List<ArticleEntity.DatasBean> datas = shareArticles.getDatas();
                pageInfo.nextPage();
                if (shareArticles.getCurPage() == 1) {
                    Integral coinInfo = userCenter.getCoinInfo();
                    mViewDataBinding.setUserInfo(coinInfo);
                    if (datas != null && datas.size() > 0) {
                        showContent();
                        articleListAdapter.setList(datas);
                    } else {
                        showEmpty();
                    }
                } else {
                    articleListAdapter.addData(datas);
                }

                if (shareArticles.isOver()) {
                    mViewDataBinding.smart.finishLoadMoreWithNoMoreData();
                }
                mViewDataBinding.smart.finishRefresh(true);
                mViewDataBinding.smart.finishLoadMore(true);
            }
        });

        mViewModel.mUnCollectMutable.observe(this, baseResponse -> {
            lockCollectClick = true;
            if (baseResponse.getErrorCode() == 0) {
                if (currentPosition < articleListAdapter.getData().size()) {
                    articleListAdapter.getData().get(currentPosition).setCollect(false);
                    articleListAdapter.notifyItemChanged(currentPosition, C.REFRESH_COLLECT);
                }
            }
        });

        mViewModel.mCollectMutable.observe(this, baseResponse -> {
            lockCollectClick = true;
            if (baseResponse.getErrorCode() == 0) {
                if (currentPosition < articleListAdapter.getData().size()) {
                    articleListAdapter.getData().get(currentPosition).setCollect(true);
                    articleListAdapter.notifyItemChanged(currentPosition, C.REFRESH_COLLECT);
                }
            }
        });

        mViewDataBinding.ivBackLeft.setOnClickListener(view -> finish());
        mViewDataBinding.smart.setOnLoadMoreListener(this);
        articleListAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            if (view.getId() == R.id.iv_collect) {
                collectArticle(position);
            }
        });
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        loadData();
    }

    private void loadData() {
        mViewModel.getUserCenter(userId, pageInfo.page);
    }

    private void collectArticle(int position) {
        if (position < articleListAdapter.getData().size() && lockCollectClick) {
            lockCollectClick = false;
            currentPosition = position;
            if (articleListAdapter.getData().get(position).isCollect()) {
                mViewModel.unCollect(articleListAdapter.getData().get(position).getId());
            } else {
                mViewModel.collect(articleListAdapter.getData().get(position).getId());
            }
        }
    }
}

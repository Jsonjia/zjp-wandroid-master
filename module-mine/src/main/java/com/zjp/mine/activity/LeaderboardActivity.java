package com.zjp.mine.activity;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.zjp.base.activity.BaseActivity;
import com.zjp.common.bean.page.PageInfo;
import com.zjp.mine.R;
import com.zjp.mine.adapter.LeaderboardAdapter;
import com.zjp.mine.databinding.ActivityLeaderBoardBinding;
import com.zjp.mine.viewmodel.MineViewModel;

/**
 * Created by zjp on 2020/7/15 22:15.
 */
public class LeaderboardActivity extends BaseActivity<ActivityLeaderBoardBinding, MineViewModel> implements OnRefreshLoadMoreListener {

    private PageInfo pageInfo;
    private LeaderboardAdapter leaderboardAdapter;

    public static void start(Context context) {
        context.startActivity(new Intent(context, LeaderboardActivity.class));
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
        return R.layout.activity_leader_board;
    }

    @Override
    protected void initView() {
        super.initView();
        mViewDataBinding.titleview.setTitle("积分排行榜");
        pageInfo = new PageInfo();

        loadData();

        mViewDataBinding.includeRefresh.recy.setLayoutManager(new LinearLayoutManager(this));
        mViewDataBinding.includeRefresh.recy.setAdapter(leaderboardAdapter = new LeaderboardAdapter());
        mViewDataBinding.includeRefresh.refresh.setOnRefreshLoadMoreListener(this);
    }

    @Override
    protected void initData() {
        super.initData();
        mViewModel.leaderBoardLiveData.observe(this, leaderboards -> {
            if (mViewDataBinding.includeRefresh.refresh.getState().isOpening) {
                mViewDataBinding.includeRefresh.refresh.finishRefresh();
                mViewDataBinding.includeRefresh.refresh.finishLoadMore();
            }
            if (leaderboards != null && leaderboards.size() > 0) {
                if (pageInfo.isZeroPage()) {
                    showContent();
                    leaderboardAdapter.setList(leaderboards);
                } else {
                    leaderboardAdapter.addData(leaderboards);
                }
                pageInfo.nextZeroPage();
            } else {
                if (pageInfo.isZeroPage()) {
                    showEmpty();
                } else {
                    leaderboardAdapter.addData(leaderboards);
                    mViewDataBinding.includeRefresh.refresh.finishLoadMoreWithNoMoreData();
                }
            }
        });
    }


    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        loadData();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        pageInfo.resetZero();
        loadData();
    }

    private void loadData() {
        mViewModel.getRankList(pageInfo.mPage);
    }
}

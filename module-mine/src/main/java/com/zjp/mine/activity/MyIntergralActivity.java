package com.zjp.mine.activity;

import android.content.Context;
import android.content.Intent;

import androidx.lifecycle.Observer;

import com.zjp.base.activity.BaseActivity;
import com.zjp.common.bean.UserInfo;
import com.zjp.common.bean.page.PageInfo;
import com.zjp.mine.R;
import com.zjp.mine.adapter.MyIntergralAdapter;
import com.zjp.mine.bean.Leaderboard;
import com.zjp.mine.databinding.ActivityMyIntergralBinding;
import com.zjp.mine.viewmodel.MineViewModel;

import java.util.List;

/**
 * Created by zjp on 2020/07/15 17:07
 */
public class MyIntergralActivity extends BaseActivity<ActivityMyIntergralBinding, MineViewModel> {

    private PageInfo pageInfo;
    private MyIntergralAdapter myIntergralAdapter;

    public static void start(Context context) {
        context.startActivity(new Intent(context, MyIntergralActivity.class));
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
        return R.layout.activity_my_intergral;
    }

    @Override
    protected void initView() {
        super.initView();
        mViewDataBinding.titleview.setTitle("我的积分");
        pageInfo = new PageInfo();
mViewDataBinding.rvIntergralList.setAdapter(myIntergralAdapter = new MyIntergralAdapter());


        loadData();
    }

    @Override
    protected void initData() {
        super.initData();

        mViewModel.mLeaderBoardMuTable.observe(this, new Observer<Leaderboard>() {
            @Override
            public void onChanged(Leaderboard leaderboard) {
                if (null != leaderboard) {
                    List<UserInfo> userInfos = leaderboard.getDatas();
                    pageInfo.nextPage();
                    if (leaderboard.getCurPage() == 1) {
                        if (userInfos != null && userInfos.size() > 0) {
                            showContent();
//                            articleListAdapter.setList(datas);
                        }
                    }
                }
            }
        });

    }

    private void loadData() {
//        String coinCount = MmkvHelper.getInstance().getUserInfo().getCoinCount();
        mViewModel.getIntegralRecord(pageInfo.page);
    }

}

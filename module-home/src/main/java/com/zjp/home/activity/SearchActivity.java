package com.zjp.home.activity;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.gyf.immersionbar.ImmersionBar;
import com.zjp.base.activity.BaseActivity;
import com.zjp.common.storage.MmkvHelper;
import com.zjp.home.R;
import com.zjp.home.adapter.HomeSearchHistoryAdapter;
import com.zjp.home.adapter.HotSearchAdapter;
import com.zjp.home.databinding.ActivitySearchBinding;
import com.zjp.home.viewmodel.HomeViewModel;
import com.zjp.home.viewmodel.SearchViewModel;
import com.zjp.network.constant.ApiConstants;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by zjp on 2020/5/25 21:32.
 */
public class SearchActivity extends BaseActivity<ActivitySearchBinding, SearchViewModel> {

    private HomeSearchHistoryAdapter homeSearchHistoryAdapter;
    private HotSearchAdapter hotSearchAdapter;

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar
                .statusBarDarkFont(true)
                .init();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {
        super.initView();

        ViewGroup.LayoutParams layoutParams = mViewDataBinding.viewStatus.getLayoutParams();
        layoutParams.height = ImmersionBar.getStatusBarHeight(this);
        mViewDataBinding.viewStatus.setLayoutParams(layoutParams);

        //初始化搜索历史记录adapter
        mViewDataBinding.recyclerHistory.setLayoutManager(new LinearLayoutManager(this));
        mViewDataBinding.recyclerHistory.setAdapter(homeSearchHistoryAdapter = new HomeSearchHistoryAdapter());

        //初始化热门搜索adapter
        mViewDataBinding.recyFlex.setLayoutManager(new FlexboxLayoutManager(this, FlexDirection.ROW, FlexWrap.WRAP) {
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }
        });
        mViewDataBinding.recyFlex.setAdapter(hotSearchAdapter = new HotSearchAdapter());

        mViewDataBinding.ivBack.setOnClickListener(v -> {
            finishAfterTransition();
            KeyboardUtils.hideSoftInput(SearchActivity.this);
        });
        fillHistory();
        mViewModel.hotSearch();
    }

    @Override
    protected void initData() {
        super.initData();
        mViewModel.mHotSearchMutable.observe(this, hotSearchEntities -> {
            if (hotSearchEntities != null && hotSearchEntities.size() > 0) {
                hotSearchAdapter.setList(hotSearchEntities);
            }
        });

        mViewDataBinding.searchEt.setOnEditorActionListener((textView, actionId, keyEvent) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                String searchVal = mViewDataBinding.searchEt.getText().toString().trim();
                if (TextUtils.isEmpty(searchVal)) {
                    ToastUtils.showShort("请输入内容再搜索!");
                } else {
                    saveDB(searchVal);
//                    skipActivity(searchVal);
                }
            }
            return false;
        });

        mViewDataBinding.clearHistoryTv.setOnClickListener(v -> {
            if (TextUtils.equals(mViewDataBinding.clearHistoryTv.getText().toString(), "全部搜索记录")) {
                List<String> searchHistories = MmkvHelper.getInstance().getDataList(ApiConstants.SEARCH_HISTORY);
                searchHistories = searchHistories.subList(2, searchHistories.size());
                homeSearchHistoryAdapter.addData(searchHistories);
                KeyboardUtils.hideSoftInput(mViewDataBinding.clearHistoryTv);
                mViewDataBinding.clearHistoryTv.setText("清除全部历史记录");
            } else {
                MmkvHelper.getInstance().clearHistory();
                mViewDataBinding.historyPage.setVisibility(View.VISIBLE);
            }
        });
    }

    private void fillHistory() {
        List<String> dataList = MmkvHelper.getInstance().getDataList(ApiConstants.SEARCH_HISTORY);
        if (null != dataList && dataList.size() > 0) {
            if (dataList.size() == 1 || dataList.size() == 2) {
                mViewDataBinding.clearHistoryTv.setText("清除全部历史记录");
            } else {
                mViewDataBinding.clearHistoryTv.setText("全部搜索记录");
                dataList = dataList.subList(0, 2);
            }
            mViewDataBinding.historyPage.setVisibility(View.VISIBLE);
            homeSearchHistoryAdapter.setList(dataList);
        } else {
            mViewDataBinding.historyPage.setVisibility(View.GONE);
        }
    }

    private void saveDB(String keyWords) {
        List<String> mSearchHistoryList = MmkvHelper.getInstance().getDataList(ApiConstants.SEARCH_HISTORY);
        if (null != mSearchHistoryList && mSearchHistoryList.size() > 0) {
            for (int i = 0; i < mSearchHistoryList.size(); i++) {
                if (TextUtils.equals(keyWords, mSearchHistoryList.get(i))) {
                    mSearchHistoryList.remove(i);
                }
            }
        }
        mSearchHistoryList.add(keyWords);
        MmkvHelper.getInstance().saveList(ApiConstants.SEARCH_HISTORY, mSearchHistoryList);
    }

    @Override
    protected void onResume() {
        super.onResume();
        showSoftInputFromWindow(this, mViewDataBinding.searchEt);
    }

    public void showSoftInputFromWindow(Activity activity, EditText editText) {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }
}

package com.zjp.home.activity;

import android.app.Activity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.gyf.immersionbar.ImmersionBar;
import com.zjp.base.activity.BaseActivity;
import com.zjp.home.R;
import com.zjp.home.adapter.HomeSearchAdapter;
import com.zjp.home.adapter.HotSearchAdapter;
import com.zjp.home.databinding.ActivitySearchBinding;
import com.zjp.home.viewmodel.HomeViewModel;


/**
 * Created by zjp on 2020/5/25 21:32.
 */
public class SearchActivity extends BaseActivity<ActivitySearchBinding, HomeViewModel> {

    private HomeSearchAdapter homeSearchAdapter;
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
        mViewDataBinding.recyclerHistory.setAdapter(homeSearchAdapter = new HomeSearchAdapter());

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
    }

    private void saveDB(String keyWords) {

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

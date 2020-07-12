package com.zjp.mine.activity;

import android.widget.CompoundButton;

import com.zjp.base.activity.BaseActivity;
import com.zjp.base.event.SettingEvent;
import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.common.storage.MmkvHelper;
import com.zjp.mine.R;
import com.zjp.mine.databinding.ActivitySettingBinding;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by zjp on 2020/7/7 21:46.
 */
public class SettingActivity extends BaseActivity<ActivitySettingBinding, BaseViewModel> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar
                .statusBarDarkFont(true)
                .init();
    }

    @Override
    protected void initView() {
        super.initView();
        mViewDataBinding.title.setTitle("设置");

        mViewDataBinding.swShowTop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                MmkvHelper.getInstance().hideTopArticle(isChecked);
            }
        });
    }

    /**
     * 用户操作的时候不发送广播，当关闭设置页时候发送广播
     */
    @Override
    protected void onStop() {
        super.onStop();
        boolean hideTopArticle = MmkvHelper.getInstance().getHideTopArticle();
        SettingEvent settingEvent = new SettingEvent();
        settingEvent.setHideTopArticle(hideTopArticle);
        EventBus.getDefault().post(settingEvent);
    }
}

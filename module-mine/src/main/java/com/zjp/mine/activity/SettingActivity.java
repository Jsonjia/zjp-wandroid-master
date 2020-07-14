package com.zjp.mine.activity;

import android.widget.CompoundButton;

import androidx.lifecycle.Observer;

import com.afollestad.materialdialogs.MaterialDialog;
import com.zjp.base.activity.BaseActivity;
import com.zjp.base.event.SettingEvent;
import com.zjp.common.storage.MmkvHelper;
import com.zjp.mine.R;
import com.zjp.mine.databinding.ActivitySettingBinding;
import com.zjp.mine.viewmodel.MineViewModel;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by zjp on 2020/7/7 21:46.
 */
public class SettingActivity extends BaseActivity<ActivitySettingBinding, MineViewModel> {

    private MaterialDialog materialDialog;

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
        boolean hideTopArticle = MmkvHelper.getInstance().getshowTopArticle();
        mViewDataBinding.swShowTop.setChecked(hideTopArticle);

        mViewModel.getCacheSize();
    }

    @Override
    protected void initData() {
        super.initData();
        mViewModel.mCacheSizeLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mViewDataBinding.tvCacheVal.setText(s);
            }
        });


        mViewDataBinding.swShowTop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                MmkvHelper.getInstance().showTopArticle(isChecked);
            }
        });

        mViewDataBinding.swSwitchNight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                MmkvHelper.getInstance().setDarkTheme(isChecked);
            }
        });

//        mViewDataBinding.

        mViewDataBinding.clClearCache.setOnClickListener(view -> {
            materialDialog = new MaterialDialog(SettingActivity.this, MaterialDialog.getDEFAULT_BEHAVIOR());
            materialDialog.title(R.string.tips, null);
            materialDialog.message(R.string.login_out_tips, null, null);
            materialDialog.positiveButton(R.string.sure, null, materialDialog1 -> {
//                    MmkvHelper.getInstance().cl

                return null;
            }).negativeButton(R.string.cancel, null, materialDialog2 -> {

                return null;
            }).show();
        });

        mViewDataBinding.clCopyright.setOnClickListener(view -> {
            materialDialog = new MaterialDialog(SettingActivity.this, MaterialDialog.getDEFAULT_BEHAVIOR());
            materialDialog.title(R.string.tips, null);
            materialDialog.message(R.string.copyright_tips, null, null);
            materialDialog.positiveButton(R.string.sure, null, materialDialog1 -> {
                return null;
            }).show();
        });


    }

    /**
     * 用户操作的时候不发送广播，当关闭设置页时候发送广播
     */
    @Override
    protected void onStop() {
        super.onStop();
        boolean showTopArticle = MmkvHelper.getInstance().getshowTopArticle();
        SettingEvent settingEvent = new SettingEvent();
        settingEvent.setShowTopArticle(showTopArticle);
        EventBus.getDefault().post(settingEvent);
    }
}

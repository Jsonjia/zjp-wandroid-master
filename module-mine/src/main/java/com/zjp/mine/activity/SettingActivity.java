package com.zjp.mine.activity;

import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog;

import com.blankj.utilcode.util.ToastUtils;
import com.zjp.base.activity.BaseActivity;
import com.zjp.base.event.SettingEvent;
import com.zjp.common.BuildConfig;
import com.zjp.common.storage.MmkvHelper;
import com.zjp.mine.R;
import com.zjp.mine.databinding.ActivitySettingBinding;
import com.zjp.mine.viewmodel.MineViewModel;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by zjp on 2020/7/7 21:46.
 */
public class SettingActivity extends BaseActivity<ActivitySettingBinding, MineViewModel> {

    public static void start(Context context) {
        context.startActivity(new Intent(context, SettingActivity.class));
    }

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

        mViewDataBinding.tvCurrentVersionVal.setText("v" + BuildConfig.VERSION_NAME);
        mViewModel.getCacheSize();
    }

    @Override
    protected void initData() {
        super.initData();
        mViewModel.mCacheSizeLiveData.observe(this, s -> mViewDataBinding.tvCacheVal.setText(s));
        mViewModel.loginoutLiveData.observe(this, baseResponse -> {
            if (baseResponse.getErrorCode() == 0) {
                MmkvHelper.getInstance().logout();
                finish();
            }
        });


        mViewDataBinding.swShowTop.setOnCheckedChangeListener((compoundButton, isChecked) -> MmkvHelper.getInstance().showTopArticle(isChecked));

//        mViewDataBinding.swSwitchNight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
//                MmkvHelper.getInstance().setDarkTheme(isChecked);
//            }
//        });

        mViewDataBinding.setEventlistener(new EventListener());
    }

    public class EventListener {

        public void clickClearCache() {

            //弃用 MaterialDialog
//         MaterialDialog  materialDialog = new MaterialDialog(SettingActivity.this, MaterialDialog.getDEFAULT_BEHAVIOR());
////            materialDialog.title(R.string.tips, null);
////            materialDialog.message(R.string.clear_cache, null, null);
////            materialDialog.positiveButton(R.string.sure, null, materialDialog1 -> {
////                mViewModel.clearCache();
////                return null;
////            }).negativeButton(R.string.cancel, null, materialDialog2 -> {
////                return null;
////            }).show();
////
            //该dialog弹出的dialog框，字体都太小了
//            new MaterialAlertDialogBuilder(SettingActivity.this)
//                    .setTitle(R.string.tips)
//                    .setMessage(R.string.clear_cache)
//                    .setPositiveButton(R.string.sure, (dialogInterface, i) -> mViewModel.clearCache())
//                    .setNegativeButton(R.string.cancel, null)
//                    .show();
            new AlertDialog.Builder(SettingActivity.this)
                    .setTitle(R.string.tips)
                    .setMessage(R.string.clear_cache)
                    .setPositiveButton(R.string.sure, (dialogInterface, i) -> mViewModel.clearCache())
                    .setNegativeButton(R.string.cancel, null)
                    .show();
        }

        public void clickCurrentVersion() {
            ToastUtils.showShort("已经是最新版本");
        }

        public void clickCopyright() {
            new AlertDialog.Builder(SettingActivity.this)
                    .setTitle(R.string.tips)
                    .setMessage(R.string.copyright_tips)
                    .setPositiveButton(R.string.sure, null)
                    .show();
        }

        public void clickAboutMe() {
            AboutAppActivity.start(SettingActivity.this);
        }

        public void clickLoginout() {
            new AlertDialog.Builder(SettingActivity.this)
                    .setTitle(R.string.tips)
                    .setMessage(R.string.login_out_tips)
                    .setPositiveButton(R.string.sure, (dialogInterface, i) -> {
                        dialogInterface.dismiss();
                        mViewModel.loginout();
                    }).setNegativeButton(R.string.cancel, (dialogInterface, i) -> dialogInterface.dismiss()).show();
        }
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

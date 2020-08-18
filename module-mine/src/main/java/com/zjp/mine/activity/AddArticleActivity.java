package com.zjp.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AlertDialog;

import com.blankj.utilcode.util.ScreenUtils;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.zjp.base.activity.BaseActivity;
import com.zjp.mine.R;
import com.zjp.mine.databinding.ActivityAddarticleBinding;
import com.zjp.mine.viewmodel.MineViewModel;

/**
 * Created by zjp on 2020/08/05 16:31
 */
public class AddArticleActivity extends BaseActivity<ActivityAddarticleBinding, MineViewModel> {

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar
                .statusBarDarkFont(true)
                .init();
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, AddArticleActivity.class));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_addarticle;
    }

    @Override
    protected void initView() {
        super.initView();
        mViewDataBinding.titleview.setTitle("添加文章");
        mViewDataBinding.titleview.getIvRight().setImageResource(R.mipmap.ic_guize);
        mViewDataBinding.titleview.setIvRightVisible(View.VISIBLE);
        mViewDataBinding.titleview.getIvRight().setOnClickListener((View.OnClickListener) view -> {

            View dialogView = LayoutInflater.from(AddArticleActivity.this).inflate(R.layout.bottom_sheet_dialog_warm_tip, null);
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(AddArticleActivity.this, R.style.BottomSheetDialog);
            bottomSheetDialog.setContentView(dialogView);
            bottomSheetDialog.setCancelable(true);
            bottomSheetDialog.setCanceledOnTouchOutside(true);
            ViewGroup parent = (ViewGroup) dialogView.getParent();
            BottomSheetBehavior<ViewGroup> behavior = BottomSheetBehavior.from((ViewGroup) parent);
            // 设置bottomSheet的折叠高度
            // 比如设置成屏幕的1/2（不包括状态栏）
            behavior.setPeekHeight(ScreenUtils.getScreenHeight() / 2);
            behavior.setHideable(false);

            ViewGroup.LayoutParams layoutParams = parent.getLayoutParams();
            layoutParams.height = ScreenUtils.getScreenHeight() / 6 * 5;
            parent.setLayoutParams(layoutParams);

            bottomSheetDialog.show();

//                MaterialDialog materialDialog = new MaterialDialog(AddArticleActivity.this, new BottomSheet());
//                materialDialog.title(R.string.warm_tips, null);
////                materialDialog.message(R.string.clear_cache, null, null);
////                DialogCustomViewExtKt.customView(R.layout.base_layout_empty, );
//                materialDialog.positiveButton(R.string.sure, null, materialDialog1 -> {
//                    mViewModel.clearCache();
//                    return null;
//                }).negativeButton(R.string.cancel, null, materialDialog2 -> {
//                    return null;
//                }).show();
        });
    }

    @Override
    protected void initData() {
        super.initData();
        mViewModel.mShareArticleMutable.observe(this, baseResponse -> finish());
    }

    public void share(View view) {
        new AlertDialog.Builder(AddArticleActivity.this)
                .setTitle(R.string.tips)
                .setMessage(R.string.share_tips)
                .setPositiveButton(R.string.sure, (dialogInterface, i) -> mViewModel.shareArticle(mViewDataBinding.etShareTitle.getText().toString(), mViewDataBinding.etShareUrl.getText().toString()))
                .setNegativeButton(R.string.cancel, null)
                .show();
    }
}

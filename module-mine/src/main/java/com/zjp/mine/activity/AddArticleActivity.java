package com.zjp.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.zjp.base.activity.BaseActivity;
import com.zjp.mine.R;
import com.zjp.mine.databinding.ActivityAddarticleBinding;
import com.zjp.mine.dialog.WarmTipBottomSheetDialogFragment;
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
        mViewDataBinding.titleview.getIvRight().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                WarmTipBottomSheetDialogFragment fragment = new WarmTipBottomSheetDialogFragment();
//                fragment.setOnTagItemSelectedListener(new TagBottomSheetDialogFragment.OnTagItemSelectedListener() {
//                    @Override
//                    public void onTagItemSelected(TagList tagList) {
//                        mTagList = tagList;
//                        mBinding.actionAddTag.setText(tagList.title);
//                    }
//                });
                fragment.show(getSupportFragmentManager(), "tag_dialog");

                //https://www.jianshu.com/p/859943121b05
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
            }
        });
    }
}

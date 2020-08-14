package com.zjp.mine.activity;

import android.view.View;

import com.zjp.base.activity.BaseActivity;
import com.zjp.mine.R;
import com.zjp.mine.databinding.ActivityAddarticleBinding;
import com.zjp.mine.viewmodel.MineViewModel;

/**
 * Created by zjp on 2020/08/05 16:31
 */
public class AddArticleActivity extends BaseActivity<ActivityAddarticleBinding, MineViewModel> {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_addarticle;
    }

    @Override
    protected void initView() {
        super.initView();
        mViewDataBinding.titleview.setTitle("添加文章");
        mViewDataBinding.titleview.setIvRightVisible(View.VISIBLE);
        mViewDataBinding.titleview.getIvRight().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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

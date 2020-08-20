package com.zjp.square.adapter;

import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.google.android.flexbox.FlexboxLayout;
import com.zjp.common.bean.ArticleEntity;
import com.zjp.square.R;
import com.zjp.square.bean.NaviBean;
import com.zjp.square.databinding.AdapterItemNavigationBinding;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zjp on 2020/8/20 22:06.
 */
public class NavigationAdapter extends BaseQuickAdapter<NaviBean, BaseDataBindingHolder<AdapterItemNavigationBinding>> {

    private LayoutInflater layoutInflater = null;
    private Queue<AppCompatTextView> mFlexItemTextViewCaches = new LinkedList<>();
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public NavigationAdapter() {
        super(R.layout.adapter_item_navigation);
    }

    @Override
    protected void convert(@NotNull BaseDataBindingHolder<AdapterItemNavigationBinding> bindingHolder, NaviBean naviBean) {
        AdapterItemNavigationBinding dataBinding = bindingHolder.getDataBinding();
        if (dataBinding != null) {
            dataBinding.setNavibean(naviBean);
            List<ArticleEntity.DatasBean> articles = naviBean.getArticles();
            FlexboxLayout flexLayout = dataBinding.flexLayout;
//            flexLayout.removeAllViews();  //注释这条属性，用下面onViewRecycled()方法也行
            for (int i = 0; i < articles.size(); i++) {
                ArticleEntity.DatasBean datasBean = articles.get(i);
                AppCompatTextView labelTv = createOrGetCacheTv(flexLayout);
                labelTv.setText(datasBean.getTitle());
                labelTv.setOnClickListener(v -> {
                    if (onItemClickListener != null)
                        onItemClickListener.onClick(datasBean);
                });
                flexLayout.addView(labelTv);
            }
            dataBinding.executePendingBindings();
        }
    }

    @Override
    public void onViewRecycled(@NonNull BaseDataBindingHolder<AdapterItemNavigationBinding> holder) {
        super.onViewRecycled(holder);
        AdapterItemNavigationBinding dataBinding = holder.getDataBinding();
        FlexboxLayout flexLayout = dataBinding.flexLayout;
        for (int i = 0; i < flexLayout.getChildCount(); i++) {
            mFlexItemTextViewCaches.offer((AppCompatTextView) flexLayout.getChildAt(i));
        }
        flexLayout.removeAllViews();
    }

    private AppCompatTextView createOrGetCacheTv(FlexboxLayout flexboxLayout) {
        AppCompatTextView tv = mFlexItemTextViewCaches.poll();
        if (tv != null) {
            return tv;
        }
        return findLabel(flexboxLayout);
    }

    private AppCompatTextView findLabel(FlexboxLayout flexboxLayout) {
        if (layoutInflater == null)
            layoutInflater = LayoutInflater.from(flexboxLayout.getContext());
        return (AppCompatTextView) layoutInflater.inflate(R.layout.flextlayout_item_label, flexboxLayout, false);
    }

    public interface OnItemClickListener {
        void onClick(ArticleEntity.DatasBean datasBean);
    }
}

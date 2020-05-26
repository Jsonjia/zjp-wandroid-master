package com.zjp.home.adapter;

import android.text.TextUtils;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.zjp.common.constant.C;
import com.zjp.common.utils.GlideUtil;
import com.zjp.home.R;
import com.zjp.home.bean.ArticleEntity;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Created by zjp on 2020/5/15 14:18
 */
public class HomeArticleListAdapter extends BaseMultiItemQuickAdapter<ArticleEntity.DatasBean, BaseViewHolder> implements LoadMoreModule {

    public HomeArticleListAdapter(List<ArticleEntity.DatasBean> data) {
        super(data);
        addItemType(C.ARTICLE_ITEM, R.layout.home_adapter_item_article);
        addItemType(C.ARTICLE_ITEM_PIC, R.layout.item_project);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, ArticleEntity.DatasBean datasBean) {
        switch (baseViewHolder.getItemViewType()) {
            case C.ARTICLE_ITEM:
                baseViewHolder.setText(R.id.tv_date, datasBean.getNiceDate())
                        .setText(R.id.tv_chapter_name, datasBean.getSuperChapterName())
                        .setGone(R.id.view_label, datasBean.getType() == 0);
                break;

            case C.ARTICLE_ITEM_PIC:

                break;
        }

        baseViewHolder
                .setText(R.id.tv_author, TextUtils.isEmpty(datasBean.getAuthor()) ? datasBean.getShareUser()
                        : datasBean.getAuthor())
                .setText(R.id.tv_title, datasBean.getTitle());
    }
}

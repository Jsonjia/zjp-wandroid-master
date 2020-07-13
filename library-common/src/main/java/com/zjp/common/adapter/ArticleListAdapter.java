package com.zjp.common.adapter;

import android.text.Html;
import android.text.TextUtils;

import androidx.appcompat.widget.AppCompatImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.zjp.common.R;
import com.zjp.common.bean.ArticleEntity;
import com.zjp.common.utils.GlideUtil;
import com.zjp.network.constant.C;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Created by zjp on 2020/5/15 14:18
 */
public class ArticleListAdapter extends BaseMultiItemQuickAdapter<ArticleEntity.DatasBean, BaseViewHolder> implements LoadMoreModule {

    public ArticleListAdapter(List<ArticleEntity.DatasBean> data) {
        super(data);
        addItemType(C.ARTICLE_ITEM, R.layout.article_txt_item);
        addItemType(C.ARTICLE_ITEM_PIC, R.layout.article_img_item);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, ArticleEntity.DatasBean datasBean) {
        switch (baseViewHolder.getItemViewType()) {
            case C.ARTICLE_ITEM:
                baseViewHolder.setText(R.id.tv_date, datasBean.getNiceDate())
                        .setText(R.id.tv_chapter_name, datasBean.getSuperChapterName())
                        .setGone(R.id.view_label, datasBean.getType() != 1);
                break;

            case C.ARTICLE_ITEM_PIC:
                AppCompatImageView mIvCover = baseViewHolder.getView(R.id.iv_cover);
                GlideUtil.getInstance().loadRoundImage(mIvCover, datasBean.getEnvelopePic(), 8);
                baseViewHolder.setText(R.id.tv_desc, datasBean.getDesc());
                break;
        }

        baseViewHolder.setText(R.id.tv_author, TextUtils.isEmpty(datasBean.getAuthor()) ?
                datasBean.getShareUser() : datasBean.getAuthor())
                .setText(R.id.tv_title, Html.fromHtml(datasBean.getTitle()));
    }
}

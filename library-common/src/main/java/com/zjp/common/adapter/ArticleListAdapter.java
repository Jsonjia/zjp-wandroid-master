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
        addChildClickViewIds(R.id.iv_collect);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, ArticleEntity.DatasBean datasBean) {
        switch (baseViewHolder.getItemViewType()) {
            case C.ARTICLE_ITEM:
                baseViewHolder.setText(R.id.tv_date, datasBean.getNiceDate())
                        .setText(R.id.tv_chapter_name, Html.fromHtml(formatChapterName(datasBean.getSuperChapterName(), datasBean.getChapterName())))
                        .setGone(R.id.view_label, datasBean.getType() != 1)
                        .setGone(R.id.tv_new, !datasBean.isFresh());

                if (datasBean.getTags() != null && datasBean.getTags().size() > 0) {
                    baseViewHolder.setGone(R.id.tv_tag, false)
                            .setText(R.id.tv_tag, datasBean.getTags().get(0).getName());
                } else {
                    baseViewHolder.setGone(R.id.tv_tag, true);
                }
                break;

            case C.ARTICLE_ITEM_PIC:
                AppCompatImageView mIvCover = baseViewHolder.getView(R.id.iv_cover);
                GlideUtil.getInstance().loadRoundImage(mIvCover, datasBean.getEnvelopePic(), 8);
                baseViewHolder.setText(R.id.tv_desc, datasBean.getDesc());
                break;
        }

        baseViewHolder.setText(R.id.tv_author, datasBean.getAuthor())
                .setText(R.id.tv_title, Html.fromHtml(datasBean.getTitle()))
                .setImageResource(R.id.iv_collect, datasBean.isCollect() ? R.mipmap.article_collect : R.mipmap.article_un_collect);
    }

    private static String formatChapterName(String... names) {
        StringBuilder format = new StringBuilder();
        for (String name : names) {
            if (!TextUtils.isEmpty(name)) {
                if (format.length() > 0) {
                    format.append("·");
                }
                format.append(name);
            }
        }
        return format.toString();
    }

    @Override
    protected void convert(@NotNull BaseViewHolder holder, ArticleEntity.DatasBean item, @NotNull List<?> payloads) {
        if (payloads.isEmpty()) {
            super.convert(holder, item, payloads);
        } else {
            if (TextUtils.equals(payloads.get(0).toString(), C.REFRESH_COLLECT)) {
                holder.setImageResource(R.id.iv_collect, item.isCollect() ? R.mipmap.article_collect : R.mipmap.article_un_collect);
            }
        }
    }

    /**
     * 取消收藏，做单个删除
     */
    public void cancelCollect(int position) {
        getData().remove(position);
        notifyItemRemoved(position);
    }
}

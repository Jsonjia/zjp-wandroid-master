package com.zjp.mine.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.zjp.common.bean.UserInfo;
import com.zjp.mine.R;

import org.jetbrains.annotations.NotNull;

/**
 * Created by zjp on 2020/7/15 22:42.
 */
public class LeaderboardAdapter extends BaseQuickAdapter<UserInfo, BaseViewHolder> {

    public LeaderboardAdapter() {
        super(R.layout.item_rank);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, UserInfo datasBean) {
        switch (baseViewHolder.getAdapterPosition()) {
            case 0:
                baseViewHolder.setGone(R.id.iv_rank, false)
                        .setImageResource(R.id.iv_rank, R.mipmap.gold_crown)
                        .setVisible(R.id.tv_rank, false);
                break;

            case 1:
                baseViewHolder.setGone(R.id.iv_rank, false)
                        .setImageResource(R.id.iv_rank, R.mipmap.silver_crown)
                        .setVisible(R.id.tv_rank, false);
                break;

            case 2:
                baseViewHolder.setGone(R.id.iv_rank, false)
                        .setImageResource(R.id.iv_rank, R.mipmap.cooper_crown)
                        .setVisible(R.id.tv_rank, false);
                break;
            default:
                baseViewHolder.setVisible(R.id.iv_rank, false)
                        .setText(R.id.tv_rank, baseViewHolder.getAdapterPosition() + 1 + "")
                        .setVisible(R.id.tv_rank, true);
                break;
        }

        baseViewHolder.setText(R.id.tv_name, datasBean.getUsername())
                .setText(R.id.tv_integral, datasBean.getCoinCount() + "");
    }
}

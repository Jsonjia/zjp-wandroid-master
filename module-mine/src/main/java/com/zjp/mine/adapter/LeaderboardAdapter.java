package com.zjp.mine.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.zjp.mine.R;
import com.zjp.mine.bean.Leaderboard;

import org.jetbrains.annotations.NotNull;

/**
 * Created by zjp on 2020/7/15 22:42.
 */
public class LeaderboardAdapter extends BaseQuickAdapter<Leaderboard, BaseViewHolder> {

    public LeaderboardAdapter() {
        super(R.layout.base_layout_empty);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, Leaderboard leaderboard) {

    }
}

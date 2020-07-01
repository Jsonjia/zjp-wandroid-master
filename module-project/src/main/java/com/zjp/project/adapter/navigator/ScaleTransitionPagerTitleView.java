package com.zjp.project.adapter.navigator;

import android.content.Context;

import com.zjp.common.callback.TabSelectListener;

import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

/**
 * Created by zjp on 2020/7/1 13:40
 */
public class ScaleTransitionPagerTitleView extends ColorTransitionPagerTitleView {

    private TabSelectListener tabSelectListener;

    public void setTabSelectListener(TabSelectListener tabSelectListener) {
        this.tabSelectListener = tabSelectListener;
    }

    public ScaleTransitionPagerTitleView(Context context) {
        super(context);
    }

    @Override
    public void onSelected(int index, int totalCount) {
        super.onSelected(index, totalCount);
        if (tabSelectListener != null)
            tabSelectListener.onSelect(index, totalCount);
    }

    @Override
    public void onDeselected(int index, int totalCount) {
        super.onDeselected(index, totalCount);
        if (tabSelectListener != null)
            tabSelectListener.onDeselected(index, totalCount);
    }
}

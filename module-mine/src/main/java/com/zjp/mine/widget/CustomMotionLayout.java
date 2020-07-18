package com.zjp.mine.widget;

import android.content.Context;
import android.util.AttributeSet;

import androidx.constraintlayout.motion.widget.MotionLayout;

import com.google.android.material.appbar.AppBarLayout;

/**
 * Created by zjp on 2020/07/18 10:32
 */
public class CustomMotionLayout extends MotionLayout implements AppBarLayout.OnOffsetChangedListener {

    public CustomMotionLayout(Context context) {
        this(context, null);
    }

    public CustomMotionLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        setProgress(-verticalOffset / (float) appBarLayout.getTotalScrollRange());
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if(getParent() instanceof AppBarLayout){
            ((AppBarLayout) getParent()).addOnOffsetChangedListener(this);
        }
    }
}

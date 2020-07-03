package com.zjp.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

/**
 * Created by zjp on 2020/7/2 10:18
 * 这里什么都没做，只是去除与TabLayout滑动时候的动画，动画体验不好，固去除
 */
public class NoAnimationViewpager extends ViewPager {

    public NoAnimationViewpager(@NonNull Context context) {
        super(context);
    }

    public NoAnimationViewpager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item, false);
    }
}

package com.zjp.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;

import com.gyf.immersionbar.ImmersionBar;
import com.zjp.common.R;

/**
 * Created by zjp on 2020/5/18 11:18
 */
public class CommonHeadTitle extends FrameLayout {

    private final AppCompatTextView mTvTitle, mTvRight;
    private AppCompatImageView mIvRight;
    private final View mStatusView;
    private final View mBackView;

    public CommonHeadTitle(@NonNull Context context) {
        this(context, null);
    }

    public CommonHeadTitle(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CommonHeadTitle(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        FragmentActivity activity = (FragmentActivity) context;

        View inflate = LayoutInflater.from(context).inflate(R.layout.common_head_title, this, true);
        mStatusView = inflate.findViewById(R.id.view_status);
        ViewGroup.LayoutParams layoutParams = mStatusView.getLayoutParams();
        layoutParams.height = ImmersionBar.getStatusBarHeight(activity);
        mStatusView.setLayoutParams(layoutParams);

        mBackView = inflate.findViewById(R.id.iv_back);
        mBackView.setOnClickListener(v -> activity.finish());
        mTvTitle = inflate.findViewById(R.id.tv_title);
        mTvRight = inflate.findViewById(R.id.tv_right);
        mIvRight = inflate.findViewById(R.id.iv_right);
    }

    public void setTitle(String title) {
        mTvTitle.setText(title);
    }

    public void setStatusViewColor(int color) {
        mStatusView.setBackgroundColor(color);
    }


    public void setTvRightTextSizeColor(int color) {
        mTvRight.setTextColor(color);
    }

    public View getBackView() {
        return mBackView;
    }

    public void setTvRightText(String text) {
        mTvRight.setText(text);
    }

    public AppCompatTextView getTvRight() {
        return mTvRight;
    }

    public void setTvRightVisible(int visible) {
        mTvRight.setVisibility(visible);
    }

    public AppCompatImageView getIvRight() {
        return mIvRight;
    }

    public void setIvRightVisible(int visible) {
        mIvRight.setVisibility(visible);
    }
}

//package com.zjp.login.widget;
//
//import android.content.Context;
//import android.util.AttributeSet;
//import android.util.Log;
//import android.view.Gravity;
//import android.widget.FrameLayout;
//import android.widget.ImageView;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//
//import com.zjp.login.R;
//
//
///**
// * Created by zjp on 2020/5/18 13:53
// */
//public class LogoAnimView extends FrameLayout implements Runnable {
//
//    public LogoAnimView(@NonNull Context context) {
//        this(context, null);
//    }
//
//    public LogoAnimView(@NonNull Context context, @Nullable AttributeSet attrs) {
//        this(context, attrs, 0);
//    }
//
//    public LogoAnimView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        initView(context);
//    }
//
//    private void initView(Context context) {
//        ImageView logo = new ImageView(context);
//        logo.setImageResource(R.mipmap.logo);
//        logo.setScaleType(ImageView.ScaleType.FIT_CENTER);
//
//        ImageView eyeLeft = new ImageView(context);
//        eyeLeft.setImageResource(R.drawable.bg_white_circle);
//        eyeLeft.setScaleType(ImageView.ScaleType.FIT_CENTER);
//
//        ImageView eyeRight = new ImageView(context);
//        logo.setImageResource(R.drawable.bg_white_circle);
//        logo.setScaleType(ImageView.ScaleType.FIT_CENTER);
//
//        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
//        layoutParams.gravity = Gravity.CENTER;
//        addViewInLayout(logo, getChildCount(), layoutParams);
//
//        layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
//        layoutParams.gravity = Gravity.LEFT;
//        addViewInLayout(eyeLeft, getChildCount(), layoutParams);
//
//        layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
//        layoutParams.gravity = Gravity.RIGHT;
//        addViewInLayout(eyeRight, getChildCount(), layoutParams);
//    }
//
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        int w = MeasureSpec.getSize(widthMeasureSpec);
//        int h = MeasureSpec.getSize(heightMeasureSpec);
//
//        int size = Math.min(w, h);
//        setMeasuredDimension(size, size);
//
//        int eyeSize = (int) (size * 0.1F);
//
//
//    }
//
//    @Override
//    public void run() {
//
//    }
//
//}

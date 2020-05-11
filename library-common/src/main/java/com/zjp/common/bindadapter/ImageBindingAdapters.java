package com.zjp.common.bindadapter;

import android.text.TextUtils;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.BindingAdapter;

import com.zjp.common.utils.GlideUtil;

/**
 * Created by zjp on 2020/5/11 16:47
 */
public class ImageBindingAdapters {

    @BindingAdapter("loadImageUrl")
    public static void loadImage(ImageView imageView, String url) {
        if (!TextUtils.isEmpty(url)) {
            GlideUtil.getInstance().loadImage(imageView, url);
        }
    }

    @BindingAdapter("loadCircleImageUrl")
    public static void loadCircleImage(ImageView imageView, String url) {
        if (!TextUtils.isEmpty(url)) {
            GlideUtil.getInstance().loadCircleImage(imageView, url);
        }
    }

    @BindingAdapter("loadRoundImageUrl")
    public static void loadRoundImage(AppCompatImageView imageView, String url) {
        if (!TextUtils.isEmpty(url)) {
            GlideUtil.getInstance().loadRoundImage(imageView, url, 20);
        }
    }

    @BindingAdapter("android:src")
    public static void loadLocalDrawable(ImageView imageView, int resId) {
        imageView.setImageResource(resId);
    }
}

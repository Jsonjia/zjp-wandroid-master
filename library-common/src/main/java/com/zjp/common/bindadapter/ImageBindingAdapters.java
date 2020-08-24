package com.zjp.common.bindadapter;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.BindingAdapter;

import com.zjp.common.font.Font;
import com.zjp.common.utils.GlideUtil;

/**
 * Created by zjp on 2020/5/11 16:47
 */
public class ImageBindingAdapters {

    @BindingAdapter("loadImageUrl")
    public static void loadImage(AppCompatImageView imageView, String url) {
        if (!TextUtils.isEmpty(url)) {
            GlideUtil.getInstance().loadImage(imageView, url);
        }
    }

    @BindingAdapter("loadCircleImageUrl")
    public static void loadCircleImage(AppCompatImageView imageView, String url) {
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
    public static void loadLocalDrawable(AppCompatImageView imageView, int resId) {
        imageView.setImageResource(resId);
    }

    @BindingAdapter("desc")
    public static void setDesc(AppCompatTextView textView, String desc) {
        int firstSpace = desc.indexOf(" ");
        int secondSpace = desc.indexOf(" ", firstSpace + 1);
        String title = desc.substring(secondSpace + 1)
                .replace(",", "")
                .replace("：", "")
                .replace(" ", "");
        textView.setText(title);
    }

    @BindingAdapter("date")
    public static void setDate(AppCompatTextView textView, String desc) {
        int firstSpace = desc.indexOf(" ");
        int secondSpace = desc.indexOf(" ", firstSpace + 1);
        String time = desc.substring(0, secondSpace);
        textView.setText(time);
    }

    @BindingAdapter("select")
    public static void bindSelect(View v, boolean select) {
        v.setSelected(select);
    }

    /**
     * 设置字体
     */
    @BindingAdapter(value = {"textTypeFace"}, requireAll = false)
    public static void setTypeFace(AppCompatTextView textView, Font font) {
        try {
            Typeface typeface = Typeface.createFromAsset(textView.getContext().getAssets(), "font/" + font.getName());
            textView.setTypeface(typeface);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

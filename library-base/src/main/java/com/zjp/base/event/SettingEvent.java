package com.zjp.base.event;

/**
 * Created by zjp on 2020/7/12 16:51.
 */
public class SettingEvent {

    private boolean hideTopArticle;

    public boolean isHideTopArticle() {
        return hideTopArticle;
    }

    public void setHideTopArticle(boolean hideTopArticle) {
        this.hideTopArticle = hideTopArticle;
    }
}

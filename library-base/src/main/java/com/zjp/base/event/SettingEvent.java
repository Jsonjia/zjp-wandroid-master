package com.zjp.base.event;

/**
 * Created by zjp on 2020/7/12 16:51.
 */
public class SettingEvent {

    private boolean showTopArticle, showBanner;

    public boolean isShowTopArticle() {
        return showTopArticle;
    }

    public void setShowTopArticle(boolean showTopArticle) {
        this.showTopArticle = showTopArticle;
    }

    public boolean isShowBanner() {
        return showBanner;
    }

    public void setShowBanner(boolean showBanner) {
        this.showBanner = showBanner;
    }
}

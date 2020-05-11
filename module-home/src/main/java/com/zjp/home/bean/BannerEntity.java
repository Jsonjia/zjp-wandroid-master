package com.zjp.home.bean;

/**
 * Created by zjp on 2020/5/11 14:35
 */
public class BannerEntity {

    /**
     * desc : 享学~
     * id : 29
     * imagePath : https://wanandroid.com/blogimgs/942a5c62-ca87-4e7c-a93d-41ff59a15ba4.png
     * isVisible : 1
     * order : 0
     * title : 震惊！app为何会突然崩溃？？？
     * type : 0
     * url : https://mp.weixin.qq.com/s/Q7OSaginyxgVcjg9C7_BxA
     */

    private String desc;
    private int id;
    private String imagePath;
    private int isVisible;
    private int order;
    private String title;
    private int type;
    private String url;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(int isVisible) {
        this.isVisible = isVisible;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

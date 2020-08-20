package com.zjp.square.bean;

import com.zjp.common.bean.ArticleEntity;

import java.util.List;

/**
 * Created by zjp on 2020/8/20 22:18.
 */
public class NaviBean {

    private int cid;
    private String name;
    private List<ArticleEntity.DatasBean> articles;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ArticleEntity.DatasBean> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleEntity.DatasBean> articles) {
        this.articles = articles;
    }
}

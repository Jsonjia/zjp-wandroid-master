package com.zjp.mine.bean;

import com.zjp.common.bean.UserInfo;

import java.util.List;

/**
 * Created by zjp on 2020/7/15 22:31.
 */
public class Leaderboard {

    /**
     * curPage : 0
     * datas : [{"coinCount":18909,"level":190,"rank":"-29","userId":20382,"username":"g**eii"},{"coinCount":16343,"level":164,"rank":"-28","userId":3559,"username":"A**ilEyon"},{"coinCount":15915,"level":160,"rank":"-27","userId":29303,"username":"深**士"},{"coinCount":13474,"level":135,"rank":"-26","userId":2,"username":"x**oyang"},{"coinCount":10711,"level":108,"rank":"-25","userId":27535,"username":"1**08491840"},{"coinCount":10349,"level":104,"rank":"-24","userId":28694,"username":"c**ng0218"},{"coinCount":10107,"level":102,"rank":"-23","userId":3753,"username":"S**phenCurry"},{"coinCount":10095,"level":101,"rank":"-22","userId":29185,"username":"轻**宇"},{"coinCount":10061,"level":101,"rank":"-21","userId":12467,"username":"c**yie"},{"coinCount":9873,"level":99,"rank":"-20","userId":9621,"username":"S**24n"},{"coinCount":9832,"level":99,"rank":"-19","userId":1534,"username":"j**gbin"},{"coinCount":9778,"level":98,"rank":"-18","userId":28607,"username":"S**Brother"},{"coinCount":9777,"level":98,"rank":"-17","userId":14829,"username":"l**changwen"},{"coinCount":9766,"level":98,"rank":"-16","userId":7891,"username":"h**zkp"},{"coinCount":9707,"level":98,"rank":"-15","userId":12351,"username":"w**igeny"},{"coinCount":9638,"level":97,"rank":"-14","userId":27,"username":"y**ochoo"},{"coinCount":9591,"level":96,"rank":"-13","userId":26707,"username":"p**xc.com"},{"coinCount":9531,"level":96,"rank":"-12","userId":12331,"username":"R**kieJay"},{"coinCount":9488,"level":95,"rank":"-11","userId":7710,"username":"i**Cola7"},{"coinCount":9459,"level":95,"rank":"-10","userId":833,"username":"w**lwaywang6"},{"coinCount":9359,"level":94,"rank":"-9","userId":7809,"username":"1**23822235"},{"coinCount":9330,"level":94,"rank":"-8","userId":29076,"username":"f**ham"},{"coinCount":9117,"level":92,"rank":"-7","userId":2068,"username":"i**Cola"},{"coinCount":9105,"level":92,"rank":"-6","userId":4886,"username":"z**iyun"},{"coinCount":9048,"level":91,"rank":"-5","userId":7590,"username":"陈**啦啦啦"},{"coinCount":8786,"level":88,"rank":"-4","userId":2160,"username":"R**iner"},{"coinCount":8786,"level":88,"rank":"-3","userId":25128,"username":"f**wandroid"},{"coinCount":8786,"level":88,"rank":"-2","userId":25793,"username":"F**_2014"},{"coinCount":8700,"level":87,"rank":"-1","userId":25419,"username":"蔡**打篮球"},{"coinCount":8652,"level":87,"rank":"0","userId":3825,"username":"请**娃哈哈"}]
     * offset : -30
     * over : false
     * pageCount : 1522
     * size : 30
     * total : 45649
     */

    private int curPage;
    private int offset;
    private boolean over;
    private int pageCount;
    private int size;
    private int total;
    private List<UserInfo> datas;

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<UserInfo> getDatas() {
        return datas;
    }

    public void setDatas(List<UserInfo> datas) {
        this.datas = datas;
    }


}

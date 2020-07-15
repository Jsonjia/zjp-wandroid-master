package com.zjp.mine.bean;

/**
 * Created by zjp on 2020/7/15 22:31.
 */
public class Leaderboard {


    /**
     * coinCount : 11111
     * level : 111
     * rank : -11
     * userId : 11111
     * username : 15656007197
     */

    private int coinCount;
    private int level;
    private String rank;
    private int userId;
    private String username;

    public int getCoinCount() {
        return coinCount;
    }

    public void setCoinCount(int coinCount) {
        this.coinCount = coinCount;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

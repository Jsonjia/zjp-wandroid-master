package com.zjp.common.font;

/**
 * Created by zjp on 2020/08/13 13:38
 */
public enum Font {

    ROBOTO_MEDIUM("Roboto-Medium.ttf"),
    SOURCEHANSANSCN_MEDIUM("SourceHanSansCN-Medium.otf");

    private final String name;

    Font(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

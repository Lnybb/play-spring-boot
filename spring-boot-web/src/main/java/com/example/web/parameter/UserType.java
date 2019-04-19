package com.example.web.parameter;

import lombok.Getter;

/**
 * @author zyd
 * @date 2019/03/29
 */
public enum UserType {

    /**
     * toc
     */
    TOC("toc", "C端用户"),

    /**
     * tob
     */
    TOB("tob", "B端用户");

    @Getter
    private final String code;

    @Getter
    private final String description;

    UserType(String code, String description) {
        this.code = code;
        this.description = description;
    }

}

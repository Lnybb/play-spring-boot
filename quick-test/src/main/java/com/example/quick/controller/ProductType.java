package com.example.quick.controller;

import lombok.Getter;

/**
 * @author zyd
 * @date 2019/03/29
 */
public enum ProductType {

    /**
     * type1
     */
    TYPE1("1", "type1"),
    /**
     * type2
     */
    TYPE2("2", "type2"),
    /**
     * type3
     */
    TYPE3("3", "type3");

    @Getter
    private final String code;

    @Getter
    private final String description;

    ProductType(String code, String description) {
        this.code = code;
        this.description = description;
    }

}

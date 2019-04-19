package com.example.jpa.dao;

import lombok.Getter;

/**
 * @author zyd
 * @date 2019/04/18
 */
public enum GenderType {

    /**
     * 男性
     */
    MALE("男性", "M"),

    /**
     * 女性
     */
    FEMALE("女性", "F");

    @Getter
    private final String name;

    @Getter
    private final String code;

    public final static String TIPS_MATCH_FAILED = "无法根据传参匹配到性别 ";

    GenderType(String name, String code) {
        this.name = name;
        this.code = code;
    }

    static GenderType getByCode(String code) {
        for (GenderType genderType : GenderType.values()) {

            if (genderType.getCode().equals(code)) {
                return genderType;
            }

        }
        throw new IllegalArgumentException(TIPS_MATCH_FAILED + code);
    }

}

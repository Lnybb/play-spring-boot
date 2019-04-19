package com.example.mybatis.dao.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
public class Child {

    private String id;

    private String name;

    private Integer gender;

    private Date birthday;

    private BigDecimal coins;

    private BigDecimal cash;

    private Integer cardFavoriteNumber;

    private Date createdAt;

    private Date updatedAt;

    private Boolean isDeleted;

}
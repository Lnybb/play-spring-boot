package com.example.jpa.dao;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;

/**
 * @author zyd
 * @date 2019/04/04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Student extends BaseEntity {

    @Column(length = 20)
    private String name;

    @Convert(converter = GenderTypeConverter.class)
    private GenderType gender;

}

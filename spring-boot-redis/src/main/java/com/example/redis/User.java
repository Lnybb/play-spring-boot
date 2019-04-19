package com.example.redis;

import lombok.*;

import java.util.Date;

/**
 * @author zyd
 * @date 2018-12-20
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    private String id;

    private String phone;

    private Date gmtCreate;

}

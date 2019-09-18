package com.example.tk.mybatis.tx;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString
public class Account {

    @Id
    private String id;

    private String userId;

    private BigDecimal balance;

    private Date createTime;

    private Date updateTime;

}

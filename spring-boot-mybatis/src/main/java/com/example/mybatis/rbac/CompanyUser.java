package com.example.mybatis.rbac;

import lombok.Data;


@Data
public class CompanyUser {
    private String id;
    private String companyId;
    private String name;
    private String password;
}

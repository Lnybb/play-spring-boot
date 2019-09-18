package com.example.tk.mybatis.service;


import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.example.tk.mybatis.FeaturedGoodsMapper;
import com.example.tk.mybatis.TreeMapper;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.util.Properties;

public class Provider {
    public SqlSessionFactory getSqlSessionFactory() throws Exception {
        Properties properties = new Properties();
        properties.setProperty("driver", "com.mysql.jdbc.Driver");
//        properties.setProperty("url", "jdbc:mysql://47.93.184.21:26115/piggy_bank_test?serverTimezone=UTC&useTimezone=true&useUnicode=true&characterEncoding=UTF-8");
        properties.setProperty("url", "jdbc:mysql://47.93.184.21:26115/hupo_projects_example?serverTimezone=UTC&useTimezone=true&useUnicode=true&characterEncoding=UTF-8");
        properties.setProperty("username", "root");
        properties.setProperty("password", "hupo123");

        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new tk.mybatis.mapper.session.Configuration();
        configuration.setEnvironment(environment);

        PageInterceptor interceptor = new PageInterceptor();

        configuration.addInterceptor(interceptor);
        configuration.addMapper(FeaturedGoodsMapper.class);
        configuration.addMapper(TreeMapper.class);

        return new SqlSessionFactoryBuilder().build(configuration);
    }
}

package com.mengma.edu.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.mengma.edu.extend.annutations.transaction.EnableMyTransaction;
import com.mengma.edu.utils.C3p0Utils;
import com.mengma.edu.utils.DruidUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author fgm
 * @description 配置类，启动自定义事务
 * @date 2020-02-03
 ***/
@Configuration
@EnableMyTransaction //启动自定义事务
public class AppConfiguration {


    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager=new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean
    public DataSource dataSource(){

        return DruidUtils.getInstance();

        //return  C3p0Utils.getInstance();
    }



}

package com.mengma.edu.utils;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author fgm
 * @description
 * @date 2020-01-12
 ***/
public class DruidUtils {

    private DruidUtils(){
    }

    private static DruidDataSource druidDataSource = new DruidDataSource();


    static {
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/mengma_db");
        druidDataSource.setUsername("mengma");
        druidDataSource.setPassword("mengma");
    }

    public static DruidDataSource getInstance() {
        return druidDataSource;
    }

}

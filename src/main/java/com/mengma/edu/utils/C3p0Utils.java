package com.mengma.edu.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;

/**
 * @author fgm
 * @description  c3p0工具
 * @date 2020-02-19
 ***/
public class C3p0Utils {

    private C3p0Utils(){

    }
    private static ComboPooledDataSource dataSource=new ComboPooledDataSource();

    static {
        try {
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mengma_db");
            dataSource.setUser("mengma");
            dataSource.setPassword("mengma");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }



    }

    public static ComboPooledDataSource getInstance(){
        return dataSource;
    }



}

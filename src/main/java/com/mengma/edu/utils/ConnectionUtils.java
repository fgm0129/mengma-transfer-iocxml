package com.mengma.edu.utils;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author fgm
 * @description
 * @date 2020-01-12
 ***/
@Service(value = "connectionUtils")
public class ConnectionUtils {



    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>(); // 存储当前线程的连接


    public Connection getCurrentThreadConn() throws SQLException {

        Connection connection = threadLocal.get();
        if(connection == null) {
            // 从连接池拿连接并绑定到线程
            connection = DruidUtils.getInstance().getConnection();
            // 绑定到当前线程
            threadLocal.set(connection);
        }
        return connection;

    }
}

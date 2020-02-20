package com.mengma.edu.utils;

import java.sql.SQLException;

/**
 * @author fgm
 * @description
 * @date 2020-01-12
 ***/
public class TransactionManager {

    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * 开启手动事务控制
     * @throws SQLException
     */
    public void beginTransaction() throws SQLException {
        connectionUtils.getCurrentThreadConn().setAutoCommit(false);
    }

    /**
     * 提交事务
     * @throws SQLException
     */
    public void commit() throws SQLException {
        connectionUtils.getCurrentThreadConn().commit();
    }

    /**
     * 回滚事务
     * @throws SQLException
     */
    public void rollback() throws SQLException {
        connectionUtils.getCurrentThreadConn().rollback();
    }
}

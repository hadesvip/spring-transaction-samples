package com.kevin.jdbc.samples.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author kevin
 */
public final class DBConnUtils {

    /**
     * 数据库地址
     */
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/study?useUnicode=true&characterEncoding=utf8";

    /**
     * 数据库用户名
     */
    private static final String USER_NAME = "root";

    /**
     * 数据库密码
     */
    private static final String PASSWORD = "123456";

    /**
     * 数据库驱动类
     */
    private static final String DRIVER_CLASS = "org.h2.Driver";

    /**
     * 数据库连接
     */
    private static Connection connection = null;


    /**
     * 获取数据源连接
     */
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER_CLASS);
            connection = DriverManager.getConnection(JDBC_URL, USER_NAME, PASSWORD);
        } catch (Exception e) {
        }
        return connection;
    }


    public static void startTransaction() throws SQLException {
        if (connection != null && !connection.getAutoCommit()) {
            connection.setAutoCommit(false);
        }
    }


    /**
     * 提交事务
     */
    public static void commit() throws SQLException {
        if (connection != null && !connection.getAutoCommit()) {
            connection.commit();
        }
    }


    /**
     * 回滚事务
     */
    public static void rollback() throws SQLException {
        if (connection != null) {
            connection.rollback();
        }
    }

    /**
     * 关闭数据库链接
     *
     * @return
     */
    public static void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
    }


}

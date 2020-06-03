package com.huke.utils;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtil {
    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    DataSource dataSource;

    public ThreadLocal<Connection> getThreadLocal() {
        return threadLocal;
    }

    public void setThreadLocal(ThreadLocal<Connection> threadLocal) {
        this.threadLocal = threadLocal;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程上的连接
     */
    public Connection getThreadConnection(){
        //先从threadLocal上获取
        Connection connection = threadLocal.get();
        if(connection == null){
            try {
                connection = dataSource.getConnection();
                threadLocal.set(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  connection;
    }
}

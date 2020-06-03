package com.huke.utils;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

/**
 * 事务相关
 */
public class TransactionManager {
    @Autowired
    private  ConnectionUtil connectionUtil;

    /**
     * 开启事务
     */
    public  void beginTransaction(){
        try {
            connectionUtil.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 提交事务
     */
    public  void commit(){
        try {
            connectionUtil.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 回滚事务
     */
    public  void rollback(){
        try {
            connectionUtil.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 释放连接
     */
    public  void release(){
        try {
            connectionUtil.getThreadConnection().close(); //换回连接池中
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

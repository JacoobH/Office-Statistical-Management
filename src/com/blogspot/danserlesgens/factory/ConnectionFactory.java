package com.blogspot.danserlesgens.factory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.*;
import java.sql.*;
import java.util.Properties;


public class ConnectionFactory {
    private volatile static Connection conn;
    public static Connection getUniqueConnection() {
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/office_manager_JDBC_pool");
            conn = ds.getConnection();
        } catch (Exception e) {
            System.err.println("连接数据库错误:"+e.getMessage());
        }
        return conn;
    }
//    单例模式——双重校验锁（线程安全）
//    private volatile static Connection conn;

//    private ConnectionFactory() {}
//
//    public static Connection getUniqueConnection() {
//        if (conn == null) {
//            synchronized (ConnectionFactory.class) {
//                if (conn == null) {
//                    try {
//                        Class.forName("com.mysql.jdbc.Driver");
//                        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/xzldbgstjglxt","root","595525934");
//                    } catch (ClassNotFoundException e) {
//                        e.printStackTrace();
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//        return conn;
//    }
}

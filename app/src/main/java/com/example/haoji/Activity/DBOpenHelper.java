package com.example.haoji.Activity;

import android.util.Log;

import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by HAOJI on 2019/10/31.
 */


public class DBOpenHelper {

    private static String driver = "com.mysql.jdbc.Driver";//MySQL 驱动
//    private static String url = "jdbc:mysql://IP:3306/数据库";//MYSQL数据库连接Url
//    private static String url = "jdbc:mysql://192.168.0.18:3306/shot";
    private static String url = "jdbc:mysql://localhost:3306/shot?characterEncoding=utf-8";
    private static String user = "root";//用户名
    private static String password = "123456";//密码
//    public static boolean execute = false;

    /**
     * 连接数据库
     */

    public static void getConn() {
        Connection conn = null;
        try {
            Log.e("onClick","----=-=-------------------");
            Class.forName(driver);//获取MYSQL驱动
            conn = (Connection) DriverManager.getConnection(url, user, password);//获取连接
            String sql = "select id from user where id = 1;";
            Statement st=(Statement)conn.createStatement();
            boolean execute = st.execute(sql);
            Log.e("onClick","----conn--"+execute);
            conn.close();
            st.close();
        } catch (ClassNotFoundException e) {
//            execute=false;
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        return execute;
    }

    /**
     * 关闭数据库
     */

    public static void closeAll(Connection conn, PreparedStatement ps) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 关闭数据库
     */

    public static void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}


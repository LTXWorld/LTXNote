package com.ltx.jdbc;

import java.sql.*;

/**
 * ClassName: DBUtil
 * Package:com.ltx.jdbc
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/17 07:19
 * 封装方法
 */
public class DBUtil {
    /**
     * 工具类构造方法私有
     * 方法都是静态的，直接类名调用
     */
    private DBUtil(){

    }
    //静态代码块在类加载时执行，并且只执行一次,注册驱动只需要一次
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接对象
     * @return 返回连接对象
     * @throws SQLException
     */
    public static Connection getConnextion() throws SQLException {
            Connection conn = DriverManager.getConnection("xx", "3306", "");
            return conn;
    }

    /**
     * 关闭释放资源
     * @param conn
     * @param ps
     * @param rs
     */
    public static void close(Connection conn, Statement ps, ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if (ps!= null){
            try {
               ps.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}

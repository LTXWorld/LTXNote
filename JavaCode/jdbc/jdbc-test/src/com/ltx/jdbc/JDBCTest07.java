package com.ltx.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ClassName: JDBCTest07
 * Package:com.ltx.jdbc
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/17 06:41
 */
public class JDBCTest07 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306:ltx","root","333");
            String sql = "insert into dept(deptno,dname,loc) values(?,?,?)";
            //获取数据库操作对象
            ps = conn.prepareStatement(sql);
            ps.setInt(1,2);
            ps.setString(2,"xxx");
            ps.setString(3,"lll");
            //执行sql
            int count = ps.executeUpdate();
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (ps != null){
                try {
                    ps.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    ps.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}

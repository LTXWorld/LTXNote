package com.ltx.jdbc;

import javax.xml.stream.events.Comment;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * ClassName: JDBCTest06
 * Package:com.ltx.jdbc
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/15 15:01
 */
public class JDBCTest06 {
    public static void main(String[] args) {
        //初始化界面
        Map<String,String> userLoginInfo =  initUI();
        //验证用户
        boolean loginSuccess =  logIn(userLoginInfo);
        //
        System.out.println(loginSuccess ? "登录成功" : "登录失败");
    }

    /**
     * 表示用户登录是否成功，编写jdbc代码
     * @param userLoginInfo
     * @return
     */
    private static boolean logIn(Map<String, String> userLoginInfo) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String loginName = userLoginInfo.get("loginName");
        String loginPwd = userLoginInfo.get("loginPwd");
        boolean loginSuccess = false;
        //
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltx","root","iutaol123");
            //获取数据库操作对象
            stmt = conn.createStatement();
            //执行sql语句，小心sql注入，用户提供的关键字参与了编译
            String sql = "select * from t_user where loginName = '"+loginName+"' and loginPwd = '"+loginPwd+"' ";
            //以下代码将sql语句发给DBMS进行sql编译
            rs = stmt.executeQuery(sql);
            if (rs.next()){
                loginSuccess = true;//如果查到有内容即登录成功
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //
            if (rs != null){
                try {
                    rs.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (stmt != null){
                try {
                    stmt.close();
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
        return loginSuccess;//
    }

    /**
     * 初始化用户界面
     * @return 用户输入的用户名和密码
     */
    private static Map<String, String> initUI() {
        Scanner s = new Scanner(System.in);
        System.out.println("用户名");
        String username = s.nextLine();
        System.out.println("密码：");
        String password = s.nextLine();
        HashMap<String, String> userLoginInfo = new HashMap<>();
        userLoginInfo.put("loginName" , username);
        userLoginInfo.put("loginPwd", password);
        return userLoginInfo;
    }


}

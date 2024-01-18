package com.ltx.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * ClassName: JDBCTest08
 * Package:com.ltx.jdbc
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/17 07:00
 * sql脚本
 *  drop table if exists t_act;
 *  create table t_act(
 *      actno bigint,
 *      balance double(7,2)//
 *  );
 *  insert into t_act(actno,balance) values(111,20000);
 *  insert into t_act(actno,balance) values(222,0);
 *  commit;
 *  select * from t_act;
 */
public class JDBCTest08 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("xx","root","333");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

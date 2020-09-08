package cn.hit16.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DemoJDBC {
    public static void main(String[] args) throws Exception {
        //注册驱动包
        Class.forName("com.mysql.jdbc.Driver");

        //获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql:///mydb?useSSL=false", "root", "janshan123");

        //定义sql语句
        String sql = "select name from student where id=123";

        //获取执行sql的对象
        Statement stmt = conn.createStatement();

        //执行sql
        ResultSet resultSet = stmt.executeQuery(sql);

        //处理结果
        System.out.println(resultSet);

        //释放资源
        stmt.close();
        conn.close();
    }
}

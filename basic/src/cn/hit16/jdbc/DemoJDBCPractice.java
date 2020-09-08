package cn.hit16.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoJDBCPractice {
    public static void main(String[] args) {
        Connection connectionnn = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connectionnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false", "root", "janshan123");
            statement = connectionnn.createStatement();

            //String sql = "insert into student values(124,'小蓝','北京',null)";
            //String sql = "update student set address='上海' where id = 121";
            String sql = "delete from student where name='小蓝'";

            int count = statement.executeUpdate(sql);
            System.out.println("count=" + count);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (statement != null) {    //空指针判断
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            try {
                connectionnn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}

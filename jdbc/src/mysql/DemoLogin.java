package mysql;

import util.JDBCS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DemoLogin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入用户id：");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("输入密码：");
        String password = sc.nextLine();
        boolean flag = login(id, password);
        System.out.println(flag ? "登录成功" : "登录失败");

    }

    public static boolean login(int userid, String password) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCS.getConnection();
            statement = connection.createStatement();

            String sql = "select * from users where userid=" + userid + " and password='" + password + "'";
            System.out.println(sql);
            resultSet = statement.executeQuery(sql);
            return resultSet.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCS.close(resultSet,statement, connection);
        }
        return false;
    }
}


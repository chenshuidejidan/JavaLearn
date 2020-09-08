package mysql;

import util.JDBCS;

import java.sql.*;
import java.util.Scanner;

public class DemoLoginPrepareStatement {
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
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCS.getConnection();
            String sql = "select * from users where userid = ? and password = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userid);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();

            System.out.println(sql);

            return resultSet.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCS.close(resultSet,preparedStatement, connection);
        }
        return false;
    }
}

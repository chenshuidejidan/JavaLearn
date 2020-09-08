package mysql;

import util.JDBCS;

import java.sql.*;
import java.util.Scanner;

public class TransMoney {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("您的账户名：");
        String fromName = sc.next();
        System.out.println("对方的账户名：");
        String toName = sc.next();
        System.out.println("转账金额：");
        int toMoney = sc.nextInt();

        System.out.println(new TransMoney().transMoney(fromName, toName, toMoney));
    }

    public String transMoney(String fromName, String toName, int toMoney) {
        Connection connection = null;

        try {
            connection = JDBCS.getConnection();
            String sql1 = "select money from account where name = ?";
            String sql2 = "select money from account where name = ?";

            PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
            PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);

            preparedStatement1.setString(1, fromName);
            preparedStatement2.setString(1, toName);


            String sql3 = "update account set money = ? where name = ?";
            String sql4 = "update account set money = ? where name = ?";
            PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);
            PreparedStatement preparedStatement4 = connection.prepareStatement(sql4);

            preparedStatement3.setString(2, fromName);
            preparedStatement4.setString(2, toName);


            //开启事务
            connection.setAutoCommit(false);

            ResultSet resultSet1 = preparedStatement1.executeQuery();
            ResultSet resultSet2 = preparedStatement2.executeQuery();
            //查
            int leftMoneyFrom = 0;
            int leftMoneyTo = 0;
            if (resultSet1.next()) {
                leftMoneyFrom = resultSet1.getInt("money");
            } else {
                return "用户名有误";
            }

            if (resultSet2.next()) {
                leftMoneyTo = resultSet2.getInt("money");
            } else {
                return "用户名有误";
            }

            if (leftMoneyFrom > toMoney) {
                preparedStatement3.setInt(1, leftMoneyFrom - toMoney);
                preparedStatement4.setInt(1, leftMoneyTo + toMoney);
                preparedStatement3.executeUpdate();
                preparedStatement4.executeUpdate();

                connection.commit();
                return "成功转账" + toMoney + "元,您的余额更新为" + (leftMoneyFrom - toMoney) + "元";
            } else {
                return "余额不足";
            }

        } catch (SQLException throwables) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return "转账失败";

    }
}

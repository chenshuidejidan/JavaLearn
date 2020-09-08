package dataSource;

import util.JDBCDataSources;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DemoDruidUtil {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JDBCDataSources.getConnection();

            String sql = "insert into student values(null, ?, ?, null)";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, "小明");
            preparedStatement.setString(2, "北京");

            int i = preparedStatement.executeUpdate();

            String s = i>0?"增加成功":"增加失败";
            System.out.println(s);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            JDBCDataSources.close(preparedStatement, connection);
        }

    }
}

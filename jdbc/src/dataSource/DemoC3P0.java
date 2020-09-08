package dataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DemoC3P0 {
    public static void main(String[] args) throws SQLException {
        //获取数据库连池接对象
        DataSource dataSource = new ComboPooledDataSource("otherc3p0"); //无参时使用默认配置

        //获取数据库连接对象
        Connection connection = dataSource.getConnection();

        System.out.println(connection);
    }
}

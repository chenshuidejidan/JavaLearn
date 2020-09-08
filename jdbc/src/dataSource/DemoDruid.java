package dataSource;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.util.Properties;

public class DemoDruid {
    public static void main(String[] args) throws Exception {
        Reader rr = new FileReader("jdbc/src/druid.properties");
        Properties properties = new Properties();
        properties.load(rr);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }
}

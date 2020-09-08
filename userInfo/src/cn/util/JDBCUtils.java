package cn.util;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
* Druid 连接池工具类
* */
public class JDBCUtils {
    //成员变量 DataSource
    private static DataSource dataSource;

    static{
        //加载配置文件
        try {
            Properties properties = new Properties();
//            Reader reader = new FileReader("src/druid.properties");
//            properties.load(reader);


           properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));



            dataSource = DruidDataSourceFactory.createDataSource(properties);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //获取连接对象
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    //获取连接池
    public static DataSource getDataSource(){
        return dataSource;
    }

    //释放资源
    public static void close(ResultSet resultSet, Statement statement, Connection connection){
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        close(statement, connection);
    }


    public static void close(Statement statement, Connection connection){
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(connection != null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}

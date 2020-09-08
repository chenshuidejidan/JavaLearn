package util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCS {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    static { //静态代码块只在类加载的时候执行一次，读取相关的参数
        try {
            Properties pro = new Properties();  //创建Properties

            //获取src路径下文件
//            ClassLoader classLoader = JDBCS.class.getClassLoader();
//            URL resource = classLoader.getResource("jdbc.properties");
//            String path = resource.getPath();

            String path = "jdbc/src/jdbc.properities";
            //加载Properities的配置
            pro.load(new FileReader(path));
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");

            //注册驱动
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void close(Statement statement, Connection connection) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection) {

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        close(statement, connection);
    }
}

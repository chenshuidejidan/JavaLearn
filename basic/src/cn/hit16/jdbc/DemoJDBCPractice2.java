package cn.hit16.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DemoJDBCPractice2 {
    public static void main(String[] args) {
        List<Student> students = new DemoJDBCPractice2().findAll();
        System.out.println(students);
    }
    public List<Student> findAll(){
        Connection connection = null;
        Statement statement = null;
        List<Student> students = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false", "root", "janshan123");

            statement = connection.createStatement();

            String sql = "select * from student";

            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                Timestamp add_time = resultSet.getTimestamp("add_time");
                students.add(new Student(id, name, address, add_time));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return students;
        }
    }
}

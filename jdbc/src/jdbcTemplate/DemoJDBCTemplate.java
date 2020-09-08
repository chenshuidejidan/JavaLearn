package jdbcTemplate;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCDataSources;

import javax.sql.DataSource;
import java.util.List;

public class DemoJDBCTemplate {
    public static void main(String[] args) {

        //获取连接池对象
        DataSource dataSource = JDBCDataSources.getDataSource();

        //创建Jdbctemplate对象
        JdbcTemplate template = new JdbcTemplate(dataSource);

        String sql = "update student set address = ? where id = 121";
        //传入sql语句 和 参数
        template.update(sql, "北京");

        sql = "select * from student";
        List<Student> students = template.query(sql, new BeanPropertyRowMapper<Student>(Student.class));

        for(Student student:students){
            System.out.println(student);
        }
    }
}

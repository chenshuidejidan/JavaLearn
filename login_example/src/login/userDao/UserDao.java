package login.userDao;

import login.JDBCUtils;
import login.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    //创建Jdbctemplate对象
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public UserDao() {
    }

    public User check(User loginUser) {
        System.out.println("userdao.check......");
        String sql = "select username,password from users where username=?";

        try {
            User true_user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class), loginUser.getUsername());

            return true_user;
        } catch (DataAccessException e) {
            e.printStackTrace();
           return null;
        }

    }

//    public static void main(String[] args) {
//        System.out.println(new UserDao().check(new User("小", "xiaoming")));
//    }

}

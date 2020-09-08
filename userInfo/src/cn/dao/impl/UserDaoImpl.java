package cn.dao.impl;

import cn.dao.UserDao;
import cn.domain.PageBean;
import cn.domain.User;
import cn.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    //创建template对象，封装数据库连接池
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    //查询所有用户信息
    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        try {
            List users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addUser(User user) {
        String sql = "insert into users(name,gender,age,address,qq,email) values(?,?,?,?,?,?)";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());
    }


    @Override
    public void updateUser(User user) {
        String sql = "UPDATE users SET name=?,gender=?,age=?,address=?,qq=?,email=? where id=? ";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getId());
    }

    @Override
    public void deleteUser(User user) {
        String sql = "DELETE FROM users WHERE id=?";
        template.update(sql, user.getId());
    }

    @Override
    public User findUser(User user) {
        String sql = "SELECT * FROM users WHERE id=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getId());
    }

    @Override
    public int findTotalCount() {
        String sql = "SELECT count(*) FROM users ";
        return template.queryForObject(sql, Integer.class);
    }

    @Override
    public List<User> findByPage(PageBean<User> pb) {
        String sql = "SELECT * FROM users limit ?,?";
        return template.query(sql, new BeanPropertyRowMapper<User>(User.class), (pb.getCurrentPage() - 1) * pb.getRows(), pb.getRows());
    }

}

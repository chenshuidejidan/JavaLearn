package cn.dao.impl;

import cn.dao.AdminDao;
import cn.domain.Admin;
import cn.domain.User;
import cn.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class AdminDaoImpl implements AdminDao {
    //创建template对象，封装数据库连接池
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Admin checkAdmin(Admin admin) {
        String sql = "select username,password from admin where username=?";
        try{
            return template.queryForObject(sql, new BeanPropertyRowMapper<Admin>(Admin.class), admin.getUsername());
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

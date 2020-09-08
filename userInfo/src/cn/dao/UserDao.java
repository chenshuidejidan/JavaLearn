package cn.dao;

import cn.domain.PageBean;
import cn.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    void addUser(User user);
    void deleteUser(User user);
    void updateUser(User user);
    User findUser(User user);

    List<User> findByPage(PageBean<User> pb);

    int findTotalCount();
}

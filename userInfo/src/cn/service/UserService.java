package cn.service;

import cn.domain.PageBean;
import cn.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void addUser(User user);
    void deleteUser(User user);
    void updateUser(User user);
    User findUser(User user);
    PageBean<User> findAllByPage(PageBean<User> pb);
}

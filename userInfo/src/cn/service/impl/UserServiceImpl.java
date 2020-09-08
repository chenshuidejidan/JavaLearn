package cn.service.impl;

import cn.dao.UserDao;
import cn.dao.impl.UserDaoImpl;
import cn.domain.PageBean;
import cn.domain.User;
import cn.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User findUser(User user) {
        return userDao.findUser(user);
    }

    @Override
    public PageBean<User> findAllByPage(PageBean<User> pb) {
        if(pb.getRows()<=0){
            pb.setRows(5);
        }
        if(pb.getCurrentPage()<=0){
            pb.setCurrentPage(1);
        }

        pb.setList(userDao.findByPage(pb));

        int totalCount = userDao.findTotalCount();
        pb.setTotalCount(totalCount);

        pb.setTotalPage((int) Math.ceil((totalCount+0.0)/pb.getRows()));

        return pb;
    }
}

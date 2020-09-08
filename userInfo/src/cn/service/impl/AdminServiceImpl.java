package cn.service.impl;

import cn.dao.AdminDao;
import cn.dao.impl.AdminDaoImpl;
import cn.domain.Admin;
import cn.service.AdminService;

public class AdminServiceImpl implements AdminService {
    @Override
    public boolean checkAdmin(Admin admin) {
        Admin rightAdmin = new AdminDaoImpl().checkAdmin(admin);

        if(rightAdmin!=null && rightAdmin.getPassword().equals(admin.getPassword())){
            return true;
        }
        else{
            return false;
        }
    }
}

package com.hwua.jsp.serviceImpl;

import com.hwua.jsp.dao.UserDao;
import com.hwua.jsp.daoImpl.UserDaoImpl;
import com.hwua.jsp.entity.Users;
import com.hwua.jsp.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao dao = new UserDaoImpl();

    @Override
    public Users queryUserByName(String name) {
        return dao.queryUserByName(name);
    }

    @Override
    public int addUser(Users user) {
        return dao.addUser(user);
    }

    @Override
    public Users queryUserById(int id) {
        return dao.queryUserById(id);
    }

    @Override
    public Users queryUserByNameAndPwd(String username, String password) {
        return dao.queryUserByNameAndPwd(username,password);
    }

    @Override
    public List<Users> queryAllUser() {
        return dao.queryUser("");
    }
}

package com.hwua.jsp.service;

import com.hwua.jsp.entity.Users;

import java.util.List;

public interface UserService {

    public Users queryUserByNameAndPwd(String username, String password);

    public List<Users> queryAllUser();

    public Users queryUserById(int id);

    public int addUser(Users user);

    public Users queryUserByName(String name);

}

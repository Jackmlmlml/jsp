package com.hwua.jsp.dao;

import com.hwua.jsp.entity.Users;

import java.util.List;

public interface UserDao {

    public int addUser(Users user);



    public int changePwd(String username, String password);

    public Users queryUserByNameAndPwd(String username, String password);

    public List<Users> queryUser(String name);

    public int queryUserCount();

    public Users queryUserByName(String name);

    public Users queryUserById(int id);


}

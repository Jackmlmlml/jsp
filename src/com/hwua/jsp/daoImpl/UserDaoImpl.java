package com.hwua.jsp.daoImpl;

import com.hwua.jsp.dao.UserDao;
import com.hwua.jsp.entity.Users;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl extends CommonDao<Users> implements UserDao {


    @Override
    public Users queryUserById(int id) {
        String sql="select * from users where  id = ?";
        return queryForOne(sql,id);
    }

    @Override
    public Users queryUserByName(String name) {
        String sql="select * from users where username = ?";
        return queryForOne(sql,name);
    }

    @Override
    public int addUser(Users user) {
        String sql="insert into users values(null,?,?,?,?)";
        return commonUpdate(sql,user.getUsername(),user.getPassword(),user.getPassword(),user.getEmail());

    }

    @Override
    public int changePwd(String username, String password){
        String sql="update users set password= ? where username = ?";
        return commonUpdate(sql,password,username);
    }


    @Override
    public Users queryUserByNameAndPwd(String username, String password) {
        String sql="select * from users where username = ? and password = ?";
        return queryForOne(sql,username,password);
    }

    @Override
    public List<Users> queryUser(String name) {
        String sql="select * from users where username like CONCAT('%',?,'%')";
        return queryForList(sql,name);
    }

    @Override
    public int queryUserCount() {
        String sql="select count(*) as total from users";
        return queryForCount(sql);
    }

    @Override
    public Users getDataFromResultSet(ResultSet rs) {
        Users user= new Users();
        try{
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setPhone(rs.getString("phone"));
            user.setEmail(rs.getString("email"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}

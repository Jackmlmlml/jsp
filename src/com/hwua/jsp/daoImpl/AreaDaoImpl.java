package com.hwua.jsp.daoImpl;

import com.hwua.jsp.dao.AreaDao;
import com.hwua.jsp.entity.address;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class AreaDaoImpl extends CommonDao<Object> implements AreaDao {


    @Override
    public List<Map<String, Object>> queryAreaByPid(int pid) {
        String sql="select * from area where pid = ?";
        return queryForListMap(sql,pid);
    }

    @Override
    public List<Map<String, Object>> queryAddress() {
        String sql="select * from address ";
        return queryForListMap(sql);
    }

    @Override
    public int addArea(address address) {
        String sql="insert into address value(null,?,?,?,?,?,?)";
        return commonUpdate(sql,address.getShengid(),address.getShiid(),address.getQuid(),address.getDetail(),address.getShou(),address.getPhone());
    }

    @Override
    public Object getDataFromResultSet(ResultSet rs) {
        return null;
    }
}

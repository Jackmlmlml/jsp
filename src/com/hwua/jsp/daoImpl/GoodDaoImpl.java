package com.hwua.jsp.daoImpl;

import com.hwua.jsp.dao.GoodDao;
import com.hwua.jsp.entity.Good;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class GoodDaoImpl extends CommonDao<Good> implements GoodDao {

    @Override
    public Map<String, Object> queryGoodById(int id) {
        String sql="select * from good where id = ?";
        return queryForMap(sql,id);
    }

    @Override
    public List<Good> queryGoodPage(String keyword,int start, int pageSize) {
        String sql="select * from good where name like CONCAT('%',?,'%') limit ? , ?";
        return queryForList(sql,keyword,start,pageSize);
    }

    @Override
    public int queryGoodCount(String keyword) {
        String sql="select count(*) as total  from good where name like CONCAT('%',?,'%') ";
        return queryForCount(sql,keyword);
    }

    @Override
    public Good getDataFromResultSet(ResultSet rs) {
        Good good=new Good();
        try {
            good.setId(rs.getInt("id"));
            good.setName(rs.getString("name"));
            good.setPrice(rs.getDouble("price"));
            good.setImg(rs.getString("img"));
            good.setDetail(rs.getString("detail"));
            good.setType1(rs.getInt("type1"));
            good.setType2(rs.getInt("type2"));
            good.setKucun(rs.getInt("kucun"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return good;
    }
}

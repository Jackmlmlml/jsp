package com.hwua.jsp.daoImpl;

import com.hwua.jsp.dao.CarDao;
import com.hwua.jsp.entity.Car;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class CarDaoImpl extends CommonDao<Car>  implements CarDao {

    @Override
    public int updateCount(int carid, int count) {
        String sql="update car set counts=? where id = ?";
        return commonUpdate(sql,count,carid);
    }

    @Override
    public int delCarById(int id) {
        String sql="delete from car where id = ?";
        return commonUpdate(sql,id);
    }

    @Override
    public List<Map<String, Object>> queryCarByUserId(int userid) {
        String sql="select * from carview where userid = ?";
        return queryForListMap(sql,userid);
    }

    @Override
    public Map<String, Object> queryCarByUserAndGood(int userid, int goodid) {
        String sql="select * from car where userid = ?  and goodid = ?";
        return queryForMap(sql,userid,goodid);
    }

    @Override
    public int addCar(Car car) {
        String sql="insert into car values(null,?,?,?)";
        return commonUpdate(sql,car.getUserid(),car.getGoodid(),car.getCounts());
    }

    @Override
    public int updateCar(Car car) {
        String sql="update car set counts=counts+? where userid = ? and goodid = ?";
        return commonUpdate(sql,car.getCounts(),car.getUserid(),car.getGoodid());
    }

    @Override
    public Car getDataFromResultSet(ResultSet rs) {
        return null;
    }
}

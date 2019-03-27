package com.hwua.jsp.serviceImpl;

import com.hwua.jsp.dao.CarDao;
import com.hwua.jsp.daoImpl.CarDaoImpl;
import com.hwua.jsp.entity.Car;
import com.hwua.jsp.service.CarService;

import java.util.List;
import java.util.Map;

public class CarServiceImpl implements CarService {

    private CarDao carDao = new CarDaoImpl();

    @Override
    public int updateCount(int carid, int count) {

        return carDao.updateCount(carid,count);
    }

    @Override
    public int addCar(Car car) {
        Map<String, Object> map = carDao.queryCarByUserAndGood(car.getUserid(), car.getGoodid());
        int a = 0;
        if (map == null) {
            a = carDao.addCar(car);
        } else {
            a = carDao.updateCar(car);
        }
        return a;
    }

    @Override
    public int delCarById(int id) {
        return carDao.delCarById(id);
    }

    @Override
    public List<Map<String, Object>> queryCarByUserId(int userid) {
        return carDao.queryCarByUserId(userid);
    }
}

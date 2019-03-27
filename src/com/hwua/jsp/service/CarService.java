package com.hwua.jsp.service;

import com.hwua.jsp.entity.Car;

import java.util.List;
import java.util.Map;

public interface CarService {

    public int addCar(Car car);

    public List<Map<String,Object>> queryCarByUserId(int userid);

    public int delCarById(int id);

    public int updateCount(int carid, int count);

}

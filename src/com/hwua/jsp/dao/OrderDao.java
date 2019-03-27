package com.hwua.jsp.dao;

import com.hwua.jsp.entity.Car;
import com.hwua.jsp.entity.OrderDetail;
import com.hwua.jsp.entity.Orders;

import java.util.List;
import java.util.Map;

public interface OrderDao {


    public int addOrder(Orders orders);

    public int addOrderDetail(OrderDetail detail);

    public List<Map<String,Object>> queryByUserid(int userid);

    public int updateStatus(String status, int id);




}

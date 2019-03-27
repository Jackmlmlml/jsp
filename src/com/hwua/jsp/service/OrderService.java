package com.hwua.jsp.service;

import com.hwua.jsp.entity.OrderDetail;
import com.hwua.jsp.entity.Orders;

import java.util.List;
import java.util.Map;

public interface OrderService {

    public int addOrder(Orders order, List<OrderDetail> details, int[] carids);

    public List<Map<String,Object>> queryByUserid(int userid);

    public int update(String status, int id);

}

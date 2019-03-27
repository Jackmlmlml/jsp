package com.hwua.jsp.serviceImpl;

import com.hwua.jsp.dao.CarDao;
import com.hwua.jsp.dao.OrderDao;
import com.hwua.jsp.daoImpl.CarDaoImpl;
import com.hwua.jsp.daoImpl.OrderDaoImpl;
import com.hwua.jsp.entity.OrderDetail;
import com.hwua.jsp.entity.Orders;
import com.hwua.jsp.service.OrderService;

import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao= new OrderDaoImpl();

    private CarDao carDao = new CarDaoImpl();

    private Orders orders=new Orders();

    @Override
    public int addOrder(Orders order, List<OrderDetail> details, int[] carids) {
        int a=0;
        int orderid=orderDao.addOrder(order);
        for(OrderDetail detail:details){
            detail.setOrderid(orderid);
            a+=orderDao.addOrderDetail(detail);
        }
        for(int carid:carids){
            a+=carDao.delCarById(carid);
        }
        return a;
    }

    @Override
    public List<Map<String,Object>> queryByUserid(int userid) {
        return orderDao.queryByUserid(userid);
    }

    @Override
    public int update(String status,int id) {
        return orderDao.updateStatus(status,id);
    }
}

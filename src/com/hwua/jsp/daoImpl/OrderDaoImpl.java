package com.hwua.jsp.daoImpl;

import com.hwua.jsp.dao.OrderDao;
import com.hwua.jsp.entity.OrderDetail;
import com.hwua.jsp.entity.Orders;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class OrderDaoImpl extends CommonDao<Orders> implements OrderDao {



    @Override
    public int addOrder(Orders orders) {
        String sql="insert into orders values(null,?,?,?,?,?,?)";
        return insertAndReturnId(sql,orders.getUserid(),orders.getCreateDate(),orders.getCode(),orders.getStatus(),orders.getTotal(),orders.getAddressid());
    }

    @Override
    public int addOrderDetail(OrderDetail detail) {
        String sql="insert into orderdetail values(null,?,?,?,?)";
        return commonUpdate(sql,detail.getOrderid(),detail.getGoodid(),detail.getPrice(),detail.getCount());
    }

    @Override
    public List<Map<String,Object>> queryByUserid(int userid) {
        String sql="select * from orders where userid=?";
        return queryForListMap(sql,userid);
    }

    @Override
    public int updateStatus(String status,int id) {
        String sql="update orders set status=? where id=?";
        return commonUpdate(sql,status,id);
    }



    @Override
    public Orders getDataFromResultSet(ResultSet rs) {
        return null;
    }
}

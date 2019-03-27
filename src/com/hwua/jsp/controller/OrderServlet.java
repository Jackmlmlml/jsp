package com.hwua.jsp.controller;

import com.alibaba.fastjson.JSONObject;
import com.hwua.jsp.entity.Car;
import com.hwua.jsp.entity.OrderDetail;
import com.hwua.jsp.entity.Orders;
import com.hwua.jsp.service.CarService;
import com.hwua.jsp.service.OrderService;
import com.hwua.jsp.serviceImpl.CarServiceImpl;
import com.hwua.jsp.serviceImpl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/process/order")
public class OrderServlet extends CommonServlet{

    private OrderService service= new OrderServiceImpl();


    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double total=getDouble("total",req);
        String[] _goodids=req.getParameterValues("goodids");
        String[] _counts=req.getParameterValues("counts");
        String[] _prices=req.getParameterValues("prices");
        String[] _carids=req.getParameterValues("carids");
        int len=_goodids.length;
        int[] goodids= new int[len];
        int[] counts= new int[len];
        int[] carids= new int[len];
        double[] prices= new double[len];
        int userid=(int)req.getSession().getAttribute("userid");
        String code=UUID.randomUUID().toString();
        Orders orders= new Orders(null,userid,new Date(),code,total,"1",1);
        List<OrderDetail> details= new ArrayList<OrderDetail>();
        OrderDetail detail=null;
        for(int i=0;i<len; i++){
            goodids[i]=Integer.parseInt(_goodids[i]);
            counts[i]=Integer.parseInt(_counts[i]);
            prices[i]=Double.parseDouble(_prices[i]);
            carids[i]=Integer.parseInt(_carids[i]);
            detail= new OrderDetail(null,goodids[i],null,counts[i],prices[i]);
            details.add(detail);
        }

        int a=service.addOrder(orders,details,carids);
        JSONObject obj= new JSONObject();
        if(a>0){
            obj.put("success",true);
            obj.put("info","订单创建成功，您可以去我的订单进行支付");
        }else{
            obj.put("success",false);
            obj.put("info","网络异常，请稍后再试");
        }
        outputJSON(resp,obj.toJSONString());
    }

    public void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userid=(int)req.getSession().getAttribute("userid");
        List<Map<String,Object>> orders=service.queryByUserid(userid);
        req.setAttribute("orders",orders);

        req.getRequestDispatcher("/WEB-INF/view/order.jsp").forward(req,resp);

    }
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=getInt("orderid",req);
        String status=req.getParameter("status");

        int a=service.update(status,id);
        JSONObject obj= new JSONObject();
        if(a==1){
            obj.put("success",true);
            obj.put("info","确认操作");
        }else{
            obj.put("success",false);
            obj.put("info","网络出错，请重试");
        }
        outputJSON(resp,obj.toJSONString());
    }



}

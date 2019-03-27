package com.hwua.jsp.controller;

import com.alibaba.fastjson.JSONObject;
import com.hwua.jsp.entity.Car;
import com.hwua.jsp.entity.Good;
import com.hwua.jsp.service.CarService;
import com.hwua.jsp.service.GoodService;
import com.hwua.jsp.serviceImpl.CarServiceImpl;
import com.hwua.jsp.serviceImpl.GoodServiceImpl;
import com.hwua.jsp.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/process/car")
public class CarServlet extends CommonServlet{

    private CarService service= new CarServiceImpl();

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int goodid=getInt("goodid",req);
        int counts=getInt("counts",req);
        int userid=(int)req.getSession().getAttribute("userid");
        Car car=  new Car(null,userid,goodid,counts);
        int a=service.addCar(car);
        JSONObject obj= new JSONObject();
        if(a==1){
            obj.put("success",true);
            obj.put("info","添加购物车成功！您可以去我的购物车查看");
        }else{
            obj.put("success",false);
            obj.put("info","网络异常，请稍后再试");
        }
        outputJSON(resp,obj.toJSONString());
    }

    public void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userid=(int)req.getSession().getAttribute("userid");
        List<Map<String,Object>> cars=service.queryCarByUserId(userid);
        req.setAttribute("cars",cars);

        req.getRequestDispatcher("/WEB-INF/view/car.jsp").forward(req,resp);

    }

    public void del(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int carid=getInt("carid",req);
        int a=service.delCarById(carid);
        JSONObject obj= new JSONObject();
        if(a==1){
            obj.put("success",true);
            obj.put("info","删除成功");
        }else{
            obj.put("success",false);
            obj.put("info","网络异常，请稍后再试");
        }
        outputJSON(resp,obj.toJSONString());
    }


    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int carid=getInt("carid",req);
        int count=getInt("count",req);
        int a=service.updateCount(carid,count);
        JSONObject obj= new JSONObject();
        if(a==1){
            obj.put("success",true);
            obj.put("info","删除成功");
        }else{
            obj.put("success",false);
            obj.put("info","网络异常，请稍后再试");
        }
        outputJSON(resp,obj.toJSONString());
    }


}

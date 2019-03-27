package com.hwua.jsp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hwua.jsp.entity.Car;
import com.hwua.jsp.entity.OrderDetail;
import com.hwua.jsp.entity.Orders;
import com.hwua.jsp.entity.address;
import com.hwua.jsp.service.AreaService;
import com.hwua.jsp.serviceImpl.AreaServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/process/area")
public class AreaServlet extends CommonServlet {

    private AreaService service= new AreaServiceImpl();

    public void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pid=Integer.parseInt(req.getParameter("pid"));
        List<Map<String,Object>> list=service.queryAreaByPid(pid);
        String result=JSONArray.toJSONString(list);
        outputJSON(resp,result);
    }
    public void queryUserid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Map<String,Object>> address=service.queryAddress();
        req.setAttribute("address",address);

        req.getRequestDispatcher("/WEB-INF/view/address.jsp").forward(req,resp);
    }
//    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int shengid=getInt("shengid",req);
//        int shiid=getInt("shiid",req);
//        int quid=getInt("quid",req);
//        String detail=req.getParameter("detail");
//        String shou=req.getParameter("shou");
//        String phone=req.getParameter("phone");
//        address address=new address(null,shengid,shiid,quid,detail,shou,phone);
//        int a=service.addAddress(address);
//        JSONObject obj= new JSONObject();
//        if(a==1){
//            obj.put("success",true);
//            obj.put("info","添加地址成功！您可以去我的地址查看");
//        }else{
//            obj.put("success",false);
//            obj.put("info","网络异常，请稍后再试");
//        }
//        outputJSON(resp,obj.toJSONString());
//    }
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String shengid=req.getParameter("shengid");
        String quid=req.getParameter("quid");
        String shiid=req.getParameter("shiid");
        String detail=req.getParameter("detail");
        String shou=req.getParameter("shou");
        String phone=req.getParameter("phone");
        address address= new address(null,shengid,shiid,quid,detail,shou,phone);
        int a=service.addAddress(address);
        JSONObject obj= new JSONObject();
        if(a>0){
            obj.put("success",true);
            obj.put("info","地址添加成功，您可以去我的收货地址进行查看");
        }else{
            obj.put("success",false);
            obj.put("info","网络异常，请稍后再试");
        }
        outputJSON(resp,obj.toJSONString());
    }
}

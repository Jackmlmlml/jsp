package com.hwua.jsp.controller;

import com.alibaba.fastjson.JSONObject;
import com.hwua.jsp.entity.Users;
import com.hwua.jsp.service.UserService;
import com.hwua.jsp.serviceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends CommonServlet {

    public void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //第一步接受参数
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String email=req.getParameter("email");
        String phone=req.getParameter("phone");
        Users user=  new Users(null,username,password,phone,email);
        //调用相关的业务逻辑
        JSONObject obj= new JSONObject();
        UserService service= new UserServiceImpl();
        Users uu=service.queryUserByName(username);
        if(uu!=null){
            obj.put("success",false);
            obj.put("info","用户名重复");
        }else{
            int a=service.addUser(user);
            if(a==1){
                obj.put("success",true);
                obj.put("info","操作成功！");
            }else{
                obj.put("success",false);
                obj.put("info","网络异常，请稍后再试！");
            }
        }
        //返回结果
        outputJSON(resp,obj.toJSONString());

    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        UserService service=new UserServiceImpl();
        JSONObject obj= new JSONObject();
        Users user=service.queryUserByNameAndPwd(username,password);
        if(user==null){
            obj.put("success",false);
            obj.put("info","用户名或者密码错了");
        }else{
            HttpSession session=req.getSession();
            session.setAttribute("username",username);
            session.setAttribute("userid",user.getId());
            obj.put("success",true);
            obj.put("info","登录成功！");
        }
        outputJSON(resp,obj.toJSONString());
    }

    public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        session.invalidate();
        resp.sendRedirect(req.getContextPath()+"/login1.jsp");
    }

}

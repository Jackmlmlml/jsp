package com.hwua.jsp.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class CommonServlet extends HttpServlet {



    public int getInt(String name,HttpServletRequest req){
        String value=req.getParameter(name);
        if(value==null){
            return 0;
        }else{
            return Integer.parseInt(value);
        }
    }

    public double getDouble(String name,HttpServletRequest req){
        String value=req.getParameter(name);
        if(value==null){
            return 0.0;
        }else{
            return Double.parseDouble(value);
        }
    }

    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        System.out.println("要执行的方法："+action);
        if(action==null){
            throw new ServletException("参数action未定义");
        }else{
            try {
                Method method=this.getClass().getMethod(action,HttpServletRequest.class,HttpServletResponse.class);
                method.invoke(this,req,resp);
            } catch (Exception e) {
                System.out.println("方法"+action+"未定义");
                e.printStackTrace();
            }
        }
    }

    public void outputJSON(HttpServletResponse response,String data){
        response.setContentType("text/html;charset=UTF-8");
        try {
            response.getWriter().write(data);
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

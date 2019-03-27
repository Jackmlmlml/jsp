package com.hwua.jsp.controller;

import com.alibaba.fastjson.JSONObject;
import com.hwua.jsp.entity.Good;
import com.hwua.jsp.service.GoodService;
import com.hwua.jsp.serviceImpl.GoodServiceImpl;
import com.hwua.jsp.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/good")
public class GoodServlet extends CommonServlet{

    private GoodService service= new GoodServiceImpl();

    public void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page=1,pageSize=10;
        String keyword=req.getParameter("keyword");
        if(req.getParameter("page")!=null){
            String pp=req.getParameter("page");
            page=Integer.parseInt(pp);
        }
        if(req.getParameter("pageSize")!=null){
            String ps=req.getParameter("pageSize");
            pageSize=Integer.parseInt(ps);
        }
        int total=service.queryGoodCount(keyword);
        int end=total%pageSize==0?(total/pageSize):((total/pageSize)+1);
        if(page>end || page<1){
            page=1;
        }
        List<Good> goods=service.queryGoodPage(keyword,page,pageSize);
        PageUtil pu= new PageUtil(page,pageSize,total,goods);
        String result=JSONObject.toJSONString(pu);
        outputJSON(resp,result);

    }

    public void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int goodid=getInt("goodid",req);
        Map<String,Object> good=service.queryGoodById(goodid);
        req.setAttribute("good",good);
        req.getRequestDispatcher("/detail.jsp").forward(req,resp);

    }

}

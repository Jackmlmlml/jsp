package com.hwua.jsp.filter;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        HttpSession session=request.getSession();
        if(session.getAttribute("username")==null){
            String ajax=request.getHeader("X-Requested-With");
            if(ajax==null){
                response.sendRedirect(request.getContextPath()+"/login.jsp");
            }else{
                JSONObject obj= new JSONObject();
                obj.put("success",false);
                obj.put("info","您尚未登录，请先登录");
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().write(obj.toJSONString());
                response.getWriter().close();
            }

        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}

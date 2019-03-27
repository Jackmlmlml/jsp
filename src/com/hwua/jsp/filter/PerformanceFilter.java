package com.hwua.jsp.filter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
public class PerformanceFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long start=System.currentTimeMillis();
        HttpServletRequest request= (HttpServletRequest)servletRequest;
        filterChain.doFilter(servletRequest,servletResponse);
        long end=System.currentTimeMillis();
        request.getServletPath();
        System.out.println("访问"+request.getServletPath()+"共耗时"+(end-start)+"ms");
    }

    @Override
    public void destroy() {

    }
}

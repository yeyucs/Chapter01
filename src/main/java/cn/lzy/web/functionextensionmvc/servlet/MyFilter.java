package cn.lzy.web.functionextensionmvc.servlet;

import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter(value = {"/antionLogin","/antionMyFilter"})
@Component
public class MyFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws SecurityException {
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("hello MyFilter");
//        filterChain.doFilter(servletRequest,servletResponse);
    }
    @Override
    public void destroy(){ }
}


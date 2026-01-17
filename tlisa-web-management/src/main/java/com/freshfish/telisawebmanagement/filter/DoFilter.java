package com.freshfish.telisawebmanagement.filter;

import com.freshfish.telisawebmanagement.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebFilter("/*")
public class DoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String uri = request.getRequestURI();
        if(uri.contains("login")){
            filterChain.doFilter(servletRequest,servletResponse);
            log.info("拦截到了请求,登录请求，放行");
            return;
        }
        String token = request.getHeader("token");
        if(token == null || token.isEmpty()){
            log.info("拦截到了请求,未登录");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401
            return;

        }
        try{
            log.info("拦截到了请求,已登录");
            JwtUtils.validateToken(token);
        } catch (Exception e) {
            log.info("拦截到了请求,登录失败");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401
        }

        log.info("拦截到了请求,已登录");
        filterChain.doFilter(servletRequest,servletResponse);

    }
}

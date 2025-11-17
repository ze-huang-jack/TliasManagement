package com.zehuang.filter;

import com.zehuang.utils.CurrentHolder;
import com.zehuang.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
@Slf4j
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String url = request.getRequestURL().toString();

        if(url.contains("login")){
            log.info("登录请求 , 直接放行");
            filterChain.doFilter(request, response);
            return;
        }

        String jwt = request.getHeader("token");
        if(StringUtils.isBlank(jwt)){
            log.info("获取到jwt令牌为空, 返回错误结果");
            response.setStatus(HttpStatus.SC_UNAUTHORIZED);
            return;
        }

        try {
            Claims claims = JwtUtils.parseJwt(jwt);
            Integer empId = Integer.valueOf(claims.get("id").toString());
            CurrentHolder.setCurrentId(empId);
            log.info("token解析成功, 放行");
        } catch (JwtException e) {
            log.info("解析令牌失败, 返回错误结果");
            response.setStatus(HttpStatus.SC_UNAUTHORIZED);
            return;
        }

        log.info("令牌合法, 放行");
        filterChain.doFilter(request , response);

        CurrentHolder.removeCurrentId();
    }
}

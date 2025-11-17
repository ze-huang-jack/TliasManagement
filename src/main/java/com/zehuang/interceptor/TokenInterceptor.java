package com.zehuang.interceptor;

import com.zehuang.utils.CurrentHolder;
import com.zehuang.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Slf4j
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       String uri = request.getRequestURI().toString();
       if(uri.contains("/login")) {
           log.info("登录请求，直接放行！");
           return true;
       }
       String jwt = request.getHeader("token");
       if(StringUtils.isBlank(jwt)) {
           log.info("获取到的jwt令牌为空，返回错误结果！");
           response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
           return false;
       }
       try{
           Claims claims = JwtUtils.parseJwt(jwt);
           Integer empId = Integer.valueOf(claims.get("id").toString());
           CurrentHolder.setCurrentId(empId);
           log.info("token解析成功, 放行");
       } catch (JwtException e) {
           response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
           return false;
       }
       log.info("令牌合法，放行");
       return true;
    }
}

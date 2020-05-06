package com.example.vhr.end.filter;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.lang.invoke.MethodType;
import java.util.HashMap;
import java.util.Map;

/**
 * @date:2020/5/5 9:39
 * @destription:
 */

public class LoginFilter extends UsernamePasswordAuthenticationFilter {
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)throws AuthenticationException{
        if(!request.getMethod().equals("POST")){
            throw new AuthenticationServiceException("Authentication method not supported:"+
                    request.getMethod());
        }
        String verifyCode= (String) request.getSession().getAttribute("verify_code");
        if(request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)){
            //解析请求的json字符串
            Map<String,String> loginData=new HashMap<>();
            try{
                loginData=new ObjectMapper().readValue(request.getInputStream(),Map.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                String code=loginData.get("code");
                checkCode(response,code,verifyCode);
            }
            String username=loginData.get(getUsernameParameter());
            String password=loginData.get(getPasswordParameter());
            username=username==null?"":username.trim();
            password=password==null?"":password;
            UsernamePasswordAuthenticationToken authRequest=new UsernamePasswordAuthenticationToken(username,password);
            setDetails(request,authRequest);
            return this.getAuthenticationManager().authenticate(authRequest);
        }
        else {
            checkCode(response,request.getParameter("code"),verifyCode);
            return super.attemptAuthentication(request,response);
        }
    }

    private void checkCode(HttpServletResponse response, String code, String verifyCode) {
        if(StringUtils.isEmpty(code)){
            throw new AuthenticationServiceException("验证码不能为空");
        }
        //验证码不区分大小写
        else if(!code.equalsIgnoreCase(verifyCode)){
            throw new AuthenticationServiceException("验证码错误");
        }
    }
}

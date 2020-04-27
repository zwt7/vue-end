package com.example.vhr.end.config;

import com.example.vhr.end.model.Hr;
import com.example.vhr.end.model.RespBean;
import com.example.vhr.end.service.HrService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @date:2020/4/16 8:47
 * @destription:
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private HrService hrService;
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
//        设置不进行密码加密
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        使用内存进行身份认证
       auth.userDetailsService(hrService);
    }
//    自定义用户访问控制
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()  //开启基于HttpServletRequest请求访问得限制
//                .antMatchers("/dba/**").hasRole("dba")
//                .antMatchers("/admin/**").hasRole("admin")
//                .antMatchers("/user/**").hasAnyRole("admin","user")
                .anyRequest().authenticated()  //其他请求登录之后都能访问
                .and()
                .formLogin()                               //表单登录
                .usernameParameter("username")     //这个是用于你想设置的名字，如果，你就是想要
                .passwordParameter("password")     //username和password就可以省略这两句话
                .loginProcessingUrl("/doLogin")
                .loginPage("/login")
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request,
                                                        HttpServletResponse response,
                                                        Authentication authentication)
                            throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter out=response.getWriter();
                        Hr hr= (Hr) authentication.getPrincipal();
                        hr.setPassword("");
                        RespBean ok=RespBean.ok("登录成功",hr);
                        out.write(new ObjectMapper().writeValueAsString(ok));
                        out.flush();
                        out.close();

                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request,
                                                        HttpServletResponse response,
                                                        AuthenticationException e)
                            throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter out=response.getWriter();
                        RespBean respBean=RespBean.error("登录失败");
                        if(e instanceof LockedException){
                            respBean.setMsg("账户被锁定,请联系管理员");
                        }
                        else if(e instanceof BadCredentialsException){
                            respBean.setMsg("用户名或密码错误，登录失败");
                        } else if(e instanceof DisabledException){
                            respBean.setMsg("账户被禁用，登录失败");
                        }else if(e instanceof AccountExpiredException){
                            respBean.setMsg("账户过期，登录失败");
                        }else if(e instanceof CredentialsExpiredException){
                            respBean.setMsg("密码过期，登录失败");
                        }
                        else{
                            respBean.setMsg("未知错误");
                        }
                        out.write(new ObjectMapper().writeValueAsString(respBean));
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()          //与登录相关的请求直接通过
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest request,
                                                HttpServletResponse response,
                                                Authentication authentication)
                            throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter out=response.getWriter();
                        out.write(new ObjectMapper().writeValueAsString(RespBean.ok("注销成功")));
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and()
                .csrf().disable();  //关闭防csrf攻击，用于postman测试
    }
}

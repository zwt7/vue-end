package com.example.vhr.end.controller;

import com.example.vhr.end.model.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @date:2020/4/20 9:59
 * @destription:
 */

@RestController
@ApiIgnore
public class LoginController {
    @GetMapping("/hello")
    public String hello(){
        return "hello security";
    }
    @GetMapping("/login")
    public RespBean login(){
            return RespBean.error("尚未登录，请登录");
    }
}

package com.example.vhr.end.controller.config;

import com.example.vhr.end.model.Menu;
import com.example.vhr.end.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @date:2020/4/22 9:44
 * @destription:
 */
@RestController
@Api(value = "SystemConfigController", tags={"下拉菜单管理接口"})
@RequestMapping("/system/config")
public class SystemConfigController {
    @Autowired
    MenuService menuService;

    @ApiOperation(value = "菜单管理")
    @GetMapping("/menu")
    public List<Menu> getMenusByHrId(){
        return  menuService.getMenusByHrId();
    }
}

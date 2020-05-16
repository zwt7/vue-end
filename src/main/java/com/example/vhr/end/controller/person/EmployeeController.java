package com.example.vhr.end.controller.person;

import com.example.vhr.end.model.*;
import com.example.vhr.end.service.person.DepartmentService;
import com.example.vhr.end.service.person.EmployeeService;
import com.example.vhr.end.service.person.NationService;
import com.example.vhr.end.service.person.PoliticsstatusService;
import com.example.vhr.end.service.system.basic.JoblevelService;
import com.example.vhr.end.service.system.basic.PositionService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @date:2020/5/13 13:37
 * @destription:
 */
@RestController
@Api(value ="EmployeeController",tags = {"员工信息访问接口"})
@RequestMapping("/person")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    NationService nationService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    PoliticsstatusService politicsstatusService;
    @Autowired
    JoblevelService joblevelService;
    @Autowired
    PositionService positionService;

//    @ApiOperation(value = "获取全部员工信息",notes = "获取全部员工信息")
//    @GetMapping("/")
//    public RespBean getAllEmployee(){
//        List<Employee> employees=employeeService.getAllEmployee();
//        return RespBean.ok("获取成功",employees);
//    }

    @ApiOperation(value = "分页获取员工信息",notes = "员工信息列表",produces = "application/json")
    @GetMapping("/")
    public RespPageBean getPersonByPage(@RequestParam(defaultValue = "1") Integer page,
                                        @RequestParam(defaultValue = "5") Integer size,
                                        Employee employee, Date[] beginDateScope){
        return employeeService.getEmployeeByPage(page,size,employee,beginDateScope);
    }

    @ApiOperation(value = "得到民族",notes = "根据已有的id得到数据库里没有明确给出的信息")
    @GetMapping("/nations")
    public List<Nation> getAllNations(){
        return nationService.getAllNation();
    }

    @ApiOperation(value = "得到部门",notes = "根据已有的id得到数据库里没有明确给出的信息")
    @GetMapping("/deps")
    public List<Department> getAllDeps(){
        return departmentService.getAllDep();
    }

    @ApiOperation(value = "得到职称",notes = "根据已有的id得到数据库里没有明确给出的信息")
    @GetMapping("/joblevels")
    public List<Joblevel> getAllJob(){
        return joblevelService.getAllJoblevel();
    }
    @ApiOperation(value = "得到职位",notes = "根据已有的id得到数据库里没有明确给出的信息")
    @GetMapping("/positions")
    public List<Position> getAllPos(){
        return positionService.getAllPosition();
    }

    @ApiOperation(value = "得到政治面貌",notes = "根据已有的id得到数据库里没有明确给出的信息")
    @GetMapping("/politicsstatus")
    public List<Politicsstatus> getAllPoliticsstatus(){
        return politicsstatusService.getAllPoliticsstatus();
    }




    @ApiOperation(value = "删除员工信息",notes = "根据员工id删除信息")
//    根据一个Id删除数据，要将这个id带上
    @DeleteMapping("/{id}")
    public RespBean deleteEmp(@PathVariable Integer id){
        //如果点击删除之后的话，就可以delete了
        if(employeeService.deleteEmployee(id)==1){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @ApiOperation(value = "删除多个员工信息",notes = "根据多选的员工id删除信息")
//    根据一个Id删除数据，要将这个id带上
    @DeleteMapping("/")
    public RespBean deleteEmp(Integer[] ids){
        //如果点击删除之后的话，就可以delete了
        if(employeeService.deleteEmpByIds(ids)==ids.length){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }


}

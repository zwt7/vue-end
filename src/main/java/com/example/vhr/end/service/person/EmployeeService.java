package com.example.vhr.end.service.person;

import com.example.vhr.end.mapper.EmployeeMapper;
import com.example.vhr.end.model.Employee;
import com.example.vhr.end.model.RespPageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @date:2020/5/13 13:34
 * @destription:
 */
@Service
public class EmployeeService {
    @Resource
    EmployeeMapper employeeMapper;

//    public List<Employee> getAllEmployee(){
//        return employeeMapper.getAllEmployee();
//    }

    public RespPageBean getEmployeeByPage(Integer page, Integer size, Employee employee, Date[] beginDateScope){
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Employee> data = employeeMapper.getEmployeeByPage(page, size, employee, beginDateScope);
        Long total = employeeMapper.getTotal(employee, beginDateScope);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }
    public Employee getAllEmployeeById(Integer empId){
        return employeeMapper.getAllEmployeeById(empId);
    }

    public Integer deleteEmployee(Integer id){
        return employeeMapper.deleteByPrimaryKey(id);
    }

    public Integer deleteEmpByIds(Integer[] ids){
        return employeeMapper.deleteByIds(ids);
    }
}

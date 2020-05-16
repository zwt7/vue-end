package com.example.vhr.end.service.person;

import com.example.vhr.end.mapper.DepartmentMapper;
import com.example.vhr.end.model.Department;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * @date:2020/5/14 14:27
 * @destription:
 */

@Service
public class DepartmentService {
    @Resource
    DepartmentMapper departmentMapper;

    public List<Department> getAllDep(){
        return departmentMapper.getAllDepartmentByParentId(-1);
    }
}

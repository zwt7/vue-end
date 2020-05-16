package com.example.vhr.end.mapper;

import com.example.vhr.end.model.Department;
import com.example.vhr.end.model.Nation;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> getAllDepartmentByParentId(Integer pid);
}
package com.example.vhr.end.mapper;

import com.example.vhr.end.model.Menu;
import com.example.vhr.end.model.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    @Select("select * from role")
    List<Role> getAllRoles();

    List<Menu> getAllMenus();
}
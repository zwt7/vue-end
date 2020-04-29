package com.example.vhr.end.service;

import com.example.vhr.end.mapper.RoleMapper;
import com.example.vhr.end.model.Menu;
import com.example.vhr.end.model.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @date:2020/4/29 12:28
 * @destription:
 */
@Service
public class RoleService {
    @Resource
    RoleMapper roleMapper;

    public List<Role> getAllRoles(){
        return roleMapper.getAllRoles();
    }

    public List<Menu> getAllMenus(){
        return roleMapper.getAllMenus();
    }

    public Integer addRole(Role role){
        if(!role.getName().startsWith("ROLE_")){
            role.setName("ROLE_"+role.getName());
        }
        return roleMapper.insert(role);
    }

    public Integer deleteRoleById(Integer rid){
        return roleMapper.deleteByPrimaryKey(rid);
    }
}

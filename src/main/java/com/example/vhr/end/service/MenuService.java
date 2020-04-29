package com.example.vhr.end.service;

import com.example.vhr.end.mapper.MenuMapper;
import com.example.vhr.end.mapper.MenuRoleMapper;
import com.example.vhr.end.model.Hr;
import com.example.vhr.end.model.Menu;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @date:2020/4/22 9:25
 * @destription:
 */
@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    MenuRoleMapper menuRoleMapper;

    public List<Menu> getMenusByHrId(){
        return menuMapper.getMenusByHrId(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }

    //
//    public List<Menu> getAllMenuWithRole(){
//        return menuMapper.getAllMenusWithRole();
//    }

    public List<Integer> getMidsByRid(Integer id){
        return menuMapper.getMidsByRid(id);
    }

    @Transactional
    public boolean updateMenuRole(Integer rid,Integer[] mids){
        menuRoleMapper.deleteByRid(rid);
        int num=menuRoleMapper.insertRecord(rid,mids);
        return num==mids.length;
    }
}

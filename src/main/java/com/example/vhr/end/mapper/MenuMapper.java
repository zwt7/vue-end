package com.example.vhr.end.mapper;

import com.example.vhr.end.model.Menu;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> getMenusByHrId(Integer id);

//    List<Menu> getAllMenusWithRole();

    @Select("select mid from menu_role where rid=#{id}")
    List<Integer> getMidsByRid(Integer id);
}
package com.example.vhr.end.mapper;

import com.example.vhr.end.model.MenuRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MenuRole record);

    int insertSelective(MenuRole record);

    MenuRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MenuRole record);

    int updateByPrimaryKey(MenuRole record);

    @Delete("delete from menu_role where rid=#{rid}")
    void deleteByRid(Integer rid);

    int insertRecord(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
}
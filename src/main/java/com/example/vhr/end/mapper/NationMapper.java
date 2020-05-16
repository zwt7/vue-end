package com.example.vhr.end.mapper;

import com.example.vhr.end.model.Nation;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Nation record);

    int insertSelective(Nation record);

    Nation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Nation record);

    int updateByPrimaryKey(Nation record);

    @Select("select * from nation")
    List<Nation> getAllNation();
}
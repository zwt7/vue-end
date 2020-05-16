package com.example.vhr.end.mapper;

import com.example.vhr.end.model.Nation;
import com.example.vhr.end.model.Politicsstatus;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PoliticsstatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Politicsstatus record);

    int insertSelective(Politicsstatus record);

    Politicsstatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Politicsstatus record);

    int updateByPrimaryKey(Politicsstatus record);

    @Select("select * from politicsstatus")
    List<Politicsstatus> getAllPoliticsstatus();
}
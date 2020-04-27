package com.example.vhr.end.mapper;

import com.example.vhr.end.model.Joblevel;
import com.example.vhr.end.model.Position;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface JoblevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Joblevel record);

    int insertSelective(Joblevel record);

    Joblevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Joblevel record);

    int updateByPrimaryKey(Joblevel record);

    @Select("select * from joblevel")
    List<Joblevel> selectAllJoblevel();

    Integer deleteByIds(Integer[] ids);
}
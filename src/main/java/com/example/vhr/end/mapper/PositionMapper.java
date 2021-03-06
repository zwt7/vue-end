package com.example.vhr.end.mapper;

import com.example.vhr.end.model.Position;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);

    @Select("select * from position")
    List<Position> selectAllposition();

    Integer deleteByIds(Integer[] ids);
}
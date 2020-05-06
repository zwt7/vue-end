package com.example.vhr.end.service.system.basic;

import com.example.vhr.end.mapper.PositionMapper;
import com.example.vhr.end.model.Position;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @date:2020/4/23 13:19
 * @destription:
 */

@Service
public class PositionService {
    @Resource
    PositionMapper positionMapper;

    public List<Position> getAllPosition(){
       return positionMapper.selectAllposition();
    }

    public PageInfo<Position> getPositionByPage(Integer page, Integer size){
        PageHelper.startPage(page,size);
        List<Position> positions=positionMapper.selectAllposition();
        return new PageInfo<>(positions,size);
    }

    public Integer addPosition(Position position){
        position.setEnabled(true);
        position.setCreatedate(new Date());
        return positionMapper.insertSelective(position);
    }
    public Integer updatePosition(Position position){
        return positionMapper.updateByPrimaryKeySelective(position);
    }

    public Integer deletePosition(Integer id){
        return positionMapper.deleteByPrimaryKey(id);
    }

    public Integer deletePosition(Integer[] ids){
        return positionMapper.deleteByIds(ids);
    }

    public int addPositions(List<Position> positions){
        return positionMapper.batchInsert(positions);
    }
}

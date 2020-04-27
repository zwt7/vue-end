package com.example.vhr.end.service.system.basic;

import com.example.vhr.end.mapper.JoblevelMapper;
import com.example.vhr.end.model.Joblevel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @date:2020/4/26 14:46
 * @destription:
 */
@Service
public class JoblevelService {
    @Resource
    JoblevelMapper joblevelMapper;

    public List<Joblevel> getAllJoblevel(){
        return joblevelMapper.selectAllJoblevel();
    }

    public Integer addJoblevel(Joblevel joblevel){
        //允许显示，，展示现在的时间
        joblevel.setEnabled(true);
        joblevel.setCreatedate(new Date());
        return joblevelMapper.insertSelective(joblevel);
    }

    public Integer deleteJoblevel(Integer id){
        return joblevelMapper.deleteByPrimaryKey(id);
    }

    public Integer deleteJoblevel(Integer[] ids){
        return joblevelMapper.deleteByIds(ids);
    }

    public Integer updateJoblevel(Joblevel joblevel){
        return joblevelMapper.updateByPrimaryKeySelective(joblevel);
    }
}

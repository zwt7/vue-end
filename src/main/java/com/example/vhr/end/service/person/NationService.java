package com.example.vhr.end.service.person;

import com.example.vhr.end.mapper.NationMapper;
import com.example.vhr.end.model.Nation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @date:2020/5/14 14:26
 * @destription:
 */
@Service
public class NationService {
    @Resource
    NationMapper nationMapper;

    public List<Nation> getAllNation(){
        return nationMapper.getAllNation();
    }
}

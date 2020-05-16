package com.example.vhr.end.service.person;

import com.example.vhr.end.mapper.PoliticsstatusMapper;
import com.example.vhr.end.model.Politicsstatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @date:2020/5/14 14:26
 * @destription:
 */
@Service
public class PoliticsstatusService {
    @Resource
    PoliticsstatusMapper politicsstatusMapper;

    public List<Politicsstatus> getAllPoliticsstatus(){
        return politicsstatusMapper.getAllPoliticsstatus();
    }
}

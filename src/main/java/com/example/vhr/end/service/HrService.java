package com.example.vhr.end.service;

import com.example.vhr.end.mapper.HrMapper;
import com.example.vhr.end.model.Hr;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @date:2020/4/16 13:35
 * @destription:
 */
@Service
public class HrService implements UserDetailsService {
    @Resource
    private HrMapper hrMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr= hrMapper.loadUserByUsername(username);
        if(hr==null){
            throw  new UsernameNotFoundException("用户不存在");
        }
        return  hr;
    }
}

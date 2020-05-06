package com.example.vhrapi.service;

import com.example.vhrapi.mapper.HrMapper;
import com.example.vhrapi.mapper.system.hr.HrRoleMapper;
import com.example.vhrapi.model.Hr;
import com.example.vhrapi.utils.HrUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HrService implements UserDetailsService {
    @Resource
    private HrMapper hrMapper;
    @Resource
    HrRoleMapper hrRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(username);
        if(hr == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        return hr;
    }
//操作员管理
    public List<Hr> getAllHrs(String keywords) {
        return hrMapper.getAllHrs(HrUtils.getCurrentHr().getId(),keywords);
    }
    public Integer updateHr(Hr hr) {
        return hrMapper.updateByPrimaryKeySelective(hr);
    }
    @Transactional
    public boolean updateHrRole(Integer hrid, Integer[] rids) {
        hrRoleMapper.deleteByHrid(hrid);
        return hrRoleMapper.addRole(hrid, rids) == rids.length;
    }
    public Integer deleteHrById(Integer id) {
        return hrMapper.deleteByPrimaryKey(id);
    }
}

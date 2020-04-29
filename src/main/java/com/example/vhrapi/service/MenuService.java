package com.example.vhrapi.service;

import com.example.vhrapi.mapper.MenuMapper;
import com.example.vhrapi.mapper.system.basic.permission.MenuRoleMapper;
import com.example.vhrapi.model.Hr;
import com.example.vhrapi.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;
    @Resource
    MenuRoleMapper menuRoleMapper;
    public List<Menu> getMenusByHrId() {
        return menuMapper.getMenusByHrId(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }
    public List<Menu> getAllMenusWithRole() {
        return menuMapper.getAllMenusWithRole();
    }

    public List<Integer> getMidsByRid(Integer id) {
        return menuMapper.getMidsByRid(id);
    }

    @Transactional
    public boolean updateMenuRole(Integer rid, Integer[] mids) {
        menuRoleMapper.deleteByRid(rid);
        int num = menuRoleMapper.insertRecord(rid, mids);
        return num == mids.length;
    }
}

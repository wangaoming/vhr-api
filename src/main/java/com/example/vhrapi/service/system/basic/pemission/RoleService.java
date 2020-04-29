package com.example.vhrapi.service.system.basic.pemission;

import com.example.vhrapi.mapper.system.basic.permission.RoleMapper;
import com.example.vhrapi.model.Menu;
import com.example.vhrapi.model.system.basic.permission.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleService {
    @Resource
    RoleMapper roleMapper;
    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    public List<Menu> getAllMenus() {
        return roleMapper.getAllMenus();
    }

    public Integer addRole(Role role) {
        if (!role.getName().startsWith("ROLE_")) {
            role.setName("ROLE_" + role.getName());
        }
        return roleMapper.insert(role);
    }

    public Integer deleteRoleById(Integer rid) {
        return roleMapper.deleteByPrimaryKey(rid);
    }
}

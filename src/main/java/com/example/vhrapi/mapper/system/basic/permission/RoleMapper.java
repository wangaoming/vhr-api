package com.example.vhrapi.mapper.system.basic.permission;

import com.example.vhrapi.model.Menu;
import com.example.vhrapi.model.system.basic.permission.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    @Select("select * from role")
    List<Role> getAllRoles();
    List<Menu> getAllMenus();
}
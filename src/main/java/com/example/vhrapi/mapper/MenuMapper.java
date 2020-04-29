package com.example.vhrapi.mapper;

import com.example.vhrapi.model.Menu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> getMenusByHrId(Integer id);
//权限管理
    List<Menu> getAllMenusWithRole();

    @Select("select mid from menu_role where rid=#{id}")
    List<Integer> getMidsByRid(Integer id);
}

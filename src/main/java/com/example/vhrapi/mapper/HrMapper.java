package com.example.vhrapi.mapper;

import com.example.vhrapi.model.Hr;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface HrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    @Select("select * from hr where username=#{username}")
    Hr loadUserByUsername(String username);

    List<Hr> getAllHrs(@Param("hrid") Integer hrid, @Param("keywords") String keywords);
}

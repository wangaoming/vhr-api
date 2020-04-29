package com.example.vhrapi.mapper.system.basic.joblevel;

import com.example.vhrapi.model.system.basic.joblevel.Joblevel;

import java.util.List;

public interface JoblevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Joblevel record);

    int insertSelective(Joblevel record);

    Joblevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Joblevel record);

    int updateByPrimaryKey(Joblevel record);
  

    List<Joblevel> getAllJobLevels();

    Integer deleteJobLevelsByIds(Integer[] ids);
}
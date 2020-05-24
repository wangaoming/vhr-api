package com.example.vhrapi.mapper.per;

import com.example.vhrapi.model.per.Employeereward;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmployeerewardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employeereward record);

    int insertSelective(Employeereward record);

    Employeereward selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employeereward record);

    int updateByPrimaryKey(Employeereward record);

    @Select("select * from employeereward")
    List<Employeereward> selectAllEmployeereward();
    Integer deleteByIds(Integer[] ids);
    Integer batchInsert(List<Employeereward> employeerewards);
}
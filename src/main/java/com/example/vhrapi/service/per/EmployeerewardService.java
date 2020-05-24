package com.example.vhrapi.service.per;

import com.example.vhrapi.mapper.per.EmployeerewardMapper;
import com.example.vhrapi.model.per.Employeereward;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class EmployeerewardService {
    @Resource
    EmployeerewardMapper employeerewardMapper;

    public List<Employeereward> getAllEmployeereward() {
        return employeerewardMapper.selectAllEmployeereward();
    }

    public Integer addEmployeereward(Employeereward employeereward) {
        employeereward.setEnabled(true);
        employeereward.setCreateDate(new Date());
        return employeerewardMapper.insert(employeereward);
    }
    //分页
    public PageInfo<Employeereward> getEmployeerewardByPage(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<Employeereward> employeerewards = employeerewardMapper.selectAllEmployeereward();
        return new PageInfo<>(employeerewards, size);
    }
    //导数据
    public Integer addEmployeereward(List<Employeereward> employeerewards) {
        return employeerewardMapper.batchInsert(employeerewards);
    }

    public Integer updateEmployeereward(Employeereward employeereward) {
        return employeerewardMapper.updateByPrimaryKeySelective(employeereward);
    }

    public Integer deleteEmployeereward(Integer id) {
        return employeerewardMapper.deleteByPrimaryKey(id);
    }
    public Integer deleteEmployeereward(Integer[] ids) {
        return employeerewardMapper.deleteByIds(ids);
    }


}

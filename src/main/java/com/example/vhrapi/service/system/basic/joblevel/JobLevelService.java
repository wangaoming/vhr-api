package com.example.vhrapi.service.system.basic.joblevel;

import com.example.vhrapi.mapper.system.basic.joblevel.JoblevelMapper;
import com.example.vhrapi.model.system.basic.joblevel.Joblevel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author ASUS
 */
@Service

public class JobLevelService {
    @Resource
    JoblevelMapper jobLevelMapper;
//    获取
    public List<Joblevel> getAllJobLevels(){
        return jobLevelMapper.getAllJobLevels();
    }
//    增加
    public Integer addJobLevel(Joblevel jobLevel){
        jobLevel.setCreateDate(new Date());
        jobLevel.setEnabled(true);
        return jobLevelMapper.insertSelective(jobLevel);
    }
//    更新
    public Integer updateJobLevelById(Joblevel jobLevel){
        return jobLevelMapper.updateByPrimaryKeySelective(jobLevel);
    }
//    删除
     public Integer deleteJobLevelById(Integer id){
        return jobLevelMapper.deleteByPrimaryKey(id);
    }
    public Integer deleteJobLevelsByIds(Integer[] ids){
        return jobLevelMapper.deleteJobLevelsByIds(ids);
    }
}

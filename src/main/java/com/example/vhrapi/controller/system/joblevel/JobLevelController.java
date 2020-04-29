package com.example.vhrapi.controller.system.joblevel;

import com.example.vhrapi.model.RespBean;
import com.example.vhrapi.model.system.joblevel.Joblevel;
import com.example.vhrapi.service.system.joblevel.JobLevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ASUS
 */
@RestController
@RequestMapping("/system/basic/joblevel")
@Api(value = "JobLevelController", tags = {"职称数据管理"})//使用@Api来修饰
public class JobLevelController {
    @Autowired
    JobLevelService jobLevelService;
    @ApiOperation(value = "获取所有职称", notes = "所有职称信息列表", produces = "application/json")
    @GetMapping("/")
    public RespBean getAllPosition() {
        List<Joblevel> joblevels = jobLevelService.getAllJobLevels();
        return RespBean.ok("获取成功", joblevels);
    }
    @ApiOperation(value = "新增职称", notes = "根据传入的职称添加一个新职称")
    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody Joblevel jObLevel) {
        if (jobLevelService.addJobLevel(jObLevel) == 1) {
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }
    @ApiOperation(value = "修改", notes = "根据传入的职称修改一个新职称")
    @PutMapping("/")
    @ApiResponses({
            @ApiResponse(code = 200, message = "更新成功！"),
            @ApiResponse(code = 500, message = "更新失败！")
    })

    public RespBean updateJobLevelById(@RequestBody Joblevel jObLevel) {
        if (jobLevelService.updateJobLevelById(jObLevel) == 1) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }
    @ApiOperation(value = "删除", notes = "根据 id 删除")
    @DeleteMapping("/{id}")
    public RespBean deleteJobLevelById(@PathVariable Integer id) {
        if (jobLevelService.deleteJobLevelById(id) == 1) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @DeleteMapping("/")
    public RespBean deleteJobLevelsIds(Integer[] ids) {
        if (jobLevelService.deleteJobLevelsByIds(ids) == ids.length) {
            return RespBean.ok("批量删除成功");
        }
        return RespBean.error("批量删除失败");
    }
}
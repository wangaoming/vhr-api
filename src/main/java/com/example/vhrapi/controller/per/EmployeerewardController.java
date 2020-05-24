package com.example.vhrapi.controller.per;

import com.example.vhrapi.model.RespBean;
import com.example.vhrapi.model.per.Employeereward;
import com.example.vhrapi.service.per.EmployeerewardService;
import com.example.vhrapi.utils.EmpRUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

//员工惩罚--Controller--操作数据
    @RestController
    @RequestMapping("/per/reward")
    @Api(value = " EmployeerewardController", tags = {"员工惩罚数据管理"})
    public class  EmployeerewardController {
        @Autowired
        EmployeerewardService employeerewardService;


        //分页
        @GetMapping("/")
        @ApiOperation(value = "分页获取员工惩罚", notes = "员工惩罚信息列表", produces = "application/json")
        public RespBean getPositionByPage(@RequestParam(defaultValue = "1") Integer page,
                                          @RequestParam(defaultValue = "5") Integer size) {
            PageInfo<Employeereward> employeerewards = employeerewardService.getEmployeerewardByPage(page, size);
            return RespBean.ok("", employeerewards);
        }
        @PostMapping("/")
        @ApiOperation(value = "新增惩罚", notes = "根据传入的惩罚添加一个新惩罚")
        @ApiImplicitParam(name = "employeereward", value = "employeereward对象", required = true)
        public RespBean addEmployeereward(@RequestBody Employeereward employeereward) {
            if (employeerewardService.addEmployeereward(employeereward) == 1) {
                return RespBean.ok("添加成功");
            }
            return RespBean.error("添加失败");
        }

        @PutMapping("/")
        @ApiOperation(value = "修改惩罚", notes = "传入惩罚信息进行更新修改" )
        @ApiResponses({
                @ApiResponse(code = 200, message = "更新成功！"),
                @ApiResponse(code = 500, message = "更新失败！")
        })
        public RespBean updateEmployeereward(@RequestBody Employeereward employeereward) {
            if (employeerewardService.updateEmployeereward(employeereward) == 1) {
                return RespBean.ok("更新成功");
            }
            return RespBean.error("更新失败");
        }

        @DeleteMapping("/{id}")
        @ApiOperation(value = "删除惩罚", notes = "根据 id 删除惩罚")
        @ApiImplicitParam(name = "id", value = "惩罚id", required = true)
        public RespBean deleteEmployeereward(@PathVariable Integer id) {
            if (employeerewardService.deleteEmployeereward(id) == 1) {
                return RespBean.ok("删除成功");
            }
            return RespBean.error("删除失败");
        }

        @DeleteMapping("/")
        @ApiOperation(value = "批量删除惩罚", notes = "根据 id 数组删除惩罚" )
        @ApiImplicitParam(name = "ids", value = "id数组", required = true)
        public RespBean deleteEmployeereward(Integer[] ids) {
            if (employeerewardService.deleteEmployeereward(ids) == ids.length) {
                return RespBean.ok("批量删除成功");
            }
            return RespBean.error("批量删除失败");
        }
//            导数据
        @GetMapping("/export")
        @ApiOperation(value = "导出数据", notes = "将所有惩罚导出到excel")
        public ResponseEntity<byte[]> exportData() {
            List<Employeereward> employeerewards = employeerewardService.getAllEmployeereward();
            return EmpRUtils.exportData(employeerewards);
        }

        @PostMapping("/import")
        @ApiOperation(value = "导入数据", notes = "导入excel数据")
        public RespBean importData(MultipartFile file) throws IOException {
            List<Employeereward> employeerewards  = EmpRUtils.importData(file);
            if(employeerewardService.addEmployeereward (employeerewards) == employeerewards.size()) {
                return RespBean.ok("导入成功");
            }
            return RespBean.ok("导入失败");
        }
    }


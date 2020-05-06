package com.example.vhrapi.controller.system.hr;

import com.example.vhrapi.model.Hr;
import com.example.vhrapi.model.RespBean;
import com.example.vhrapi.model.system.basic.permission.Role;
import com.example.vhrapi.service.HrService;
import com.example.vhrapi.service.system.basic.pemission.RoleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/hr")
@Api(value = "HrController", tags = {"操作员数据管理"})
public class HrController {
    @Autowired
    HrService hrService;
    @Autowired
    RoleService roleService;
    @GetMapping("/")
    public java.util.List<Hr> getAllHrs(String keywords) {
        return hrService.getAllHrs(keywords);
    }

    @PutMapping("/")
    public RespBean updateHr(@RequestBody Hr hr) {
        if (hrService.updateHr(hr) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }
    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return (List<Role>) roleService.getAllRoles();
    }

    @PutMapping("/role")
    public RespBean updateHrRole(Integer hrid, Integer[] rids) {
        if (hrService.updateHrRole(hrid, rids)) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteHrById(@PathVariable Integer id) {
        if (hrService.deleteHrById(id) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
}
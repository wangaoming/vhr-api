package com.example.vhrapi.controller.system.basic.permission;

import com.example.vhrapi.model.Menu;
import com.example.vhrapi.model.RespBean;
import com.example.vhrapi.model.system.basic.permission.Role;
import com.example.vhrapi.service.MenuService;
import com.example.vhrapi.service.system.basic.pemission.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/permiss")
@Api(value = "PermissionController", tags = {"权限组数据管理"})
public class PermissionController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;

    @GetMapping("/")
    @ApiOperation(value = "获取所有角色", notes = "所有角色信息列表", produces = "application/json")
    public RespBean getALlRoles() {
        List<Role> roles = roleService.getAllRoles();
        return RespBean.ok("", roles);
    }


    @GetMapping("/menus")
    @ApiOperation(value = "获取所有三级菜单", notes = "所有三级菜单的列表")
    public RespBean getAllMenus() {
        List<Menu> menus = roleService.getAllMenus();
        return RespBean.ok("", menus);
    }

    @GetMapping("/mid/{rid}")
    @ApiOperation(value = "获取角色对应的菜单id集合", notes = "角色对应的菜单id列表")
    public RespBean getMidsByRid(@PathVariable Integer rid) {
        List<Integer> rids = menuService.getMidsByRid(rid);
        return RespBean.ok("", rids);
    }

    @PutMapping("/")
    @ApiOperation(value = "修改角色对应的菜单")
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
        if(menuService.updateMenuRole(rid, mids)) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @PostMapping("/role")
    @ApiOperation(value = "添加角色")
    public RespBean addRole(@RequestBody Role role) {
        if (roleService.addRole(role) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/role/{rid}")
    @ApiOperation(value = "根据角色id删除角色")
    public RespBean deleteRoleById(@PathVariable Integer rid) {
        if (roleService.deleteRoleById(rid) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
}
package com.example.vhrapi.controller.system.basic.position;

import com.example.vhrapi.model.RespBean;
import com.example.vhrapi.model.system.basic.position.Position;
import com.example.vhrapi.service.system.basic.position.PositionService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//职位管理--Controller--操作数据
@RestController
@RequestMapping("/system/basic/pos")
@Api(value = "PositionController", tags = {"职位数据管理"})
public class PositionController {
    @Autowired
    PositionService positionService;

//    @GetMapping("/")
//    @ApiOperation(value = "获取所有职位", notes = "所有职位信息列表", produces = "application/json")
//    public RespBean getAllPosition() {
//        List<Position> positions = positionService.getAllPosition();
//        return RespBean.ok("获取成功", positions);
//    }
//分页
    @GetMapping("/")
    @ApiOperation(value = "分页获取职位", notes = "职位信息列表", produces = "application/json")
    public RespBean getPositionByPage(@RequestParam(defaultValue = "1") Integer page,
                                      @RequestParam(defaultValue = "5") Integer size) {
        PageInfo<Position> positions = positionService.getPositionByPage(page, size);
        return RespBean.ok("", positions);
    }
    @PostMapping("/")
    @ApiOperation(value = "新增职位", notes = "根据传入的职位添加一个新职位")
    @ApiImplicitParam(name = "position", value = "position对象", required = true)
    public RespBean addPosition(@RequestBody Position position) {
        if (positionService.addPosition(position) == 1) {
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @PutMapping("/")
    @ApiOperation(value = "修改职位", notes = "传入职位信息进行更新修改" )
    @ApiResponses({
            @ApiResponse(code = 200, message = "更新成功！"),
            @ApiResponse(code = 500, message = "更新失败！")
    })
    public RespBean updatePosition(@RequestBody Position position) {
        if (positionService.updatePosition(position) == 1) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除职位", notes = "根据 id 删除职位")
    @ApiImplicitParam(name = "id", value = "职位 id", required = true)
    public RespBean deletePosition(@PathVariable Integer id) {
        if (positionService.deletePosition(id) == 1) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @DeleteMapping("/")
    @ApiOperation(value = "批量删除职位", notes = "根据 id 数组删除职位" )
    @ApiImplicitParam(name = "ids", value = "id数组", required = true)
    public RespBean deletePosition(Integer[] ids) {
        if (positionService.deletePosition(ids) == ids.length) {
            return RespBean.ok("批量删除成功");
        }
        return RespBean.error("批量删除失败");
    }
}

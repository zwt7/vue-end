package com.example.vhr.end.controller.system.basic;

import com.example.vhr.end.model.Position;
import com.example.vhr.end.model.RespBean;
import com.example.vhr.end.service.system.basic.PositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @date:2020/4/23 13:16
 * @destription:
 */
@RestController
@Api(value = "PositionController" ,tags = {"职位管理访问接口"})
@RequestMapping("/system/basic/pos")
public class PositionController {
    @Autowired
    PositionService positionService;

    @ApiOperation(value = "获取全部职位信息")
    @GetMapping("/")
    public RespBean getAllPosition(){
        List<Position> positions=positionService.getAllPosition();
        return RespBean.ok("获取成功",positions);
    }

    @ApiOperation(value = "添加职位信息")
    @PostMapping("/")
    public RespBean addPosition(@RequestBody Position position){
        if(positionService.addPosition(position)==1){
            return RespBean.ok("添加成功");

        }
        return RespBean.error("添加失败");
    }

    @ApiOperation(value = "修改职位信息",notes = "在所有的职位信息里面，修改信息，并保存")
    @PutMapping("")
    public RespBean updatePosition(@RequestBody Position position){
        if (positionService.updatePosition(position) == 1){
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @ApiOperation(value = "删除职位信息",notes = "根据id来删除信息")
    @DeleteMapping("/{id}")
    public RespBean DeletePosition(@PathVariable Integer id){
        if(positionService.deletePosition(id)==1){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @ApiOperation(value = "批量删除",notes = "将想要删除的id号存在数据里,批量删除")
    @DeleteMapping("/")
    public RespBean DeletePosition(Integer[] ids){
        if (positionService.deletePosition(ids)==ids.length){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }
}

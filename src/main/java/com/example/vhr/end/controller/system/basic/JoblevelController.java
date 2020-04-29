package com.example.vhr.end.controller.system.basic;

import com.example.vhr.end.model.Joblevel;
import com.example.vhr.end.model.RespBean;
import com.example.vhr.end.service.system.basic.JoblevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * @date:2020/4/26 15:54
 * @destription:
 */

@RestController
@RequestMapping("/system/basic/job")
@Api(value = "JoblevelController",tags = {"职称管理"})
public class JoblevelController {
    @Autowired
    JoblevelService joblevelService;

    //get方式得到所有的职称
    @GetMapping("/")
    @ApiOperation(value = "获取所有职称")
    public RespBean getAllJoblevel(){
        List<Joblevel> joblevels=joblevelService.getAllJoblevel();
        return RespBean.ok("获取成功",joblevels);
    }

    @PostMapping("/")
    @ApiOperation(value = "添加职称")
    //有一次，我的前端的显示的名字和职称等级出不来，结果是没有加上requestBody
    public RespBean addJoblevel(@RequestBody Joblevel joblevel){
        if(joblevelService.addJoblevel(joblevel)==1){
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据id删除数据")
    public RespBean deleteJoblevel(@PathVariable Integer id){
        if(joblevelService.deleteJoblevel(id)==1){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @DeleteMapping("/")
    @ApiOperation(value = "根据id删除多条数据")
    public RespBean deleteJoblevel(Integer[] ids){
        if (joblevelService.deleteJoblevel(ids)==ids.length){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @PutMapping("")
    @ApiOperation(value = "修改职称数据")
    public RespBean updateJoblevel(@RequestBody Joblevel joblevel){
        if (joblevelService.updateJoblevel(joblevel)==1){
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }


}

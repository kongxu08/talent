package com.cjwsjy.talents.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cjwsjy.talents.entity.Dm_num_cube;
import com.cjwsjy.talents.service.IDm_num_cubeService;
import com.util.ResponseResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xuli2
 * @since 2019-08-07
 */
@RestController
@RequestMapping("/dW_ZYZG")
public class DW_ZYZGController {

    @Autowired
    private IDm_num_cubeService dmNumCubeService;

//     {"pagesize":10,"current":1,"glbdef2":"咨询工程师(投资)"}
    @ApiOperation(notes = "获取执业资格页数据", httpMethod = "POST", value = "获取执业资格页数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pagesize", value = "每页数量", dataType = "int",example = "1", paramType = "query"),
            @ApiImplicitParam(name = "current", value = "页码", dataType = "int",example = "1", paramType = "query")
    })
    @PostMapping("/zyzgPage")
    @ResponseBody
    ResponseResult zyzgPage(@RequestBody Map body){
        int current = Integer.parseInt(body.get("current").toString());
        int pagesize = Integer.parseInt(body.get("pagesize").toString());
        IPage<Dm_num_cube> page = new Page<Dm_num_cube>(current, pagesize);
        QueryWrapper<Dm_num_cube> wrapper = new QueryWrapper<Dm_num_cube>();

        String param = "";
        //奖励名称
        if (body.get("glbdef2") != null) {
            param+=String.format(" and b.glbdef2='%s'",body.get("glbdef2"));
        }

        String sql = String .format("SELECT DISTINCT b.pk_psndoc FROM hr_dw_zyzg b where 1=1 %s",param);
        wrapper.inSql("pk_psndoc",sql);
        wrapper.orderByAsc("CORPSEQ","DEPTSEQ","SHOWORDER");
        IPage result = dmNumCubeService.page(page,wrapper);
        return  ResponseResult.success(result,null);
    }
}
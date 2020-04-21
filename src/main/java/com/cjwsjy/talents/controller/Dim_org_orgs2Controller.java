package com.cjwsjy.talents.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cjwsjy.talents.entity.Dim_org_orgs2;
import com.cjwsjy.talents.service.IDim_org_orgs2Service;
import com.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xuli2
 * @since 2019-08-30
 */
@Api(description = "单位API")
@CrossOrigin
@RestController
@RequestMapping("/rest")
public class Dim_org_orgs2Controller {

    @Autowired
    private IDim_org_orgs2Service orgService;

    @ApiOperation(value = "获取所有单位")
    @ApiImplicitParam(name = "userName", value = "员工login_name", paramType = "query", required = true)
    @GetMapping("/allOrg")
    @ResponseBody
    ResponseResult getAll(@RequestParam("userName") String userName) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.orderByAsc("seq");
        List<Dim_org_orgs2> orgs = orgService.list(wrapper);
        JSONObject result = new JSONObject();
        result.put("orgs", orgs);
        return ResponseResult.success(result, null);
    }

    @ApiOperation(value = "获取所有单位以及员工数量")
    @ApiImplicitParam(name = "userName", value = "员工login_name", paramType = "query", required = true)
    @GetMapping("/getOrgEmployeeNum")
    @ResponseBody
    ResponseResult getOrgEmployeeNum(@RequestParam("userName") String userName) {
        List orgs = orgService.getOrgEmployeeNum();
        JSONObject result = new JSONObject();
        result.put("orgs", orgs);
        return ResponseResult.success(result, null);
    }

    @ApiOperation(value = "获取单位员工劳务关系分类及人数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "员工login_name", paramType = "query", required = true),
            @ApiImplicitParam(name = "org", value = "单位名", paramType = "query", required = false)
    })
    @GetMapping("/getEmployeeType")
    @ResponseBody
    ResponseResult getEmployeeType(@RequestParam String userName,
                                     @RequestParam(required = false) String org) {
        HashMap map = new HashMap();
        if(org!=null){
            map.put("org",org);
        }
        List<Map> types = orgService.getEmployeeType(map);
        int total=0;
        for(Map m:types){
            String str = m.get("num").toString();
            total+=Integer.parseInt(str);
        }
        Map totalMap = new HashMap();
        totalMap.put("num",total);
        totalMap.put("rylb","合计");
        types.add(totalMap);

        JSONObject result = new JSONObject();
        result.put("orgs", types);
        return ResponseResult.success(result, null);
    }
}


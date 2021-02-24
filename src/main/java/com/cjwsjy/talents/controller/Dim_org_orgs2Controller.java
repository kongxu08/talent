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

import java.util.ArrayList;
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
    ResponseResult getEmployeeType(@RequestParam String userName
            ,@RequestParam(required = false) String org) {
        HashMap map = new HashMap();
        if(org!=null){
            map.put("org",org);
        }
        int ntdgNum=0;
        int wbryNum=0;
        List<Map> newRylbs = new ArrayList<>();
        List<Map> rylbs = orgService.getEmployeeTypeForRylb(map);
        for (int i = 0; i <rylbs.size() ; i++) {
            Map m = rylbs.get(i);
            String  typeName = m.get("type").toString();
            if(typeName.equals("待岗人员2")||typeName.equals("待岗人员1")||typeName.equals("内退人员")){
                int j = Integer.parseInt(m.get("num").toString());
                ntdgNum+=j;
            }
            else if(typeName.equals("外包人员")||typeName.equals("返聘人员")||typeName.equals("劳务派遣人员")){
                int j = Integer.parseInt(m.get("num").toString());
                wbryNum+=j;
            }else {
                newRylbs.add(m);
            }
        }
        if(ntdgNum>0){
            Map ntdgMap = new HashMap();
            ntdgMap.put("type","内退待岗");
            ntdgMap.put("num",ntdgNum);
            newRylbs.add(ntdgMap);
        }
        if(wbryNum>0){
            Map wbryMap = new HashMap();
            wbryMap.put("type","劳务派遣人员");
            wbryMap.put("num",wbryNum);
            newRylbs.add(wbryMap);
        }

        map.put("type","n.rylb");
        map.put("rylb","在岗人员");

        map.put("type","n.age_range");
        List<Map> ages = orgService.getEmployeeType(map);
        map.put("type","n.edumemo");
        List<Map> edus = orgService.getEmployeeType(map);

        JSONObject result = new JSONObject();
        result.put("rylb", newRylbs);
        result.put("age", ages);
        result.put("edu", edus);

        return ResponseResult.success(result, null);
    }
}


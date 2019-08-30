package com.cjwsjy.talents.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cjwsjy.talents.entity.Dim_org_orgs2;
import com.cjwsjy.talents.service.IDim_org_orgs2Service;
import com.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}


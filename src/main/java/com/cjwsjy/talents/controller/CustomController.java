package com.cjwsjy.talents.controller;

import com.alibaba.fastjson.JSONObject;
import com.cjwsjy.talents.dao.CustomMapper;
import com.util.ResponseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
public class CustomController {

    @Resource
    private CustomMapper mapper;

    @ApiOperation(value = "人员岗级分布")
    @GetMapping("/getLevelNum")
    @ResponseBody
    ResponseResult getLevelNum() {
        List orgs = mapper.custom("SELECT glbdef3 as 'level',  COUNT ( glbdef3 ) as 'num' " +
                "FROM   hr_dm_num_cube  " +
                "WHERE " +
                " glbdef3 IS NOT NULL  " +
                "GROUP BY " +
                " glbdef3 " +
                " ORDER BY COUNT ( glbdef3 ) desc");
        JSONObject result = new JSONObject();
        result.put("orgs", orgs);
        return ResponseResult.success(result, null);
    }

    @ApiOperation(value = "人员专业技术职务")
    @GetMapping("/getPostNum")
    @ResponseBody
    ResponseResult getPostNum() {
        List orgs = mapper.custom("SELECT " +
                " glbdef23, " +
                " COUNT ( glbdef3 ) as 'num' " +
                "FROM " +
                " hr_dm_num_cube  " +
                "WHERE " +
                " glbdef23 IS NOT NULL  " +
                "GROUP BY " +
                " glbdef23 " +
                " ORDER BY COUNT ( glbdef23 ) desc");
        JSONObject result = new JSONObject();
        result.put("orgs", orgs);
        return ResponseResult.success(result, null);
    }
}

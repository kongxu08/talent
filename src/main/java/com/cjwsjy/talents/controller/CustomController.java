package com.cjwsjy.talents.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cjwsjy.talents.dao.CustomMapper;
import com.cjwsjy.talents.entity.Dm_num_cube;
import com.cjwsjy.talents.service.IDm_num_cubeService;
import com.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Api(description = "2020增补接口API")
@RestController
@CrossOrigin
@RequestMapping("/rest2020")
public class CustomController {

    @Resource
    private CustomMapper mapper;
    @Autowired
    private IDm_num_cubeService dmNumCubeService;

    @ApiOperation(value = "人员岗级分布")
    @GetMapping("/getLevelNum")
    @ResponseBody
    ResponseResult getLevelNum() {
        List list = mapper.custom("SELECT glbdef3 'title',  COUNT ( glbdef3 ) as 'num' " +
                "FROM   hr_dm_num_cube  " +
                "WHERE " +
                " glbdef3 IS NOT NULL  " +
                "GROUP BY " +
                " glbdef3 " +
                " ORDER BY COUNT ( glbdef3 ) desc");
        return ResponseResult.success(list, null);
    }

    @ApiOperation(value = "人员专业技术职务")
    @GetMapping("/getPostNum")
    @ResponseBody
    ResponseResult getPostNum() {
        List list = mapper.custom("SELECT " +
                " glbdef23 'title', " +
                " COUNT ( glbdef3 ) as 'num' " +
                "FROM " +
                " hr_dm_num_cube  " +
                "WHERE " +
                " glbdef23 IS NOT NULL  " +
                "GROUP BY " +
                " glbdef23 " +
                " ORDER BY COUNT ( glbdef23 ) desc");
        return ResponseResult.success(list, null);
    }

//    {"org":"院部"}
    @ApiOperation(value = "领导班子")
    @PostMapping("/getLDBZNum")
    @ResponseBody
    ResponseResult getLDBZNum(@RequestBody Map body) {

        String param = "";
        //单位
        if (body.get("org") != null) {
            param+=String.format(" and analysisorg1='%s'",body.get("org"));
        }
        String sql =String.format("SELECT\n" +
                " age_range 'title',\n" +
                " COUNT ( age_range ) AS 'num' \n" +
                " FROM hr_dm_num_cube \n" +
                " WHERE\n" +
                " 1=1 %s and (glbdef21!='让岗' or glbdef21 is null) and (glbdef22='正局级' or glbdef22='副局级' or glbdef22='正处级' or glbdef22='副处级' )"+
                " GROUP BY age_range ",param);
        List list = mapper.custom(sql);
        return ResponseResult.success(list, null);
    }

    //{"current":"1","pagesize":"10","ManageLevel":"公司级","ProjectType":"勘察设计咨询","NationalType":"国内","ProjectLevel":"1","OBS_Name":"项目助理"}
    @ApiOperation(value = "核心项目团队")
    @PostMapping("/getCoreTeam")
    @ResponseBody
    ResponseResult getCoreTeam(@RequestBody Map body) {
        int current = Integer.parseInt(body.get("current").toString());
        int pagesize = Integer.parseInt(body.get("pagesize").toString());
        QueryWrapper<Dm_num_cube> wrapper = new QueryWrapper<>();

        String param = "";
        //管理层级
        if (body.get("ManageLevel") != null) {
            param+=String.format(" and ManageLevel='%s'",body.get("ManageLevel"));
        }
        //业务类型
        if (body.get("ProjectType") != null) {
            param+=String.format(" and ProjectType='%s'",body.get("ProjectType"));
        }
        //项目岗位
        if (body.get("OBS_Name") != null) {
            param+=String.format(" and OBS_Name='%s'",body.get("OBS_Name"));
        }
        //国内/国外
        if (body.get("NationalType") != null) {
            param+=String.format(" and NationalType='%s'",body.get("NationalType"));
        }
        //项目级别
        if (body.get("ProjectLevel") != null) {
            param+=String.format(" and ProjectLevel='%s'",body.get("ProjectLevel"));
        }
        //项目状态
        if (body.get("ProjectStatus") != null) {
            param+=String.format(" and ProjectStatus='%s'",body.get("ProjectStatus"));
        }
        //责任单位
        if (body.get("DutyUnit") != null) {
            param+=String.format(" and DutyUnit='%s'",body.get("DutyUnit"));
        }

        String sql = String .format("select distinct b.WorkNo from hr_dm_projectuser b where 1=1 %s",param);
        wrapper.inSql("code",sql);
        IPage<Dm_num_cube> page = new Page<Dm_num_cube>(current, pagesize);
        IPage result = dmNumCubeService.highLevevlQuery(page,wrapper);
        return ResponseResult.success(result, null);
    }

    @ApiOperation(value = "获得称号人才数量")
    @GetMapping("/getHighTalentNum")
    @ResponseBody
    ResponseResult getCHNum() {
        List list = mapper.custom("select glbdef8name 'title',count(glbdef8name) 'num'\n" +
                "from HR_DM_HI_PSNDOC_GLBDEF11\n" +
                "where glbdef8name is not null\n" +
                "GROUP BY glbdef8name,glbdef8code\n" +
                "ORDER BY glbdef8code");
        return ResponseResult.success(list, null);
    }

    @ApiOperation(value = "执（职）业资格（含三维设计证书）")
    @GetMapping("/getZYZGNum")
    @ResponseBody
    ResponseResult getZYZGNum() {
        List list = mapper.custom("select a.glbdef2 'title',count(a.glbdef2) 'num'\n" +
                "from hr_dw_zyzg a,HR_DIM_ZYZG b\n" +
                "where a.glbdef2=b.name and a.glbdef2 is not null and a.pk_psndoc is not null\n" +
                "GROUP BY a.glbdef2,b.code\n" +
                "ORDER BY b.code");
        return ResponseResult.success(list, null);
    }

    /*
    select t.glbdef25,sum(t.num) 'num' from (
            select sex,age,glbdef25,count(glbdef25) 'num'
    from hr_dm_num_cube_tx a
    GROUP BY sex,glbdef25,age
    HAVING glbdef25 in('技术工人','普通工人','工人') and ((sex='男' and age>60) or (sex='女' and age>50 and glbdef25='工人') or (sex='女' and age>55 and glbdef25!='工人'))
            ) t
    GROUP BY glbdef25
    */
    @ApiOperation(value = "近五年退休人员及趋势")
    @GetMapping("/getTXRYQSNum")
    @ResponseBody
    ResponseResult getTXRYQSNum() {
        List list = mapper.custom("");
        return ResponseResult.success(list, null);
    }
}

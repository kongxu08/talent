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
import java.util.HashMap;
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
    @PostMapping("/getLevelNum")
    @ResponseBody
    ResponseResult getLevelNum(@RequestBody Map body) {
        String param = "";
        //单位
        if (body.get("org") != null) {
            param+=String.format(" and analysisorg1='%s'",body.get("org"));
        }
        List list = mapper.custom(String.format(
                "SELECT case when glbdef3 is not null then glbdef3 else '0未定岗' end 'title',  COUNT ( rylb ) as 'num' " +
                "FROM   hr_dm_num_cube  " +
                "WHERE " +
                " rylb='在岗人员' %s " +
                "GROUP BY " +
                " glbdef3 ",param));
        return ResponseResult.success(list, null);
    }

    @ApiOperation(value = "人员专业技术职务")
    @PostMapping("/getPostNum")
    @ResponseBody
    ResponseResult getPostNum(@RequestBody Map body) {
        String param = "";
        //单位
        if (body.get("org") != null) {
            param+=String.format(" and analysisorg1='%s'",body.get("org"));
        }
        List list = mapper.custom(String.format("SELECT " +
                " glbdef23 'title', " +
                " COUNT ( glbdef3 ) as 'num' " +
                "FROM " +
                " hr_dm_num_cube  " +
                "WHERE " +
                " glbdef23 IS NOT NULL %s " +
                "GROUP BY " +
                " glbdef23 " +
                " ORDER BY COUNT ( glbdef23 ) desc",param));
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
                " 1=1 %s and glrc in('职能部门主任','职能部门副主任','二级单位主要负责人','二级单位领导班子其他成员') and rylb='在岗人员'"+
                " GROUP BY age_range ",param);
        List list = mapper.custom(sql);
        return ResponseResult.success(list, null);
    }

    @ApiOperation(value = "领导班子分页数据")
    @PostMapping("/getLDBZPage")
    @ResponseBody
    ResponseResult getLDBZPage(@RequestBody Map body) {
        int current = Integer.parseInt(body.get("current").toString());
        int pagesize = Integer.parseInt(body.get("pagesize").toString());

        IPage<Dm_num_cube> page = new Page<Dm_num_cube>(current, pagesize);
        QueryWrapper<Dm_num_cube> wrapper = new QueryWrapper<Dm_num_cube>();

        //年龄段
        String age_range = body.get("ages").toString();
        String sql = String.format("SELECT pk_psndoc FROM hr_dm_num_cube WHERE " +
                " glrc in('职能部门主任','职能部门副主任','二级单位主要负责人','二级单位领导班子其他成员') and rylb='在岗人员'"+
                " and age_range='%s' ",age_range);

        //单位
        if (body.get("org") != null) {
           String org=body.get("org").toString();
           wrapper.eq("analysisorg1",org);
        }

        wrapper.inSql("pk_psndoc",sql);
        wrapper.orderByAsc("CORPSEQ","DEPTSEQ","SHOWORDER");
        IPage result = dmNumCubeService.page(page, wrapper);
        return ResponseResult.success(result, null);
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

        String sql = String .format("select distinct b.WorkNo from hr_dm_projectuser b " +
                "where b.OBS_Name in ('项目经理','项目常务副经理','项目副经理','项目首席科学家','项目BIM总监','项目总工','项目副总工') %s",param);
        wrapper.inSql("code",sql);
        IPage<Dm_num_cube> page = new Page<Dm_num_cube>(current, pagesize);
        IPage result = dmNumCubeService.highLevevlQuery(page,wrapper);
        return ResponseResult.success(result, null);
    }

    @ApiOperation(value = "核心项目团队人数")
    @PostMapping("/getCoreTeamNum")
    @ResponseBody
    ResponseResult getCoreTeamNum(
            @RequestBody Map body
    ) {
        String param = "";
        //管理层级
/*        if (body.get("ManageLevel") != null) {
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
        }*/
        //责任单位
        if (body.get("DutyUnit") != null) {
            param+=String.format(" and DutyUnit='%s'",body.get("DutyUnit"));
        }
        Map map = new HashMap();
        for (int i = 1; i <5 ; i++) {
            String sql = String .format("select b.OBS_Name 'title',(select count(distinct t.WorkNo) from hr_dm_projectuser t where  t.ProjectLevel='%s' and t.OBS_Name=b.OBS_Name %s) 'num'" +
                    " from hr_dm_projectuser b " +
                    " where  b.ProjectLevel='%s' and b.OBS_Name in ('项目经理','项目常务副经理','项目副经理','项目首席科学家','项目BIM总监','项目总工','项目副总工')  GROUP BY b.OBS_Name",i,param,i);
            map.put(String.valueOf(i),mapper.custom(sql));
        }

        return ResponseResult.success(map, null);
    }

    @ApiOperation(value = "获得称号人才数量")
    @PostMapping("/getHighTalentNum")
    @ResponseBody
    ResponseResult getHighTalentNum(@RequestBody Map body) {
        String param = "";
        //单位
        if (body.get("org") != null) {
            param+=String.format(" and b.analysisorg1='%s'",body.get("org"));
        }
        List list = mapper.custom(String.format(" select glbdef8name 'title',(count(glbdef8name) / 10)+1 'num',count(glbdef8name) 'val' " +
                " from HR_DM_HI_PSNDOC_GLBDEF11 a,hr_dm_num_cube b " +
                " where glbdef8name is not null and a.pk_psndoc=b.pk_psndoc %s" +
                " GROUP BY glbdef8name,glbdef8code " +
                " ORDER BY glbdef8code ",param));
        return ResponseResult.success(list, null);
    }

    @ApiOperation(value = "执（职）业资格（含三维设计证书）")
    @PostMapping("/getZYZGNum")
    @ResponseBody
    ResponseResult getZYZGNum(@RequestBody Map body) {
        String param = "";
        //单位
        if (body.get("org") != null) {
            param+=String.format(" and c.analysisorg1='%s'",body.get("org"));
        }
        List list = mapper.custom(String.format(" select a.glbdef2 'title',(count( a.glbdef2 ) / 50)+1 'num',count( a.glbdef2 ) 'val' " +
                " from hr_dw_zyzg a,HR_DIM_ZYZG b,hr_dm_num_cube c " +
                " where a.glbdef2=b.name and c.pk_psndoc=a.pk_psndoc and a.glbdef2 is not null and a.pk_psndoc is not null %s " +
                " GROUP BY a.glbdef2,b.code " +
                " ORDER BY b.code",param));
        return ResponseResult.success(list, null);
    }

    @ApiOperation(value = "近五年退休人员及趋势")
    @PostMapping("/getTXRYQSNum")
    @ResponseBody
    ResponseResult getTXRYQSNum(@RequestBody Map body) {
        String sql = " select t.enddate 'title',count(t.enddate) 'num' from (\n" +
                "SELECT DISTINCT hr_dm_num_cube_tx.pk_psndoc pk_psndoc, CASE  WHEN hr_dm_num_cube_tx.pk_psncl <> '1001A3100000000006ML' AND hr_dm_num_cube_tx.sex = '男' AND (60 + YEAR(hr_dm_num_cube_tx.birthdate) - YEAR(getdate())) >= 0 THEN (60 + YEAR(hr_dm_num_cube_tx.birthdate)) WHEN hr_dm_num_cube_tx.pk_psncl <> '1001A3100000000006ML' AND hr_dm_num_cube_tx.sex = '女' AND hr_dm_num_cube_tx.glbdef25 IN ('技术工人', '普通工人', '工人') AND (50 + YEAR(hr_dm_num_cube_tx.birthdate) - YEAR(getdate())) >= 0 THEN (50 + YEAR(hr_dm_num_cube_tx.birthdate)) WHEN hr_dm_num_cube_tx.pk_psncl <> '1001A3100000000006ML' AND hr_dm_num_cube_tx.sex = '女' AND (55 + YEAR(hr_dm_num_cube_tx.birthdate) - YEAR(getdate())) >= 0 THEN (55 + YEAR(hr_dm_num_cube_tx.birthdate)) ELSE isnull(t_1.cyear, 0) END enddate\n" +
                "FROM HR_DM_NUM_CUBE_TX hr_dm_num_cube_tx LEFT JOIN (SELECT * FROM hr_dm_psnjob_trnstype WHERE trnstype = '退休人员') t_1 ON hr_dm_num_cube_tx.pk_psndoc = t_1.pk_psndoc WHERE (CASE  WHEN hr_dm_num_cube_tx.pk_psncl <> '1001A3100000000006ML' AND hr_dm_num_cube_tx.sex = '男' AND (60 + YEAR(hr_dm_num_cube_tx.birthdate) - YEAR(getdate())) >= 0 THEN (60 + YEAR(hr_dm_num_cube_tx.birthdate)) WHEN hr_dm_num_cube_tx.pk_psncl <> '1001A3100000000006ML' AND hr_dm_num_cube_tx.sex = '女' AND hr_dm_num_cube_tx.glbdef25 IN ('技术工人', '普通工人', '工人') AND (50 + YEAR(hr_dm_num_cube_tx.birthdate) - YEAR(getdate())) >= 0 THEN (50 + YEAR(hr_dm_num_cube_tx.birthdate)) WHEN hr_dm_num_cube_tx.pk_psncl <> '1001A3100000000006ML' AND hr_dm_num_cube_tx.sex = '女' AND (55 + YEAR(hr_dm_num_cube_tx.birthdate) - YEAR(getdate())) >= 0 THEN (55 + YEAR(hr_dm_num_cube_tx.birthdate)) ELSE isnull(t_1.cyear, 0) END) >= (YEAR(getdate()) - 5) AND (CASE  WHEN hr_dm_num_cube_tx.pk_psncl <> '1001A3100000000006ML' AND hr_dm_num_cube_tx.sex = '男' AND (60 + YEAR(hr_dm_num_cube_tx.birthdate) - YEAR(getdate())) >= 0 THEN (60 + YEAR(hr_dm_num_cube_tx.birthdate)) WHEN hr_dm_num_cube_tx.pk_psncl <> '1001A3100000000006ML' AND hr_dm_num_cube_tx.sex = '女' AND hr_dm_num_cube_tx.glbdef25 IN ('技术工人', '普通工人', '工人') AND (50 + YEAR(hr_dm_num_cube_tx.birthdate) - YEAR(getdate())) >= 0 THEN (50 + YEAR(hr_dm_num_cube_tx.birthdate)) WHEN hr_dm_num_cube_tx.pk_psncl <> '1001A3100000000006ML' AND hr_dm_num_cube_tx.sex = '女' AND (55 + YEAR(hr_dm_num_cube_tx.birthdate) - YEAR(getdate())) >= 0 THEN (55 + YEAR(hr_dm_num_cube_tx.birthdate)) ELSE isnull(t_1.cyear, 0) END) <= (YEAR(getdate()) + 5) %s" +
                ") t GROUP BY t.enddate ORDER BY t.enddate";
        String param = "";
        //单位
        if (body.get("org") != null) {
            param+=String.format(" and hr_dm_num_cube_tx.analysisorg1='%s'",body.get("org"));
        }
        List list = mapper.custom(String.format(sql,param));
        return ResponseResult.success(list, null);
    }

//    {"current":"1","pagesize":"10","enddate":"2019","org":"院部"}
    @ApiOperation(value = "近五年退休人员及趋势分页查询")
    @PostMapping("/getTXRYQSPage")
    @ResponseBody
    ResponseResult getTXRYQSPage(@RequestBody Map body) {
        int current = Integer.parseInt(body.get("current").toString());
        int pagesize = Integer.parseInt(body.get("pagesize").toString());

        IPage<Dm_num_cube> page = new Page<Dm_num_cube>(current, pagesize);
        QueryWrapper<Dm_num_cube> wrapper = new QueryWrapper<Dm_num_cube>();
        String param = "";
        String sql = "select t.pk_psndoc from ( " +
                "SELECT DISTINCT hr_dm_num_cube_tx.pk_psndoc pk_psndoc, CASE  WHEN hr_dm_num_cube_tx.pk_psncl <> '1001A3100000000006ML' AND hr_dm_num_cube_tx.sex = '男' AND (60 + YEAR(hr_dm_num_cube_tx.birthdate) - YEAR(getdate())) >= 0 THEN (60 + YEAR(hr_dm_num_cube_tx.birthdate)) WHEN hr_dm_num_cube_tx.pk_psncl <> '1001A3100000000006ML' AND hr_dm_num_cube_tx.sex = '女' AND hr_dm_num_cube_tx.glbdef25 IN ('技术工人', '普通工人', '工人') AND (50 + YEAR(hr_dm_num_cube_tx.birthdate) - YEAR(getdate())) >= 0 THEN (50 + YEAR(hr_dm_num_cube_tx.birthdate)) WHEN hr_dm_num_cube_tx.pk_psncl <> '1001A3100000000006ML' AND hr_dm_num_cube_tx.sex = '女' AND (55 + YEAR(hr_dm_num_cube_tx.birthdate) - YEAR(getdate())) >= 0 THEN (55 + YEAR(hr_dm_num_cube_tx.birthdate)) ELSE isnull(t_1.cyear, 0) END enddate " +
                "FROM HR_DM_NUM_CUBE_TX hr_dm_num_cube_tx LEFT JOIN (SELECT * FROM hr_dm_psnjob_trnstype WHERE trnstype = '退休人员') t_1 ON hr_dm_num_cube_tx.pk_psndoc = t_1.pk_psndoc WHERE (CASE  WHEN hr_dm_num_cube_tx.pk_psncl <> '1001A3100000000006ML' AND hr_dm_num_cube_tx.sex = '男' AND (60 + YEAR(hr_dm_num_cube_tx.birthdate) - YEAR(getdate())) >= 0 THEN (60 + YEAR(hr_dm_num_cube_tx.birthdate)) WHEN hr_dm_num_cube_tx.pk_psncl <> '1001A3100000000006ML' AND hr_dm_num_cube_tx.sex = '女' AND hr_dm_num_cube_tx.glbdef25 IN ('技术工人', '普通工人', '工人') AND (50 + YEAR(hr_dm_num_cube_tx.birthdate) - YEAR(getdate())) >= 0 THEN (50 + YEAR(hr_dm_num_cube_tx.birthdate)) WHEN hr_dm_num_cube_tx.pk_psncl <> '1001A3100000000006ML' AND hr_dm_num_cube_tx.sex = '女' AND (55 + YEAR(hr_dm_num_cube_tx.birthdate) - YEAR(getdate())) >= 0 THEN (55 + YEAR(hr_dm_num_cube_tx.birthdate)) ELSE isnull(t_1.cyear, 0) END) >= (YEAR(getdate()) - 5) AND (CASE  WHEN hr_dm_num_cube_tx.pk_psncl <> '1001A3100000000006ML' AND hr_dm_num_cube_tx.sex = '男' AND (60 + YEAR(hr_dm_num_cube_tx.birthdate) - YEAR(getdate())) >= 0 THEN (60 + YEAR(hr_dm_num_cube_tx.birthdate)) WHEN hr_dm_num_cube_tx.pk_psncl <> '1001A3100000000006ML' AND hr_dm_num_cube_tx.sex = '女' AND hr_dm_num_cube_tx.glbdef25 IN ('技术工人', '普通工人', '工人') AND (50 + YEAR(hr_dm_num_cube_tx.birthdate) - YEAR(getdate())) >= 0 THEN (50 + YEAR(hr_dm_num_cube_tx.birthdate)) WHEN hr_dm_num_cube_tx.pk_psncl <> '1001A3100000000006ML' AND hr_dm_num_cube_tx.sex = '女' AND (55 + YEAR(hr_dm_num_cube_tx.birthdate) - YEAR(getdate())) >= 0 THEN (55 + YEAR(hr_dm_num_cube_tx.birthdate)) ELSE isnull(t_1.cyear, 0) END) <= (YEAR(getdate()) + 5) %s " +
                ") t where 1=1 ";
        //单位
        if (body.get("org") != null) {
            param=String.format(" and hr_dm_num_cube_tx.analysisorg1='%s'",body.get("org"));
        }
        sql = String.format(sql,param);
        //年份
        if(body.get("enddate") != null) {
            sql+=String.format(" and t.enddate='%s'",body.get("enddate"));
        }

        wrapper.inSql("pk_psndoc",sql);
//        wrapper.orderByAsc("CORPSEQ","DEPTSEQ","SHOWORDER");
        IPage result = dmNumCubeService.page(page, wrapper);
        return ResponseResult.success(result, null);
    }

    //{"current":"1","pagesize":"10","org":"阿里"}
    @ApiOperation(value = "交流挂职人员分页查询")
    @PostMapping("/getJLGZPage")
    @ResponseBody
    ResponseResult getJLGZPage(@RequestBody Map body) {
        int current = Integer.parseInt(body.get("current").toString());
        int pagesize = Integer.parseInt(body.get("pagesize").toString());

        IPage<Dm_num_cube> page = new Page<Dm_num_cube>(current, pagesize);
        QueryWrapper<Dm_num_cube> wrapper = new QueryWrapper<Dm_num_cube>();
        String sql = "select pk_psndoc from hr_dw_num_jlgz where 1=1 %s";
        String param = "";
        //单位
        if (body.get("org") != null) {
            param+=String.format(" and workcorp='%s'",body.get("org"));

        }
        sql = String.format(sql,param);
        wrapper.inSql("pk_psndoc",sql);
        wrapper.orderByAsc("CORPSEQ","DEPTSEQ","SHOWORDER");
        IPage result = dmNumCubeService.page(page, wrapper);
        return ResponseResult.success(result, null);
    }

    @ApiOperation(value = "交流挂职人数")
    @PostMapping("/getJLGZNum")
    @ResponseBody
    ResponseResult getJLGZNum(@RequestBody Map body) {
        String sql = "select workcorp 'title',count(workcorp) 'num' from hr_dw_num_jlgz GROUP BY workcorp";
        List list = mapper.custom(sql);
        return ResponseResult.success(list, null);
    }
}

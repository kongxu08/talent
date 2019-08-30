package com.cjwsjy.talents.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cjwsjy.talents.entity.*;
import com.cjwsjy.talents.service.*;
import com.util.FastJsonUtils;
import com.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Api(description = "企业人才API")
@RestController
@CrossOrigin
@RequestMapping("/rest")
public class ManageController {
    @Autowired
    private IDm_num_cubeService dmNumCubeService;
    @Autowired
    private IDm_eduService dm_eduService;
    @Autowired
    private IDm_psndoc_workService dm_psndoc_workService;
    @Autowired
    private IDm_xzzw_postService dm_xzzw_postsService;
    @Autowired
    private IDm_jxkhService dm_jxkhService;
    @Autowired
    private IDm_jlxxService dm_jlxxService;
    @Autowired
    private IDm_psndoc_familyService dm_psndoc_familyService;


    //http://localhost:8068/talent/rest/manageTalentPage?userId=1&current=12&pagesize=10
    //http://10.6.180.131:8068/talent/swagger-ui.html
    @ApiOperation(notes = "获取企业用户分页数据", httpMethod = "POST", value = "获取企业用户分页数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pagesize", value = "每页数量", dataType = "int",example = "1", paramType = "query"),
            @ApiImplicitParam(name = "current", value = "页码", dataType = "int",example = "1", paramType = "query")
    })
    @PostMapping("/manageTalentPage")
    @ResponseBody
    ResponseResult manageTalentPage(@RequestBody Map body) {
        int current = Integer.parseInt(body.get("current").toString());
        int pagesize = Integer.parseInt(body.get("pagesize").toString());
        IPage<Dm_num_cube> page = new Page<Dm_num_cube>(current, pagesize);
        QueryWrapper<Dm_num_cube> wrapper = new QueryWrapper<Dm_num_cube>();
//        String sql = "SELECT DISTINCT pk_psndoc from hr_dm_xzzw_post WHERE glbdef12 in ('副处级','正处级','副局级','正局级') AND glbdef11 <> '让岗'";
        String sql = "SELECT DISTINCT pk_psndoc from hr_dm_xzzw_post WHERE glbdef11 <> '让岗'";
        wrapper.inSql("pk_psndoc",sql);
        wrapper.ne("glrc","");
        wrapper.orderByAsc("CORPSEQ","DEPTSEQ","SHOWORDER");
        IPage result = dmNumCubeService.page(page, wrapper);
        return ResponseResult.success(result, null);
    }

    String column = null;
    List<String> params = null;
    Function<QueryWrapper<Dm_num_cube>, QueryWrapper<Dm_num_cube>> fun = (w) -> {
        for (int i = 0; i < params.size(); i++) {
            w.or().eq(column, params.get(i));
        }
        params = null;
        column = null;
        return w;
    };

    @ApiOperation(notes = "查询企业用户", httpMethod = "POST", value = "查询企业用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pagesize", value = "每页数量", dataType = "int",example = "1", paramType = "query"),
            @ApiImplicitParam(name = "current", value = "页码", dataType = "int",example = "1", paramType = "query")
    })
    @PostMapping("/manageTalentQueryPage")
    @ResponseBody
    ResponseResult manageTalentQueryPage(@RequestBody Map body) {
        QueryWrapper<Dm_num_cube> wrapper = new QueryWrapper<>();
        int current = Integer.parseInt(body.get("current").toString());
        int pagesize = Integer.parseInt(body.get("pagesize").toString());
        //单位
        if (body.get("org") != null) {
            column = "analysisorg1";
            params = (List<String>) body.get("org");
            wrapper.and(w -> w.or(fun));

        }
        //职级
        if (body.get("post") != null) {
            column = "glbdef22";
            params = (List<String>) body.get("post");
            wrapper.and(w -> w.or(fun));

        }
        //岗级
        if (body.get("rank") != null) {
            column = "glbdef3";
            params = (List<String>) body.get("rank");
            wrapper.and(w -> w.or(fun));

        }
        //学历
        if (body.get("edumemo") != null) {
            column = "edumemo";
            params = (List<String>) body.get("edumemo");
            wrapper.and(w -> w.or(fun));

        }
        //本职级年限
        if (body.get("post_range") != null) {
            column = "glbdef52";
            params = (List<String>) body.get("post_range");
            wrapper.and(w -> w.or(fun));

        }
        //年龄段
        if (body.get("ages") != null) {
            column = "age_range";
            params = (List<String>) body.get("ages");
            wrapper.and(w -> w.or(fun));

        }
        //职称
        if (body.get("title") != null) {
            column = "glbdef23";
            params = (List<String>) body.get("title");
            wrapper.and(w -> w.or(fun));

        }
        //工龄段
        if (body.get("workage_range") != null) {
            column = "workage_range";
            params = (List<String>) body.get("workage_range");
            wrapper.and(w -> w.or(fun));

        }
        //姓名
        if (body.get("name") != null) {
            String name = body.get("name").toString();
            wrapper.like("name", name);
        }
        //籍贯
        if (body.get("origin") != null) {
            String origin = body.get("origin").toString();
            wrapper.like("glbdef4", origin);
        }
        //学校
        if (body.get("school") != null) {
            String school = body.get("school").toString();
            wrapper.like("school", school);
        }
        //专业
        if (body.get("zhuanye") != null) {
            String zhuanye = body.get("zhuanye").toString();
            wrapper.like("zhuanye", zhuanye);
        }
//        String sql = "SELECT DISTINCT pk_psndoc from hr_dm_xzzw_post WHERE glbdef12 in ('副处级','正处级','副局级','正局级') AND glbdef11 <> '让岗'";
        String sql = "SELECT DISTINCT pk_psndoc from hr_dm_xzzw_post WHERE glbdef11 <> '让岗'";
        wrapper.inSql("pk_psndoc",sql);
        wrapper.ne("glrc","");
        wrapper.orderByAsc("CORPSEQ","DEPTSEQ","SHOWORDER");
        IPage<Dm_num_cube> page = new Page<Dm_num_cube>(current, pagesize);
        IPage result = dmNumCubeService.page(page, wrapper);

        return ResponseResult.success(result, null);
    }

    @ApiOperation(value = "获取企业用户详情数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "使用者id", paramType = "query", required = true),
            @ApiImplicitParam(name = "psndoc", value = "被查询用户id", paramType = "query", required = true)
    })
    @PostMapping("/manageTalentInfo")
    @ResponseBody
    ResponseResult manageTalentInfo(@RequestParam("userId") String userId, @RequestParam("psndoc") String psndoc) {
        //人员基本信息
        QueryWrapper<Dm_num_cube> wrapper = new QueryWrapper<>();
        wrapper.eq("pk_psndoc", psndoc);
        Dm_num_cube person = dmNumCubeService.getOne(wrapper);
        //学历信息
        QueryWrapper<Dm_edu> eduWrapper = new QueryWrapper<>();
        eduWrapper.eq("pk_psndoc", psndoc);
        eduWrapper.orderByDesc("begindate");
        List<Dm_edu> edulist = dm_eduService.list(eduWrapper);
        //履历信息
        QueryWrapper<Dm_psndoc_work> workWrapper = new QueryWrapper<>();
        workWrapper.eq("pk_psndoc", psndoc);
        workWrapper.orderByDesc("begindate");
        List<Dm_psndoc_work> worklist = dm_psndoc_workService.list(workWrapper);
        //行政职务
        QueryWrapper<Dm_xzzw_post> postWrapper = new QueryWrapper<>();
        postWrapper.eq("pk_psndoc", psndoc);
        postWrapper.orderByDesc("begindate");
        List<Dm_xzzw_post> postlist = dm_xzzw_postsService.list(postWrapper);
        //奖励信息
        QueryWrapper<Dm_jlxx> awardWrapper = new QueryWrapper<>();
        awardWrapper.eq("pk_psndoc", psndoc);
        awardWrapper.orderByDesc("glbdef4");
        List<Dm_jlxx> awardlist = dm_jlxxService.list(awardWrapper);
        //绩效考核
        QueryWrapper<Dm_jxkh> performanceWrapper = new QueryWrapper<>();
        performanceWrapper.eq("pk_psndoc", psndoc);
        List<Dm_jxkh> performancelist = dm_jxkhService.list(performanceWrapper);
        //家庭信息
        QueryWrapper<Dm_psndoc_family> familyWrapper = new QueryWrapper<>();
        familyWrapper.eq("pk_psndoc", psndoc);
        familyWrapper.orderByAsc("mem_birthday");
        List<Dm_psndoc_family> familylist = dm_psndoc_familyService.list(familyWrapper);

        JSONObject result = FastJsonUtils.objectToJSONObject(person);
        JSONArray edus = FastJsonUtils.objectToJSONArray(edulist);
        JSONArray works = FastJsonUtils.objectToJSONArray(worklist);
        JSONArray posts = FastJsonUtils.objectToJSONArray(postlist);
        JSONArray awards = FastJsonUtils.objectToJSONArray(awardlist);
        JSONArray performances = FastJsonUtils.objectToJSONArray(performancelist);
        JSONArray familys = FastJsonUtils.objectToJSONArray(familylist);

        result.put("edus", edus);
        result.put("works", works);
        result.put("posts", posts);
        result.put("awards", awards);
        result.put("performances", performances);
        result.put("familys", familys);

        return ResponseResult.success(result, null);
    }

}

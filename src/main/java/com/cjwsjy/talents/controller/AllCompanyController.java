package com.cjwsjy.talents.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Api(description = "全员信息查询API")
@RestController
@CrossOrigin
@RequestMapping("/rest")
public class AllCompanyController {
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
    @Autowired
    private IDm_zyjx_postService dm_zyjx_postService;
    @Autowired
    private IDW_ZYZGService dw_zyzgService;
    @Autowired
    private IDM_KJHJCGDJService dm_kjhjcgdjService;
    @Autowired
    private IDm_hi_psndoc_glbdef11Service dm_hi_psndoc_glbdef11Service;
    @Autowired
    private IDm_xmjlService dm_xmjlService;
    @Autowired
    private IStg_hi_psndoc_glbdef10Service stg_hi_psndoc_glbdef10Service;
    @Autowired
    private IT_YFZX_SLLWService t_yfzx_sllwService;
    @Autowired
    private IDM_ZLXXService dm_zlxxService;
    @Autowired
    private IXMRZService xmrzService;
    @Autowired
    private ILunwenService lunwenService;
    @Autowired
    private IDm_lwlzService dm_lwlzService;
    //http://localhost:8068/talent/rest/manageTalentPage?userId=1&current=12&pagesize=10
    //http://10.6.180.131:8068/talent/swagger-ui.html
//       "pk_psndoc": "0001A310000000000RD3"
    @ApiOperation(notes = "获取全员信息查询分页数据", httpMethod = "POST", value = "获取全员信息查询分页数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pagesize", value = "每页数量", dataType = "int",example = "1", paramType = "query"),
            @ApiImplicitParam(name = "current", value = "页码", dataType = "int",example = "1", paramType = "query")
    })
    @PostMapping("/allTalentPage")
    @Cacheable(value="userInfoCache")
    @ResponseBody
    public ResponseResult allTalentPage(@RequestBody Map body) {
        int current = Integer.parseInt(body.get("current").toString());
        int pagesize = Integer.parseInt(body.get("pagesize").toString());
        IPage<Dm_num_cube> page = new Page<Dm_num_cube>(current, pagesize);
        QueryWrapper<Dm_num_cube> wrapper = new QueryWrapper<Dm_num_cube>();
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

    @ApiOperation(notes = "全员信息查询", httpMethod = "POST", value = "全员信息查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pagesize", value = "每页数量", dataType = "int",example = "1", paramType = "query"),
            @ApiImplicitParam(name = "current", value = "页码", dataType = "int",example = "1", paramType = "query")
    })
    @PostMapping("/allTalentQueryPage")
    @ResponseBody
    ResponseResult allTalentQueryPage(@RequestBody Map body) {
        QueryWrapper<Dm_num_cube> wrapper = new QueryWrapper<>();
        int current = Integer.parseInt(body.get("current").toString());
        int pagesize = Integer.parseInt(body.get("pagesize").toString());
        //单位
        if (body.get("org") != null) {
            column = "analysisorg1";
            params = (List<String>) body.get("org");
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
        //学历
        if (body.get("edumemo") != null) {
            column = "edumemo";
            params = (List<String>) body.get("edumemo");
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
        wrapper.orderByAsc("CORPSEQ","DEPTSEQ","SHOWORDER");
        IPage<Dm_num_cube> page = new Page<Dm_num_cube>(current, pagesize);
        IPage result = dmNumCubeService.page(page, wrapper);

        return ResponseResult.success(result, null);
    }

    @ApiOperation(value = "获取全员信息查询详情数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "使用者id", paramType = "query", required = true),
            @ApiImplicitParam(name = "psndoc", value = "被查询用户id", paramType = "query", required = true)
    })
    @PostMapping("/allTalentInfo")
    @Cacheable(value="userInfoCache", key="#root.targetClass+'-'+#root.methodName+'-'+#psndoc")
    @ResponseBody
    public ResponseResult allTalentInfo(@RequestParam("userId") String userId, @RequestParam("psndoc") String psndoc) {
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
        //专业技术职务（职称）
        QueryWrapper<Dm_zyjx_post> zcWrapper = new QueryWrapper<>();
        zcWrapper.eq("pk_psndoc", psndoc);
        zcWrapper.orderByDesc("glbdef2");
        List<Dm_zyjx_post> zclist = dm_zyjx_postService.list(zcWrapper);
        //执业资格
        QueryWrapper<DW_ZYZG> zyWrapper = new QueryWrapper<>();
        zyWrapper.eq("pk_psndoc", psndoc);
        zyWrapper.orderByDesc("glbdef6");
        List<DW_ZYZG> zylist = dw_zyzgService.list(zyWrapper);
        //绩效考核
        QueryWrapper<Dm_jxkh> performanceWrapper = new QueryWrapper<>();
        performanceWrapper.eq("pk_psndoc", psndoc);
        List<Dm_jxkh> performancelist = dm_jxkhService.list(performanceWrapper);
        //家庭信息
        QueryWrapper<Dm_psndoc_family> familyWrapper = new QueryWrapper<>();
        familyWrapper.eq("pk_psndoc", psndoc);
        familyWrapper.orderByAsc("mem_birthday");
        List<Dm_psndoc_family> familylist = dm_psndoc_familyService.list(familyWrapper);
        //科技成果奖励
        QueryWrapper<DM_KJHJCGDJ> scienceWrapper = new QueryWrapper<>();
        scienceWrapper.eq("pk_psndoc",psndoc);
        scienceWrapper.orderByDesc("fisj");
        List<DM_KJHJCGDJ> sciencelist = dm_kjhjcgdjService.list(scienceWrapper);
        //荣誉称号
        QueryWrapper<Dm_hi_psndoc_glbdef11> honorWrapper = new QueryWrapper<>();
        honorWrapper.eq("pk_psndoc",psndoc);
        honorWrapper.orderByDesc("glbdef7");
        List<Dm_hi_psndoc_glbdef11> honorlist = dm_hi_psndoc_glbdef11Service.list(honorWrapper);
        //项目经历
        QueryWrapper<Dm_xmjl> jlWrapper = new QueryWrapper<>();
        jlWrapper.eq("pk_psndoc",psndoc);
        jlWrapper.orderByDesc("recordnum");
        List<Dm_xmjl> jllist = dm_xmjlService.list(jlWrapper);
        //国家职业资格
        QueryWrapper<Stg_hi_psndoc_glbdef10> zgWrapper = new QueryWrapper<>();
        zgWrapper.eq("pk_psndoc",psndoc);
        zgWrapper.orderByDesc("glbdef3");
        List<Stg_hi_psndoc_glbdef10> zglist = stg_hi_psndoc_glbdef10Service.list(zgWrapper);
        //论文论著
        QueryWrapper<T_YFZX_SLLW> essayWrapper = new QueryWrapper<>();
        essayWrapper.eq("pk_psndoc",psndoc);
        essayWrapper.orderByDesc("FDFXSJ");
        List<T_YFZX_SLLW> essaylist = t_yfzx_sllwService.list(essayWrapper);
        //专利信息
        QueryWrapper<DM_ZLXX> patentWrapper = new QueryWrapper<>();
        patentWrapper.eq("pk_psndoc",psndoc);
        patentWrapper.orderByDesc("FDGJSQR");
        List<DM_ZLXX> patentlist = dm_zlxxService.list(patentWrapper);
        //项目任职信息
        QueryWrapper<XMRZ> xmrzWrapper = new QueryWrapper<>();
        xmrzWrapper.eq("PK_PSNDOC",psndoc);
        xmrzWrapper.orderByDesc("GLBDEF3");
        List<XMRZ> xmrzlist = xmrzService.list(xmrzWrapper);
        //论文
        QueryWrapper<Lunwen> lunwenWrapper = new QueryWrapper<>();
        lunwenWrapper.eq("pk_psndoc",psndoc);
        lunwenWrapper.orderByDesc("glbdef7");
        List<Lunwen> lunwenlist = lunwenService.list(lunwenWrapper);
        //论著
        QueryWrapper<Dm_lwlz> lunzhuWrapper = new QueryWrapper<>();
        lunzhuWrapper.eq("pk_psndoc",psndoc);
        lunzhuWrapper.orderByDesc("glbdef2");
        List<Dm_lwlz> lunzhulist = dm_lwlzService.list(lunzhuWrapper);

        JSONObject result = FastJsonUtils.objectToJSONObject(person);
        JSONArray edus = FastJsonUtils.objectToJSONArray(edulist);
        JSONArray works = FastJsonUtils.objectToJSONArray(worklist);
        JSONArray posts = FastJsonUtils.objectToJSONArray(postlist);
        JSONArray awards = FastJsonUtils.objectToJSONArray(awardlist);
        JSONArray performances = FastJsonUtils.objectToJSONArray(performancelist);
        JSONArray familys = FastJsonUtils.objectToJSONArray(familylist);
        JSONArray zcs = FastJsonUtils.objectToJSONArray(zclist);
        JSONArray zys = FastJsonUtils.objectToJSONArray(zylist);
        JSONArray sciences = FastJsonUtils.objectToJSONArray(sciencelist);
        JSONArray honors = FastJsonUtils.objectToJSONArray(honorlist);
        JSONArray jls = FastJsonUtils.objectToJSONArray(jllist);
        JSONArray zgs = FastJsonUtils.objectToJSONArray(zglist);
        JSONArray essays = FastJsonUtils.objectToJSONArray(essaylist);
        JSONArray patents = FastJsonUtils.objectToJSONArray(patentlist);
        JSONArray xmrzs = FastJsonUtils.objectToJSONArray(xmrzlist);
        JSONArray lunwens = FastJsonUtils.objectToJSONArray(lunwenlist);
        JSONArray lunzhus = FastJsonUtils.objectToJSONArray(lunzhulist);

        result.put("edus", edus);//学历信息
        result.put("works", works);//工作履历
        result.put("posts", posts);//职务信息
        result.put("awards", awards);//奖励信息
        result.put("sciences", sciences);//科技成果奖励
        result.put("honors",honors);//荣誉称号
        result.put("performances", performances);//绩效考核
        result.put("familys", familys);//家庭
        result.put("zcs", zcs);//专业技术职务（职称）
        result.put("zys", zys);//执业资格
        result.put("jls", jls);//项目经历
        result.put("zgs", zgs);//职业资格
//        result.put("essays",essays);//论文论著
        result.put("patents",patents);//专利信息
        result.put("xmrzs",xmrzs);//项目任职信息
        result.put("lunwens",lunwens);//论文
        result.put("lunzhus",lunzhus);//论著

        return ResponseResult.success(result, null);
    }

}

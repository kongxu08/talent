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

@Api(description = "高层次人才API")
@RestController
@CrossOrigin
@RequestMapping("/rest")
public class HighLevelController {
    @Autowired
    private IDm_num_cubeService dmNumCubeService;
    @Autowired
    private IDm_eduService dm_eduService;
    @Autowired
    private IDm_psndoc_workService dm_psndoc_workService;
    @Autowired
    private IDM_ZLXXService dm_zlxxService;
    @Autowired
    private IDm_hi_psndoc_glbdef11Service dm_hi_psndoc_glbdef11Service;
    @Autowired
    private IT_YFZX_SLLWService t_yfzx_sllwService;
    @Autowired
    private IDM_KJHJCGDJService dm_kjhjcgdjService;


    //http://localhost:8068/talent/rest/manageTalentPage?userId=1&current=12&pagesize=10
    //http://10.6.180.131:8068/talent/swagger-ui.html
//    {"pagesize":10,"current":1,"awardName":"中国"}
    @ApiOperation(notes = "获取高层次人才分页数据", httpMethod = "POST", value = "获取高层次人才分页数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pagesize", value = "每页数量", dataType = "int",example = "1", paramType = "query"),
            @ApiImplicitParam(name = "current", value = "页码", dataType = "int",example = "1", paramType = "query")
    })
    @PostMapping("/highTalentPage")
    @ResponseBody
    ResponseResult highTalentPage(@RequestBody Map body){
        int current = Integer.parseInt(body.get("current").toString());
        int pagesize = Integer.parseInt(body.get("pagesize").toString());
        IPage<Dm_num_cube> page = new Page<Dm_num_cube>(current, pagesize);
        QueryWrapper<Dm_num_cube> wrapper = new QueryWrapper<Dm_num_cube>();
        String sql = "SELECT DISTINCT pk_psndoc FROM hr_dm_hi_psndoc_glbdef11";
        wrapper.inSql("pk_psndoc",sql);
        wrapper.orderByAsc("CORPSEQ","DEPTSEQ","SHOWORDER");
        IPage result = dmNumCubeService.page(page,wrapper);
        return  ResponseResult.success(result,null);
    }

    @ApiOperation(value = "获取高层次人才详情数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "使用者id", paramType = "query", required = true),
            @ApiImplicitParam(name = "psndoc", value = "被查询用户id", paramType = "query", required = true)
    })
    @PostMapping("/highTalentInfo")
    @ResponseBody
    ResponseResult highTalentInfo(@RequestParam("userId") String userId, @RequestParam("psndoc") String psndoc){
        //人员基本信息
        QueryWrapper<Dm_num_cube> wrapper = new QueryWrapper<>();
        wrapper.eq("pk_psndoc",psndoc);
        Dm_num_cube person = dmNumCubeService.getOne(wrapper);
        //学历信息
        QueryWrapper<Dm_edu> eduWrapper = new QueryWrapper<>();
        eduWrapper.eq("pk_psndoc",psndoc);
        eduWrapper.orderByDesc("begindate");
        List<Dm_edu> edulist = dm_eduService.list(eduWrapper);
        //履历信息
        QueryWrapper<Dm_psndoc_work> workWrapper = new QueryWrapper<>();
        workWrapper.eq("pk_psndoc",psndoc);
        workWrapper.orderByDesc("begindate");
        List<Dm_psndoc_work> worklist = dm_psndoc_workService.list(workWrapper);
        //荣誉称号
        QueryWrapper<Dm_hi_psndoc_glbdef11> honorWrapper = new QueryWrapper<>();
        honorWrapper.eq("pk_psndoc",psndoc);
        honorWrapper.orderByDesc("glbdef7");
        List<Dm_hi_psndoc_glbdef11> honorlist = dm_hi_psndoc_glbdef11Service.list(honorWrapper);
        //科技成果奖励
        QueryWrapper<DM_KJHJCGDJ> scienceWrapper = new QueryWrapper<>();
        scienceWrapper.eq("pk_psndoc",psndoc);
        scienceWrapper.orderByDesc("fisj");
        List<DM_KJHJCGDJ> sciencelist = dm_kjhjcgdjService.list(scienceWrapper);
        //论文论著
        QueryWrapper<T_YFZX_SLLW> essayWrapper = new QueryWrapper<>();
        essayWrapper.eq("pk_psndoc",psndoc);
        essayWrapper.orderByDesc("FDFXSJ");
        List<T_YFZX_SLLW> essaylist = t_yfzx_sllwService.list(essayWrapper);
        //专利信息
        QueryWrapper<DM_ZLXX> patentWrapper = new QueryWrapper<>();
        patentWrapper.eq("pk_psndoc",psndoc);
        patentWrapper.orderByDesc("fipx");
        List<DM_ZLXX> patentlist = dm_zlxxService.list(patentWrapper);

        JSONObject result = FastJsonUtils.objectToJSONObject(person);
        JSONArray edus = FastJsonUtils.objectToJSONArray(edulist);
        JSONArray works = FastJsonUtils.objectToJSONArray(worklist);
        JSONArray sciences = FastJsonUtils.objectToJSONArray(sciencelist);
        JSONArray honors = FastJsonUtils.objectToJSONArray(honorlist);
        JSONArray essays = FastJsonUtils.objectToJSONArray(essaylist);
        JSONArray patents = FastJsonUtils.objectToJSONArray(patentlist);

        result.put("edus",edus);
        result.put("works",works);
        result.put("sciences",sciences);
        result.put("honors",honors);
        result.put("essays",essays);
        result.put("patents",patents);

        return  ResponseResult.success(result,null);
    }

    String column = null;
    List<String> params = null;
    Function<QueryWrapper<Dm_num_cube>,QueryWrapper<Dm_num_cube>> fun = (w) ->{
        for (int i = 0; i <params.size() ; i++) {
            w.or().eq(column,params.get(i));
        }
        params = null;
        column = null;
        return w;
    };

    @ApiOperation(notes = "查询高层次人才", httpMethod = "POST", value = "查询高层次人才")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pagesize", value = "每页数量", dataType = "int",example = "1", paramType = "query"),
            @ApiImplicitParam(name = "current", value = "页码", dataType = "int",example = "1", paramType = "query"),

            @ApiImplicitParam(name = "org", value = "单位", dataType = "list", paramType = "query"),
            @ApiImplicitParam(name = "workage_range", value = "工龄段", dataType = "list", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "姓名", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "awardType", value = "奖励类型", dataType = "list", paramType = "query"),
            @ApiImplicitParam(name = "awardLevel", value = "奖励等级", dataType = "list", paramType = "query"),
            @ApiImplicitParam(name = "awardRank", value = "奖励级别", dataType = "list", paramType = "query"),
            @ApiImplicitParam(name = "awardName", value = "奖励名称", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "essay", value = "论文检索", dataType = "list", paramType = "query")
    })
    @PostMapping("/highTalentQueryPage")
    @ResponseBody
    ResponseResult highTalentQueryPage(@RequestBody Map body){
        QueryWrapper<Dm_num_cube> wrapper = new QueryWrapper<>();
        int current = Integer.parseInt(body.get("current").toString());
        int pagesize = Integer.parseInt(body.get("pagesize").toString());
        //单位
        if (body.get("org") != null) {
            column = "t.analysisorg1";
            params = (List<String>) body.get("org");
            wrapper.and(w->w.or(fun));
        }
        //工龄段
        if (body.get("workage_range") != null) {
            column = "t.workage_range";
            params = (List<String>) body.get("workage_range");
            wrapper.and(w->w.or(fun));
        }
        //姓名
        if (body.get("name") != null) {
            String name = body.get("name").toString();
//            wrapper.like(Dm_num_cube::getName,name);
            wrapper.like("t.name",name);
        }

        //奖励类型
        if (body.get("awardType") != null) {
            List<String> list = (List<String>) body.get("awardType");
            String column = "j.fsjldl";
            StringBuffer sql = new StringBuffer();
            sql.append("SELECT * FROM OA_DM_KJHJCGDJ j where t.pk_psndoc = j.pk_psndoc AND ( ");
            for (int i = 0; i <list.size() ; i++) {
                if(i!=0){
                    sql.append(" or ");
                }
                sql.append(column+"='"+list.get(i)+"' ");
                if(i==list.size()-1){
                    sql.append(" ) ");
                }
            }
            wrapper.exists(sql.toString());
        }

        //奖励等级
        if (body.get("awardLevel") != null) {
            List<String> list = (List<String>) body.get("awardLevel");
            String column = "j.fshjlb";
            StringBuffer sql = new StringBuffer();
            sql.append("SELECT * FROM OA_DM_KJHJCGDJ j where t.pk_psndoc = j.pk_psndoc AND ( ");
            for (int i = 0; i <list.size() ; i++) {
                if(i!=0){
                    sql.append(" or ");
                }
                sql.append(column+"='"+list.get(i)+"' ");
                if(i==list.size()-1){
                    sql.append(" ) ");
                }
            }
            wrapper.exists(sql.toString());
        }

        //奖励级别
        if (body.get("awardRank") != null) {
            List<String> list = (List<String>) body.get("awardRank");
            String column = "j.fsjldj";
            StringBuffer sql = new StringBuffer();
            sql.append("SELECT * FROM OA_DM_KJHJCGDJ j where t.pk_psndoc = j.pk_psndoc AND ( ");
            for (int i = 0; i <list.size() ; i++) {
                if(i!=0){
                    sql.append(" or ");
                }
                sql.append(column+"='"+list.get(i)+"' ");
                if(i==list.size()-1){
                    sql.append(" ) ");
                }
            }
            wrapper.exists(sql.toString());
        }

        //奖励名称
        if (body.get("awardName") != null) {
            List<String> list = (List<String>) body.get("awardName");
            String column = "j.glbdef8name";
            StringBuffer sql = new StringBuffer();
            sql.append("SELECT * FROM hr_dm_hi_psndoc_glbdef11 j where t.pk_psndoc = j.pk_psndoc AND ( ");
            for (int i = 0; i <list.size() ; i++) {
                if(i!=0){
                    sql.append(" or ");
                }
                sql.append(column+"='"+list.get(i)+"' ");
                if(i==list.size()-1){
                    sql.append(" ) ");
                }
            }
            wrapper.exists(sql.toString());
        }

        //论文检索
        if (body.get("essay") != null) {
            List<String> list = (List<String>) body.get("essay");
            String column = "j.fsfl";
            StringBuffer sql = new StringBuffer();
            sql.append("SELECT * FROM OA_T_YFZX_SLLW j where t.pk_psndoc = j.pk_psndoc AND ( ");
            for (int i = 0; i <list.size() ; i++) {
                if(i!=0){
                    sql.append(" or ");
                }
                sql.append(column+"='"+list.get(i)+"' ");
                if(i==list.size()-1){
                    sql.append(" ) ");
                }
            }
            wrapper.exists(sql.toString());
        }

        String sql = "SELECT DISTINCT pk_psndoc FROM hr_dm_hi_psndoc_glbdef11";
        wrapper.inSql("pk_psndoc",sql);
        wrapper.orderByAsc("CORPSEQ","DEPTSEQ","SHOWORDER");
        IPage<Dm_num_cube> page = new Page<Dm_num_cube>(current, pagesize);
        IPage result = dmNumCubeService.highLevevlQuery(page,wrapper);

        return ResponseResult.success(result,null);
    }
}

package com.cjwsjy.talents.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author xuli2
 * @since 2019-07-15
 */
@TableName("hr_dm_num_cube")
public class Dm_num_cube implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("pk_psndoc")
    private String pk_psndoc;

    @TableField("code")
    private String code;

    @TableField("name")
    private String name;

    @TableField("sex")
    private String sex;

    @TableField("birthdate")
    private String birthdate;

    @TableField("id")
    private String id;

    @TableField("glbdef4")
    private String glbdef4;

    @TableField("glbdef5")
    private String glbdef5;

    @TableField("glbdef6")
    private String glbdef6;

    @TableField("nationality")
    private String nationality;

    @TableField("age")
    private Float age;

    @TableField("age_range")
    private String age_range;

    @TableField("workage_range")
    private String workage_range;

    @TableField("joinworkdate")
    private String joinworkdate;

    @TableField("glbdef28")
    private String glbdef28;

    @TableField("mobile")
    private String mobile;

    @TableField("email")
    private String email;

    @TableField("pk_org")
    private String pk_org;

    @TableField("pk_hrorg")
    private String pk_hrorg;

    @TableField("marital")
    private String marital;

    @TableField("glbdef21")
    private String glbdef21;

    @TableField("glbdef22")
    private String glbdef22;

    @TableField("glbdef33")
    private String glbdef33;

    @TableField("glbdef23")
    private String glbdef23;

    @TableField("polity")
    private String polity;

    @TableField("glbdef41")
    private String glbdef41;

    @TableField("edu")
    private String edu;

    @TableField("glbdef39")
    private String glbdef39;

    @TableField("glbdef37")
    private String glbdef37;

    @TableField("pk_dept")
    private String pk_dept;

    @TableField("pk_post")
    private String pk_post;

    @TableField("pk_postseries")
    private String pk_postseries;

    @TableField("pk_psncl")
    private String pk_psncl;

    @TableField("glbdef2")
    private String glbdef2;

    @TableField("zyzg")
    private String zyzg;

    @TableField("rylb")
    private String rylb;

    @TableField("analysisorg1")
    private String analysisorg1;

    @TableField("pk_org1")
    private String pk_org1;

    @TableField("analysisorg2")
    private String analysisorg2;

    @TableField("pk_org2")
    private String pk_org2;

    @TableField("analysisorg3")
    private String analysisorg3;

    @TableField("CORPSEQ")
    private String CORPSEQ;

    @TableField("DEPTSEQ")
    private String DEPTSEQ;

    @TableField("MNECODE")
    private String MNECODE;

    @TableField("edumemo")
    private String edumemo;

    @TableField("eduseq")
    private String eduseq;

    @TableField("showorder")
    private Integer showorder;

    @TableField("age_seq")
    private String age_seq;

    @TableField("WORKAGE_seq")
    private String WORKAGE_seq;

    @TableField("GLBDEF22_rank")
    private String GLBDEF22_rank;

    @TableField("GLBDEF23_rank")
    private Integer GLBDEF23_rank;

    @TableField("GLBDEF23_NAME")
    private String GLBDEF23_NAME;

    @TableField("GLBDEF41_NAME")
    private String GLBDEF41_NAME;

    @TableField("GLBDEF41_RANK")
    private Integer GLBDEF41_RANK;

    @TableField("school")
    private String school;

    @TableField("glbdef3")
    private String glbdef3;

    @TableField("zhuanye")
    private String zhuanye;

    @TableField("GLBDEF22_RAND")
    private String GLBDEF22_RAND;

    @TableField("GLBDEF23_RAND")
    private String GLBDEF23_RAND;

    @TableField("joinpolitydate")
    private String joinpolitydate;

    @TableField("glbdef51")
    private String glbdef51;

    @TableField("glbdef52")
    private String glbdef52;

    @TableField("glrc")
    private String glrc;

    public String getPk_psndoc() {
        return pk_psndoc;
    }

    public void setPk_psndoc(String pk_psndoc) {
        this.pk_psndoc = pk_psndoc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGlbdef4() {
        return glbdef4;
    }

    public void setGlbdef4(String glbdef4) {
        this.glbdef4 = glbdef4;
    }

    public String getGlbdef5() {
        return glbdef5;
    }

    public void setGlbdef5(String glbdef5) {
        this.glbdef5 = glbdef5;
    }

    public String getGlbdef6() {
        return glbdef6;
    }

    public void setGlbdef6(String glbdef6) {
        this.glbdef6 = glbdef6;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Float getAge() {
        return age;
    }

    public void setAge(Float age) {
        this.age = age;
    }

    public String getAge_range() {
        return age_range;
    }

    public void setAge_range(String age_range) {
        this.age_range = age_range;
    }

    public String getWorkage_range() {
        return workage_range;
    }

    public void setWorkage_range(String workage_range) {
        this.workage_range = workage_range;
    }

    public String getJoinworkdate() {
        return joinworkdate;
    }

    public void setJoinworkdate(String joinworkdate) {
        this.joinworkdate = joinworkdate;
    }

    public String getGlbdef28() {
        return glbdef28;
    }

    public void setGlbdef28(String glbdef28) {
        this.glbdef28 = glbdef28;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPk_org() {
        return pk_org;
    }

    public void setPk_org(String pk_org) {
        this.pk_org = pk_org;
    }

    public String getPk_hrorg() {
        return pk_hrorg;
    }

    public void setPk_hrorg(String pk_hrorg) {
        this.pk_hrorg = pk_hrorg;
    }

    public String getMarital() {
        return marital;
    }

    public void setMarital(String marital) {
        this.marital = marital;
    }

    public String getGlbdef21() {
        return glbdef21;
    }

    public void setGlbdef21(String glbdef21) {
        this.glbdef21 = glbdef21;
    }

    public String getGlbdef22() {
        return glbdef22;
    }

    public void setGlbdef22(String glbdef22) {
        this.glbdef22 = glbdef22;
    }

    public String getGlbdef33() {
        return glbdef33;
    }

    public void setGlbdef33(String glbdef33) {
        this.glbdef33 = glbdef33;
    }

    public String getGlbdef23() {
        return glbdef23;
    }

    public void setGlbdef23(String glbdef23) {
        this.glbdef23 = glbdef23;
    }

    public String getPolity() {
        return polity;
    }

    public void setPolity(String polity) {
        this.polity = polity;
    }

    public String getGlbdef41() {
        return glbdef41;
    }

    public void setGlbdef41(String glbdef41) {
        this.glbdef41 = glbdef41;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    public String getGlbdef39() {
        return glbdef39;
    }

    public void setGlbdef39(String glbdef39) {
        this.glbdef39 = glbdef39;
    }

    public String getGlbdef37() {
        return glbdef37;
    }

    public void setGlbdef37(String glbdef37) {
        this.glbdef37 = glbdef37;
    }

    public String getPk_dept() {
        return pk_dept;
    }

    public void setPk_dept(String pk_dept) {
        this.pk_dept = pk_dept;
    }

    public String getPk_post() {
        return pk_post;
    }

    public void setPk_post(String pk_post) {
        this.pk_post = pk_post;
    }

    public String getPk_postseries() {
        return pk_postseries;
    }

    public void setPk_postseries(String pk_postseries) {
        this.pk_postseries = pk_postseries;
    }

    public String getPk_psncl() {
        return pk_psncl;
    }

    public void setPk_psncl(String pk_psncl) {
        this.pk_psncl = pk_psncl;
    }

    public String getGlbdef2() {
        return glbdef2;
    }

    public void setGlbdef2(String glbdef2) {
        this.glbdef2 = glbdef2;
    }

    public String getZyzg() {
        return zyzg;
    }

    public void setZyzg(String zyzg) {
        this.zyzg = zyzg;
    }

    public String getRylb() {
        return rylb;
    }

    public void setRylb(String rylb) {
        this.rylb = rylb;
    }

    public String getAnalysisorg1() {
        return analysisorg1;
    }

    public void setAnalysisorg1(String analysisorg1) {
        this.analysisorg1 = analysisorg1;
    }

    public String getPk_org1() {
        return pk_org1;
    }

    public void setPk_org1(String pk_org1) {
        this.pk_org1 = pk_org1;
    }

    public String getAnalysisorg2() {
        return analysisorg2;
    }

    public void setAnalysisorg2(String analysisorg2) {
        this.analysisorg2 = analysisorg2;
    }

    public String getPk_org2() {
        return pk_org2;
    }

    public void setPk_org2(String pk_org2) {
        this.pk_org2 = pk_org2;
    }

    public String getAnalysisorg3() {
        return analysisorg3;
    }

    public void setAnalysisorg3(String analysisorg3) {
        this.analysisorg3 = analysisorg3;
    }

    public String getCORPSEQ() {
        return CORPSEQ;
    }

    public void setCORPSEQ(String CORPSEQ) {
        this.CORPSEQ = CORPSEQ;
    }

    public String getDEPTSEQ() {
        return DEPTSEQ;
    }

    public void setDEPTSEQ(String DEPTSEQ) {
        this.DEPTSEQ = DEPTSEQ;
    }

    public String getMNECODE() {
        return MNECODE;
    }

    public void setMNECODE(String MNECODE) {
        this.MNECODE = MNECODE;
    }

    public String getEdumemo() {
        return edumemo;
    }

    public void setEdumemo(String edumemo) {
        this.edumemo = edumemo;
    }

    public String getEduseq() {
        return eduseq;
    }

    public void setEduseq(String eduseq) {
        this.eduseq = eduseq;
    }

    public Integer getShoworder() {
        return showorder;
    }

    public void setShoworder(Integer showorder) {
        this.showorder = showorder;
    }

    public String getAge_seq() {
        return age_seq;
    }

    public void setAge_seq(String age_seq) {
        this.age_seq = age_seq;
    }

    public String getWORKAGE_seq() {
        return WORKAGE_seq;
    }

    public void setWORKAGE_seq(String WORKAGE_seq) {
        this.WORKAGE_seq = WORKAGE_seq;
    }

    public String getGLBDEF22_rank() {
        return GLBDEF22_rank;
    }

    public void setGLBDEF22_rank(String GLBDEF22_rank) {
        this.GLBDEF22_rank = GLBDEF22_rank;
    }

    public Integer getGLBDEF23_rank() {
        return GLBDEF23_rank;
    }

    public void setGLBDEF23_rank(Integer GLBDEF23_rank) {
        this.GLBDEF23_rank = GLBDEF23_rank;
    }

    public String getGLBDEF23_NAME() {
        return GLBDEF23_NAME;
    }

    public void setGLBDEF23_NAME(String GLBDEF23_NAME) {
        this.GLBDEF23_NAME = GLBDEF23_NAME;
    }

    public String getGLBDEF41_NAME() {
        return GLBDEF41_NAME;
    }

    public void setGLBDEF41_NAME(String GLBDEF41_NAME) {
        this.GLBDEF41_NAME = GLBDEF41_NAME;
    }

    public Integer getGLBDEF41_RANK() {
        return GLBDEF41_RANK;
    }

    public void setGLBDEF41_RANK(Integer GLBDEF41_RANK) {
        this.GLBDEF41_RANK = GLBDEF41_RANK;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getGlbdef3() {
        return glbdef3;
    }

    public void setGlbdef3(String glbdef3) {
        this.glbdef3 = glbdef3;
    }

    public String getZhuanye() {
        return zhuanye;
    }

    public void setZhuanye(String zhuanye) {
        this.zhuanye = zhuanye;
    }

    public String getGLBDEF22_RAND() {
        return GLBDEF22_RAND;
    }

    public void setGLBDEF22_RAND(String GLBDEF22_RAND) {
        this.GLBDEF22_RAND = GLBDEF22_RAND;
    }

    public String getGLBDEF23_RAND() {
        return GLBDEF23_RAND;
    }

    public void setGLBDEF23_RAND(String GLBDEF23_RAND) {
        this.GLBDEF23_RAND = GLBDEF23_RAND;
    }

    public String getJoinpolitydate() {
        return joinpolitydate;
    }

    public void setJoinpolitydate(String joinpolitydate) {
        this.joinpolitydate = joinpolitydate;
    }

    public String getGlbdef51() {
        return glbdef51;
    }

    public void setGlbdef51(String glbdef51) {
        this.glbdef51 = glbdef51;
    }

    public String getGlbdef52() {
        return glbdef52;
    }

    public void setGlbdef52(String glbdef52) {
        this.glbdef52 = glbdef52;
    }


    public String getGlrc() {
        return glrc;
    }

    public void setGlrc(String glrc) {
        this.glrc = glrc;
    }

    @Override
    public String toString() {
        return "Dm_num_cube{" +
        "pk_psndoc=" + pk_psndoc +
        ", code=" + code +
        ", name=" + name +
        ", sex=" + sex +
        ", birthdate=" + birthdate +
        ", id=" + id +
        ", glbdef4=" + glbdef4 +
        ", glbdef5=" + glbdef5 +
        ", glbdef6=" + glbdef6 +
        ", nationality=" + nationality +
        ", age=" + age +
        ", age_range=" + age_range +
        ", workage_range=" + workage_range +
        ", joinworkdate=" + joinworkdate +
        ", glbdef28=" + glbdef28 +
        ", mobile=" + mobile +
        ", email=" + email +
        ", pk_org=" + pk_org +
        ", pk_hrorg=" + pk_hrorg +
        ", marital=" + marital +
        ", glbdef21=" + glbdef21 +
        ", glbdef22=" + glbdef22 +
        ", glbdef33=" + glbdef33 +
        ", glbdef23=" + glbdef23 +
        ", polity=" + polity +
        ", glbdef41=" + glbdef41 +
        ", edu=" + edu +
        ", glbdef39=" + glbdef39 +
        ", glbdef37=" + glbdef37 +
        ", pk_dept=" + pk_dept +
        ", pk_post=" + pk_post +
        ", pk_postseries=" + pk_postseries +
        ", pk_psncl=" + pk_psncl +
        ", glbdef2=" + glbdef2 +
        ", zyzg=" + zyzg +
        ", rylb=" + rylb +
        ", analysisorg1=" + analysisorg1 +
        ", pk_org1=" + pk_org1 +
        ", analysisorg2=" + analysisorg2 +
        ", pk_org2=" + pk_org2 +
        ", analysisorg3=" + analysisorg3 +
        ", CORPSEQ=" + CORPSEQ +
        ", DEPTSEQ=" + DEPTSEQ +
        ", MNECODE=" + MNECODE +
        ", edumemo=" + edumemo +
        ", eduseq=" + eduseq +
        ", showorder=" + showorder +
        ", age_seq=" + age_seq +
        ", WORKAGE_seq=" + WORKAGE_seq +
        ", GLBDEF22_rank=" + GLBDEF22_rank +
        ", GLBDEF23_rank=" + GLBDEF23_rank +
        ", GLBDEF23_NAME=" + GLBDEF23_NAME +
        ", GLBDEF41_NAME=" + GLBDEF41_NAME +
        ", GLBDEF41_RANK=" + GLBDEF41_RANK +
        ", school=" + school +
        ", glbdef3=" + glbdef3 +
        ", zhuanye=" + zhuanye +
        ", GLBDEF22_RAND=" + GLBDEF22_RAND +
        ", GLBDEF23_RAND=" + GLBDEF23_RAND +
        ", joinpolitydate=" + joinpolitydate +
        ", glbdef51=" + glbdef51 +
        ", glbdef52=" + glbdef52 +
        ", glrc=" + glrc +
        "}";
    }
}

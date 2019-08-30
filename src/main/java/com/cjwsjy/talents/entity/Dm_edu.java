package com.cjwsjy.talents.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author xuli2
 * @since 2019-07-17
 */
@TableName("hr_dm_edu")
public class Dm_edu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("begindate")
    private String begindate;

    @TableField("enddate")
    private String enddate;

    @TableField("school")
    private String school;

    @TableField("schooltype")
    private String schooltype;

    @TableField("studymode")
    private String studymode;

    @TableField("education")
    private String education;

    @TableField("pk_degree")
    private String pk_degree;

    @TableField("glbdef1")
    private String glbdef1;

    @TableField("degreedate")
    private String degreedate;

    @TableField("degreeunit")
    private String degreeunit;

    @TableField("educationctifcode")
    private String educationctifcode;

    @TableField("certifcode")
    private String certifcode;

    @TableField("lasteducation")
    private String lasteducation;

    @TableField("recordnum")
    private Integer recordnum;

    @TableField("pk_psndoc")
    private String pk_psndoc;

    @TableField("pk_psndoc_sub")
    private String pk_psndoc_sub;

    @TableField("glbdef2")
    private String glbdef2;

    @TableField("glbdef3")
    private String glbdef3;

    @TableField("glbdef4")
    private String glbdef4;


    public String getBegindate() {
        return begindate;
    }

    public void setBegindate(String begindate) {
        this.begindate = begindate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSchooltype() {
        return schooltype;
    }

    public void setSchooltype(String schooltype) {
        this.schooltype = schooltype;
    }

    public String getStudymode() {
        return studymode;
    }

    public void setStudymode(String studymode) {
        this.studymode = studymode;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPk_degree() {
        return pk_degree;
    }

    public void setPk_degree(String pk_degree) {
        this.pk_degree = pk_degree;
    }

    public String getGlbdef1() {
        return glbdef1;
    }

    public void setGlbdef1(String glbdef1) {
        this.glbdef1 = glbdef1;
    }

    public String getDegreedate() {
        return degreedate;
    }

    public void setDegreedate(String degreedate) {
        this.degreedate = degreedate;
    }

    public String getDegreeunit() {
        return degreeunit;
    }

    public void setDegreeunit(String degreeunit) {
        this.degreeunit = degreeunit;
    }

    public String getEducationctifcode() {
        return educationctifcode;
    }

    public void setEducationctifcode(String educationctifcode) {
        this.educationctifcode = educationctifcode;
    }

    public String getCertifcode() {
        return certifcode;
    }

    public void setCertifcode(String certifcode) {
        this.certifcode = certifcode;
    }

    public String getLasteducation() {
        return lasteducation;
    }

    public void setLasteducation(String lasteducation) {
        this.lasteducation = lasteducation;
    }

    public Integer getRecordnum() {
        return recordnum;
    }

    public void setRecordnum(Integer recordnum) {
        this.recordnum = recordnum;
    }

    public String getPk_psndoc() {
        return pk_psndoc;
    }

    public void setPk_psndoc(String pk_psndoc) {
        this.pk_psndoc = pk_psndoc;
    }

    public String getPk_psndoc_sub() {
        return pk_psndoc_sub;
    }

    public void setPk_psndoc_sub(String pk_psndoc_sub) {
        this.pk_psndoc_sub = pk_psndoc_sub;
    }

    public String getGlbdef2() {
        return glbdef2;
    }

    public void setGlbdef2(String glbdef2) {
        this.glbdef2 = glbdef2;
    }

    public String getGlbdef3() {
        return glbdef3;
    }

    public void setGlbdef3(String glbdef3) {
        this.glbdef3 = glbdef3;
    }

    public String getGlbdef4() {
        return glbdef4;
    }

    public void setGlbdef4(String glbdef4) {
        this.glbdef4 = glbdef4;
    }

    @Override
    public String toString() {
        return "Dm_edu{" +
        "begindate=" + begindate +
        ", enddate=" + enddate +
        ", school=" + school +
        ", schooltype=" + schooltype +
        ", studymode=" + studymode +
        ", education=" + education +
        ", pk_degree=" + pk_degree +
        ", glbdef1=" + glbdef1 +
        ", degreedate=" + degreedate +
        ", degreeunit=" + degreeunit +
        ", educationctifcode=" + educationctifcode +
        ", certifcode=" + certifcode +
        ", lasteducation=" + lasteducation +
        ", recordnum=" + recordnum +
        ", pk_psndoc=" + pk_psndoc +
        ", pk_psndoc_sub=" + pk_psndoc_sub +
        ", glbdef2=" + glbdef2 +
        ", glbdef3=" + glbdef3 +
        ", glbdef4=" + glbdef4 +
        "}";
    }
}

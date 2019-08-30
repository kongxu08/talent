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
 * @since 2019-08-09
 */
@TableName("hr_stg_hi_psndoc_glbdef10")
public class Stg_hi_psndoc_glbdef10 implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("begindate")
    private String begindate;

    @TableField("creationtime")
    private String creationtime;

    @TableField("creator")
    private String creator;

    @TableField("enddate")
    private String enddate;

    @TableField("glbdef1")
    private String glbdef1;

    @TableField("glbdef10")
    private String glbdef10;

    @TableField("glbdef2")
    private String glbdef2;

    @TableField("glbdef3")
    private String glbdef3;

    @TableField("glbdef4")
    private String glbdef4;

    @TableField("glbdef5")
    private String glbdef5;

    @TableField("glbdef6")
    private String glbdef6;

    @TableField("glbdef7")
    private String glbdef7;

    @TableField("glbdef8")
    private String glbdef8;

    @TableField("glbdef9")
    private String glbdef9;

    @TableField("lastflag")
    private String lastflag;

    @TableField("modifiedtime")
    private String modifiedtime;

    @TableField("modifier")
    private String modifier;

    @TableField("pk_psndoc")
    private String pk_psndoc;

    @TableField("pk_psndoc_sub")
    private String pk_psndoc_sub;

    @TableField("recordnum")
    private Integer recordnum;

    @TableField("ts")
    private String ts;

    @TableField("dr")
    private Integer dr;

    @TableField("glbdef11")
    private String glbdef11;


    public String getBegindate() {
        return begindate;
    }

    public void setBegindate(String begindate) {
        this.begindate = begindate;
    }

    public String getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(String creationtime) {
        this.creationtime = creationtime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getGlbdef1() {
        return glbdef1;
    }

    public void setGlbdef1(String glbdef1) {
        this.glbdef1 = glbdef1;
    }

    public String getGlbdef10() {
        return glbdef10;
    }

    public void setGlbdef10(String glbdef10) {
        this.glbdef10 = glbdef10;
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

    public String getGlbdef7() {
        return glbdef7;
    }

    public void setGlbdef7(String glbdef7) {
        this.glbdef7 = glbdef7;
    }

    public String getGlbdef8() {
        return glbdef8;
    }

    public void setGlbdef8(String glbdef8) {
        this.glbdef8 = glbdef8;
    }

    public String getGlbdef9() {
        return glbdef9;
    }

    public void setGlbdef9(String glbdef9) {
        this.glbdef9 = glbdef9;
    }

    public String getLastflag() {
        return lastflag;
    }

    public void setLastflag(String lastflag) {
        this.lastflag = lastflag;
    }

    public String getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(String modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
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

    public Integer getRecordnum() {
        return recordnum;
    }

    public void setRecordnum(Integer recordnum) {
        this.recordnum = recordnum;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public Integer getDr() {
        return dr;
    }

    public void setDr(Integer dr) {
        this.dr = dr;
    }

    public String getGlbdef11() {
        return glbdef11;
    }

    public void setGlbdef11(String glbdef11) {
        this.glbdef11 = glbdef11;
    }

    @Override
    public String toString() {
        return "Stg_hi_psndoc_glbdef10{" +
        "begindate=" + begindate +
        ", creationtime=" + creationtime +
        ", creator=" + creator +
        ", enddate=" + enddate +
        ", glbdef1=" + glbdef1 +
        ", glbdef10=" + glbdef10 +
        ", glbdef2=" + glbdef2 +
        ", glbdef3=" + glbdef3 +
        ", glbdef4=" + glbdef4 +
        ", glbdef5=" + glbdef5 +
        ", glbdef6=" + glbdef6 +
        ", glbdef7=" + glbdef7 +
        ", glbdef8=" + glbdef8 +
        ", glbdef9=" + glbdef9 +
        ", lastflag=" + lastflag +
        ", modifiedtime=" + modifiedtime +
        ", modifier=" + modifier +
        ", pk_psndoc=" + pk_psndoc +
        ", pk_psndoc_sub=" + pk_psndoc_sub +
        ", recordnum=" + recordnum +
        ", ts=" + ts +
        ", dr=" + dr +
        ", glbdef11=" + glbdef11 +
        "}";
    }
}

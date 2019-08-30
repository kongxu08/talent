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
 * @since 2019-08-07
 */
@TableName("hr_dm_zyjx_post")
public class Dm_zyjx_post implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("pk_psndoc_sub")
    private String pk_psndoc_sub;

    @TableField("pk_psndoc")
    private String pk_psndoc;

    @TableField("glbdef10")
    private String glbdef10;

    @TableField("glbdef11")
    private String glbdef11;

    @TableField("glbdef1")
    private String glbdef1;

    @TableField("recordnum")
    private Integer recordnum;

    @TableField("glbdef2")
    private String glbdef2;

    @TableField("lastflag")
    private String lastflag;

    @TableField("glbdef3")
    private String glbdef3;

    @TableField("glbdef4")
    private String glbdef4;

    @TableField("glbdef12")
    private String glbdef12;

    @TableField("begindate")
    private String begindate;

    @TableField("enddate")
    private String enddate;

    @TableField("glbdef5")
    private String glbdef5;

    @TableField("glbdef6")
    private String glbdef6;

    @TableField("glbdef7")
    private String glbdef7;

    @TableField("glbdef8")
    private String glbdef8;

    @TableField("glbdef13")
    private String glbdef13;

    @TableField("glbdef9")
    private String glbdef9;


    public String getPk_psndoc_sub() {
        return pk_psndoc_sub;
    }

    public void setPk_psndoc_sub(String pk_psndoc_sub) {
        this.pk_psndoc_sub = pk_psndoc_sub;
    }

    public String getPk_psndoc() {
        return pk_psndoc;
    }

    public void setPk_psndoc(String pk_psndoc) {
        this.pk_psndoc = pk_psndoc;
    }

    public String getGlbdef10() {
        return glbdef10;
    }

    public void setGlbdef10(String glbdef10) {
        this.glbdef10 = glbdef10;
    }

    public String getGlbdef11() {
        return glbdef11;
    }

    public void setGlbdef11(String glbdef11) {
        this.glbdef11 = glbdef11;
    }

    public String getGlbdef1() {
        return glbdef1;
    }

    public void setGlbdef1(String glbdef1) {
        this.glbdef1 = glbdef1;
    }

    public Integer getRecordnum() {
        return recordnum;
    }

    public void setRecordnum(Integer recordnum) {
        this.recordnum = recordnum;
    }

    public String getGlbdef2() {
        return glbdef2;
    }

    public void setGlbdef2(String glbdef2) {
        this.glbdef2 = glbdef2;
    }

    public String getLastflag() {
        return lastflag;
    }

    public void setLastflag(String lastflag) {
        this.lastflag = lastflag;
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

    public String getGlbdef12() {
        return glbdef12;
    }

    public void setGlbdef12(String glbdef12) {
        this.glbdef12 = glbdef12;
    }

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

    public String getGlbdef13() {
        return glbdef13;
    }

    public void setGlbdef13(String glbdef13) {
        this.glbdef13 = glbdef13;
    }

    public String getGlbdef9() {
        return glbdef9;
    }

    public void setGlbdef9(String glbdef9) {
        this.glbdef9 = glbdef9;
    }

    @Override
    public String toString() {
        return "Dm_zyjx_post{" +
        "pk_psndoc_sub=" + pk_psndoc_sub +
        ", pk_psndoc=" + pk_psndoc +
        ", glbdef10=" + glbdef10 +
        ", glbdef11=" + glbdef11 +
        ", glbdef1=" + glbdef1 +
        ", recordnum=" + recordnum +
        ", glbdef2=" + glbdef2 +
        ", lastflag=" + lastflag +
        ", glbdef3=" + glbdef3 +
        ", glbdef4=" + glbdef4 +
        ", glbdef12=" + glbdef12 +
        ", begindate=" + begindate +
        ", enddate=" + enddate +
        ", glbdef5=" + glbdef5 +
        ", glbdef6=" + glbdef6 +
        ", glbdef7=" + glbdef7 +
        ", glbdef8=" + glbdef8 +
        ", glbdef13=" + glbdef13 +
        ", glbdef9=" + glbdef9 +
        "}";
    }
}

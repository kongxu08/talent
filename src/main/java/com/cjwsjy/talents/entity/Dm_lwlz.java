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
 * @since 2019-07-24
 */
@TableName("hr_dm_lwlz")
public class Dm_lwlz implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("begindate")
    private String begindate;

    @TableField("enddate")
    private String enddate;

    @TableField("glbdef1")
    private String glbdef1;

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

    @TableField("lastflag")
    private String lastflag;

    @TableField("pk_psndoc")
    private String pk_psndoc;


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

    public String getGlbdef1() {
        return glbdef1;
    }

    public void setGlbdef1(String glbdef1) {
        this.glbdef1 = glbdef1;
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

    public String getLastflag() {
        return lastflag;
    }

    public void setLastflag(String lastflag) {
        this.lastflag = lastflag;
    }

    public String getPk_psndoc() {
        return pk_psndoc;
    }

    public void setPk_psndoc(String pk_psndoc) {
        this.pk_psndoc = pk_psndoc;
    }

    @Override
    public String toString() {
        return "Dm_lwlz{" +
        "begindate=" + begindate +
        ", enddate=" + enddate +
        ", glbdef1=" + glbdef1 +
        ", glbdef2=" + glbdef2 +
        ", glbdef3=" + glbdef3 +
        ", glbdef4=" + glbdef4 +
        ", glbdef5=" + glbdef5 +
        ", glbdef6=" + glbdef6 +
        ", lastflag=" + lastflag +
        ", pk_psndoc=" + pk_psndoc +
        "}";
    }
}

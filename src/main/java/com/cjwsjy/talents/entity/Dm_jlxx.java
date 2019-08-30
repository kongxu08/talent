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
@TableName("hr_dm_jlxx")
public class Dm_jlxx implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("glbdef3")
    private String glbdef3;

    @TableField("glbdef5")
    private String glbdef5;

    @TableField("encourorg")
    private String encourorg;

    @TableField("glbdef4")
    private String glbdef4;

    @TableField("encourmatter")
    private String encourmatter;

    @TableField("glbdef1")
    private String glbdef1;

    @TableField("glbdef2")
    private String glbdef2;

    @TableField("pk_psndoc_sub")
    private String pk_psndoc_sub;

    @TableField("encourdate")
    private String encourdate;

    @TableField("encourtype")
    private String encourtype;

    @TableField("encourrank")
    private String encourrank;

    @TableField("encourmeas")
    private String encourmeas;

    @TableField("recordnum")
    private Integer recordnum;

    @TableField("pk_psndoc")
    private String pk_psndoc;


    public String getGlbdef3() {
        return glbdef3;
    }

    public void setGlbdef3(String glbdef3) {
        this.glbdef3 = glbdef3;
    }

    public String getGlbdef5() {
        return glbdef5;
    }

    public void setGlbdef5(String glbdef5) {
        this.glbdef5 = glbdef5;
    }

    public String getEncourorg() {
        return encourorg;
    }

    public void setEncourorg(String encourorg) {
        this.encourorg = encourorg;
    }

    public String getGlbdef4() {
        return glbdef4;
    }

    public void setGlbdef4(String glbdef4) {
        this.glbdef4 = glbdef4;
    }

    public String getEncourmatter() {
        return encourmatter;
    }

    public void setEncourmatter(String encourmatter) {
        this.encourmatter = encourmatter;
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

    public String getPk_psndoc_sub() {
        return pk_psndoc_sub;
    }

    public void setPk_psndoc_sub(String pk_psndoc_sub) {
        this.pk_psndoc_sub = pk_psndoc_sub;
    }

    public String getEncourdate() {
        return encourdate;
    }

    public void setEncourdate(String encourdate) {
        this.encourdate = encourdate;
    }

    public String getEncourtype() {
        return encourtype;
    }

    public void setEncourtype(String encourtype) {
        this.encourtype = encourtype;
    }

    public String getEncourrank() {
        return encourrank;
    }

    public void setEncourrank(String encourrank) {
        this.encourrank = encourrank;
    }

    public String getEncourmeas() {
        return encourmeas;
    }

    public void setEncourmeas(String encourmeas) {
        this.encourmeas = encourmeas;
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

    @Override
    public String toString() {
        return "Dm_jlxx{" +
        "glbdef3=" + glbdef3 +
        ", glbdef5=" + glbdef5 +
        ", encourorg=" + encourorg +
        ", glbdef4=" + glbdef4 +
        ", encourmatter=" + encourmatter +
        ", glbdef1=" + glbdef1 +
        ", glbdef2=" + glbdef2 +
        ", pk_psndoc_sub=" + pk_psndoc_sub +
        ", encourdate=" + encourdate +
        ", encourtype=" + encourtype +
        ", encourrank=" + encourrank +
        ", encourmeas=" + encourmeas +
        ", recordnum=" + recordnum +
        ", pk_psndoc=" + pk_psndoc +
        "}";
    }
}

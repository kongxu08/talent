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
@TableName("hr_dm_psndoc_work")
public class Dm_psndoc_work implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("begindate")
    private String begindate;

    @TableField("bg_check")
    private String bg_check;

    @TableField("certifier")
    private String certifier;

    @TableField("certiphone")
    private String certiphone;

    @TableField("creationtime")
    private String creationtime;

    @TableField("creator")
    private String creator;

    @TableField("dimission_reason")
    private String dimission_reason;

    @TableField("dr")
    private Integer dr;

    @TableField("enddate")
    private String enddate;

    @TableField("lastflag")
    private String lastflag;

    @TableField("linkphone")
    private String linkphone;

    @TableField("memo")
    private String memo;

    @TableField("modifiedtime")
    private String modifiedtime;

    @TableField("modifier")
    private String modifier;

    @TableField("pk_group")
    private String pk_group;

    @TableField("pk_org")
    private String pk_org;

    @TableField("pk_psndoc")
    private String pk_psndoc;

    @TableField("pk_psndoc_sub")
    private String pk_psndoc_sub;

    @TableField("pk_psnjob")
    private String pk_psnjob;

    @TableField("pk_psnorg")
    private String pk_psnorg;

    @TableField("recordnum")
    private Integer recordnum;

    @TableField("ts")
    private String ts;

    @TableField("work_addr")
    private String work_addr;

    @TableField("workachive")
    private String workachive;

    @TableField("workcorp")
    private String workcorp;

    @TableField("workdept")
    private String workdept;

    @TableField("workduty")
    private String workduty;

    @TableField("workjob")
    private String workjob;

    @TableField("workpost")
    private String workpost;


    public String getBegindate() {
        return begindate;
    }

    public void setBegindate(String begindate) {
        this.begindate = begindate;
    }

    public String getBg_check() {
        return bg_check;
    }

    public void setBg_check(String bg_check) {
        this.bg_check = bg_check;
    }

    public String getCertifier() {
        return certifier;
    }

    public void setCertifier(String certifier) {
        this.certifier = certifier;
    }

    public String getCertiphone() {
        return certiphone;
    }

    public void setCertiphone(String certiphone) {
        this.certiphone = certiphone;
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

    public String getDimission_reason() {
        return dimission_reason;
    }

    public void setDimission_reason(String dimission_reason) {
        this.dimission_reason = dimission_reason;
    }

    public Integer getDr() {
        return dr;
    }

    public void setDr(Integer dr) {
        this.dr = dr;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getLastflag() {
        return lastflag;
    }

    public void setLastflag(String lastflag) {
        this.lastflag = lastflag;
    }

    public String getLinkphone() {
        return linkphone;
    }

    public void setLinkphone(String linkphone) {
        this.linkphone = linkphone;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
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

    public String getPk_group() {
        return pk_group;
    }

    public void setPk_group(String pk_group) {
        this.pk_group = pk_group;
    }

    public String getPk_org() {
        return pk_org;
    }

    public void setPk_org(String pk_org) {
        this.pk_org = pk_org;
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

    public String getPk_psnjob() {
        return pk_psnjob;
    }

    public void setPk_psnjob(String pk_psnjob) {
        this.pk_psnjob = pk_psnjob;
    }

    public String getPk_psnorg() {
        return pk_psnorg;
    }

    public void setPk_psnorg(String pk_psnorg) {
        this.pk_psnorg = pk_psnorg;
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

    public String getWork_addr() {
        return work_addr;
    }

    public void setWork_addr(String work_addr) {
        this.work_addr = work_addr;
    }

    public String getWorkachive() {
        return workachive;
    }

    public void setWorkachive(String workachive) {
        this.workachive = workachive;
    }

    public String getWorkcorp() {
        return workcorp;
    }

    public void setWorkcorp(String workcorp) {
        this.workcorp = workcorp;
    }

    public String getWorkdept() {
        return workdept;
    }

    public void setWorkdept(String workdept) {
        this.workdept = workdept;
    }

    public String getWorkduty() {
        return workduty;
    }

    public void setWorkduty(String workduty) {
        this.workduty = workduty;
    }

    public String getWorkjob() {
        return workjob;
    }

    public void setWorkjob(String workjob) {
        this.workjob = workjob;
    }

    public String getWorkpost() {
        return workpost;
    }

    public void setWorkpost(String workpost) {
        this.workpost = workpost;
    }

    @Override
    public String toString() {
        return "Dm_psndoc_work{" +
        "begindate=" + begindate +
        ", bg_check=" + bg_check +
        ", certifier=" + certifier +
        ", certiphone=" + certiphone +
        ", creationtime=" + creationtime +
        ", creator=" + creator +
        ", dimission_reason=" + dimission_reason +
        ", dr=" + dr +
        ", enddate=" + enddate +
        ", lastflag=" + lastflag +
        ", linkphone=" + linkphone +
        ", memo=" + memo +
        ", modifiedtime=" + modifiedtime +
        ", modifier=" + modifier +
        ", pk_group=" + pk_group +
        ", pk_org=" + pk_org +
        ", pk_psndoc=" + pk_psndoc +
        ", pk_psndoc_sub=" + pk_psndoc_sub +
        ", pk_psnjob=" + pk_psnjob +
        ", pk_psnorg=" + pk_psnorg +
        ", recordnum=" + recordnum +
        ", ts=" + ts +
        ", work_addr=" + work_addr +
        ", workachive=" + workachive +
        ", workcorp=" + workcorp +
        ", workdept=" + workdept +
        ", workduty=" + workduty +
        ", workjob=" + workjob +
        ", workpost=" + workpost +
        "}";
    }
}

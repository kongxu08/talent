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
 * @since 2019-07-26
 */
@TableName("OA_T_YFZX_SLLW")
public class T_YFZX_SLLW implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("ID")
    private String ID;

    @TableField("FSFL")
    private String FSFL;

    @TableField("FSBT")
    private String FSBT;

    @TableField("FSZZ")
    private String FSZZ;

    @TableField("FSQK")
    private String FSQK;

    @TableField("FSSJK")
    private String FSSJK;

    @TableField("FDFXSJ")
    private String FDFXSJ;

    @TableField("FDSLSJ")
    private String FDSLSJ;

    @TableField("FSDW")
    private String FSDW;

    @TableField("FSRCDJH")
    private String FSRCDJH;

    @TableField("FSBZ")
    private String FSBZ;

    @TableField("FDCREATETIME")
    private String FDCREATETIME;

    @TableField("FSCREATEUSERID")
    private String FSCREATEUSERID;

    @TableField("FSCREATEUSERNAME")
    private String FSCREATEUSERNAME;

    @TableField("FSCREATEDEPTID")
    private String FSCREATEDEPTID;

    @TableField("FSCREATEDEPTNAME")
    private String FSCREATEDEPTNAME;

    @TableField("pk_psndoc")
    private String pk_psndoc;

    @TableField("seq")
    private String seq;


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFSFL() {
        return FSFL;
    }

    public void setFSFL(String FSFL) {
        this.FSFL = FSFL;
    }

    public String getFSBT() {
        return FSBT;
    }

    public void setFSBT(String FSBT) {
        this.FSBT = FSBT;
    }

    public String getFSZZ() {
        return FSZZ;
    }

    public void setFSZZ(String FSZZ) {
        this.FSZZ = FSZZ;
    }

    public String getFSQK() {
        return FSQK;
    }

    public void setFSQK(String FSQK) {
        this.FSQK = FSQK;
    }

    public String getFSSJK() {
        return FSSJK;
    }

    public void setFSSJK(String FSSJK) {
        this.FSSJK = FSSJK;
    }

    public String getFDFXSJ() {
        return FDFXSJ;
    }

    public void setFDFXSJ(String FDFXSJ) {
        this.FDFXSJ = FDFXSJ;
    }

    public String getFDSLSJ() {
        return FDSLSJ;
    }

    public void setFDSLSJ(String FDSLSJ) {
        this.FDSLSJ = FDSLSJ;
    }

    public String getFSDW() {
        return FSDW;
    }

    public void setFSDW(String FSDW) {
        this.FSDW = FSDW;
    }

    public String getFSRCDJH() {
        return FSRCDJH;
    }

    public void setFSRCDJH(String FSRCDJH) {
        this.FSRCDJH = FSRCDJH;
    }

    public String getFSBZ() {
        return FSBZ;
    }

    public void setFSBZ(String FSBZ) {
        this.FSBZ = FSBZ;
    }

    public String getFDCREATETIME() {
        return FDCREATETIME;
    }

    public void setFDCREATETIME(String FDCREATETIME) {
        this.FDCREATETIME = FDCREATETIME;
    }

    public String getFSCREATEUSERID() {
        return FSCREATEUSERID;
    }

    public void setFSCREATEUSERID(String FSCREATEUSERID) {
        this.FSCREATEUSERID = FSCREATEUSERID;
    }

    public String getFSCREATEUSERNAME() {
        return FSCREATEUSERNAME;
    }

    public void setFSCREATEUSERNAME(String FSCREATEUSERNAME) {
        this.FSCREATEUSERNAME = FSCREATEUSERNAME;
    }

    public String getFSCREATEDEPTID() {
        return FSCREATEDEPTID;
    }

    public void setFSCREATEDEPTID(String FSCREATEDEPTID) {
        this.FSCREATEDEPTID = FSCREATEDEPTID;
    }

    public String getFSCREATEDEPTNAME() {
        return FSCREATEDEPTNAME;
    }

    public void setFSCREATEDEPTNAME(String FSCREATEDEPTNAME) {
        this.FSCREATEDEPTNAME = FSCREATEDEPTNAME;
    }

    public String getPk_psndoc() {
        return pk_psndoc;
    }

    public void setPk_psndoc(String pk_psndoc) {
        this.pk_psndoc = pk_psndoc;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    @Override
    public String toString() {
        return "T_YFZX_SLLW{" +
        "ID=" + ID +
        ", FSFL=" + FSFL +
        ", FSBT=" + FSBT +
        ", FSZZ=" + FSZZ +
        ", FSQK=" + FSQK +
        ", FSSJK=" + FSSJK +
        ", FDFXSJ=" + FDFXSJ +
        ", FDSLSJ=" + FDSLSJ +
        ", FSDW=" + FSDW +
        ", FSRCDJH=" + FSRCDJH +
        ", FSBZ=" + FSBZ +
        ", FDCREATETIME=" + FDCREATETIME +
        ", FSCREATEUSERID=" + FSCREATEUSERID +
        ", FSCREATEUSERNAME=" + FSCREATEUSERNAME +
        ", FSCREATEDEPTID=" + FSCREATEDEPTID +
        ", FSCREATEDEPTNAME=" + FSCREATEDEPTNAME +
        ", pk_psndoc=" + pk_psndoc +
        ", seq=" + seq +
        "}";
    }
}

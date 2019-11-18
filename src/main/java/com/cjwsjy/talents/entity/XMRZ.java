package com.cjwsjy.talents.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 项目任职信息
 * </p>
 *
 * @author xuli2
 * @since 2019-11-18
 */
@TableName("HR_DM_XMRZ")
public class XMRZ implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("PK_PSNDOC_SUB")
    private String PK_PSNDOC_SUB;

    @TableField("PK_PSNDOC")
    private String PK_PSNDOC;

    @TableField("GLBDEF1")
    private String GLBDEF1;

    @TableField("GLBDEF7")
    private String GLBDEF7;

    @TableField("GLBDEF2")
    private String GLBDEF2;

    @TableField("RECORDNUM")
    private Integer RECORDNUM;

    @TableField("GLBDEF3")
    private String GLBDEF3;

    @TableField("LASTFLAG")
    private String LASTFLAG;

    @TableField("GLBDEF4")
    private String GLBDEF4;

    @TableField("GLBDEF5")
    private String GLBDEF5;

    @TableField("GLBDEF6")
    private String GLBDEF6;

    @TableField("GLBDEF8")
    private String GLBDEF8;

    @TableField("glbdef9")
    private String glbdef9;


    public String getPK_PSNDOC_SUB() {
        return PK_PSNDOC_SUB;
    }

    public void setPK_PSNDOC_SUB(String PK_PSNDOC_SUB) {
        this.PK_PSNDOC_SUB = PK_PSNDOC_SUB;
    }

    public String getPK_PSNDOC() {
        return PK_PSNDOC;
    }

    public void setPK_PSNDOC(String PK_PSNDOC) {
        this.PK_PSNDOC = PK_PSNDOC;
    }

    public String getGLBDEF1() {
        return GLBDEF1;
    }

    public void setGLBDEF1(String GLBDEF1) {
        this.GLBDEF1 = GLBDEF1;
    }

    public String getGLBDEF7() {
        return GLBDEF7;
    }

    public void setGLBDEF7(String GLBDEF7) {
        this.GLBDEF7 = GLBDEF7;
    }

    public String getGLBDEF2() {
        return GLBDEF2;
    }

    public void setGLBDEF2(String GLBDEF2) {
        this.GLBDEF2 = GLBDEF2;
    }

    public Integer getRECORDNUM() {
        return RECORDNUM;
    }

    public void setRECORDNUM(Integer RECORDNUM) {
        this.RECORDNUM = RECORDNUM;
    }

    public String getGLBDEF3() {
        return GLBDEF3;
    }

    public void setGLBDEF3(String GLBDEF3) {
        this.GLBDEF3 = GLBDEF3;
    }

    public String getLASTFLAG() {
        return LASTFLAG;
    }

    public void setLASTFLAG(String LASTFLAG) {
        this.LASTFLAG = LASTFLAG;
    }

    public String getGLBDEF4() {
        return GLBDEF4;
    }

    public void setGLBDEF4(String GLBDEF4) {
        this.GLBDEF4 = GLBDEF4;
    }

    public String getGLBDEF5() {
        return GLBDEF5;
    }

    public void setGLBDEF5(String GLBDEF5) {
        this.GLBDEF5 = GLBDEF5;
    }

    public String getGLBDEF6() {
        return GLBDEF6;
    }

    public void setGLBDEF6(String GLBDEF6) {
        this.GLBDEF6 = GLBDEF6;
    }

    public String getGLBDEF8() {
        return GLBDEF8;
    }

    public void setGLBDEF8(String GLBDEF8) {
        this.GLBDEF8 = GLBDEF8;
    }

    public String getGlbdef9() {
        return glbdef9;
    }

    public void setGlbdef9(String glbdef9) {
        this.glbdef9 = glbdef9;
    }

    @Override
    public String toString() {
        return "XMRZ{" +
        "PK_PSNDOC_SUB=" + PK_PSNDOC_SUB +
        ", PK_PSNDOC=" + PK_PSNDOC +
        ", GLBDEF1=" + GLBDEF1 +
        ", GLBDEF7=" + GLBDEF7 +
        ", GLBDEF2=" + GLBDEF2 +
        ", RECORDNUM=" + RECORDNUM +
        ", GLBDEF3=" + GLBDEF3 +
        ", LASTFLAG=" + LASTFLAG +
        ", GLBDEF4=" + GLBDEF4 +
        ", GLBDEF5=" + GLBDEF5 +
        ", GLBDEF6=" + GLBDEF6 +
        ", GLBDEF8=" + GLBDEF8 +
        ", glbdef9=" + glbdef9 +
        "}";
    }
}

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
@TableName("OA_DM_ZLXX")
public class DM_ZLXX implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("fszlh")
    private String fszlh;

    @TableField("FSZSZLMC")
    private String FSZSZLMC;

    @TableField("FSSQZLLX")
    private String FSSQZLLX;

    @TableField("FDGJSQR")
    private String FDGJSQR;

    @TableField("FDGJSQRZ")
    private String FDGJSQRZ;

    @TableField("FSRYGH")
    private String FSRYGH;

    @TableField("FSRYXM")
    private String FSRYXM;

    @TableField("FSZYGX")
    private String FSZYGX;

    @TableField("FIGXL")
    private Double FIGXL;

    @TableField("fipx")
    private String fipx;

    @TableField("pk_psndoc")
    private String pk_psndoc;


    public String getFszlh() {
        return fszlh;
    }

    public void setFszlh(String fszlh) {
        this.fszlh = fszlh;
    }

    public String getFSZSZLMC() {
        return FSZSZLMC;
    }

    public void setFSZSZLMC(String FSZSZLMC) {
        this.FSZSZLMC = FSZSZLMC;
    }

    public String getFSSQZLLX() {
        return FSSQZLLX;
    }

    public void setFSSQZLLX(String FSSQZLLX) {
        this.FSSQZLLX = FSSQZLLX;
    }

    public String getFDGJSQR() {
        return FDGJSQR;
    }

    public void setFDGJSQR(String FDGJSQR) {
        this.FDGJSQR = FDGJSQR;
    }

    public String getFDGJSQRZ() {
        return FDGJSQRZ;
    }

    public void setFDGJSQRZ(String FDGJSQRZ) {
        this.FDGJSQRZ = FDGJSQRZ;
    }

    public String getFSRYGH() {
        return FSRYGH;
    }

    public void setFSRYGH(String FSRYGH) {
        this.FSRYGH = FSRYGH;
    }

    public String getFSRYXM() {
        return FSRYXM;
    }

    public void setFSRYXM(String FSRYXM) {
        this.FSRYXM = FSRYXM;
    }

    public String getFSZYGX() {
        return FSZYGX;
    }

    public void setFSZYGX(String FSZYGX) {
        this.FSZYGX = FSZYGX;
    }

    public Double getFIGXL() {
        return FIGXL;
    }

    public void setFIGXL(Double FIGXL) {
        this.FIGXL = FIGXL;
    }

    public String getFipx() {
        return fipx;
    }

    public void setFipx(String fipx) {
        this.fipx = fipx;
    }

    public String getPk_psndoc() {
        return pk_psndoc;
    }

    public void setPk_psndoc(String pk_psndoc) {
        this.pk_psndoc = pk_psndoc;
    }

    @Override
    public String toString() {
        return "DM_ZLXX{" +
        "fszlh=" + fszlh +
        ", FSZSZLMC=" + FSZSZLMC +
        ", FSSQZLLX=" + FSSQZLLX +
        ", FDGJSQR=" + FDGJSQR +
        ", FDGJSQRZ=" + FDGJSQRZ +
        ", FSRYGH=" + FSRYGH +
        ", FSRYXM=" + FSRYXM +
        ", FSZYGX=" + FSZYGX +
        ", FIGXL=" + FIGXL +
        ", fipx=" + fipx +
        ", pk_psndoc=" + pk_psndoc +
        "}";
    }
}

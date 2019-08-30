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
@TableName("OA_DM_KJHJCGDJ")
public class DM_KJHJCGDJ implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("fssqh")
    private String fssqh;

    @TableField("fsjldl")
    private String fsjldl;

    @TableField("fsjldj")
    private String fsjldj;

    @TableField("fsjllb")
    private String fsjllb;

    @TableField("fisj")
    private String fisj;

    @TableField("FSXMMC")
    private String FSXMMC;

    @TableField("fshjlb")
    private String fshjlb;

    @TableField("fsbfbm")
    private String fsbfbm;

    @TableField("fszsbh")
    private String fszsbh;

    @TableField("name")
    private String name;

    @TableField("pk_psndoc")
    private String pk_psndoc;


    public String getFssqh() {
        return fssqh;
    }

    public void setFssqh(String fssqh) {
        this.fssqh = fssqh;
    }

    public String getFsjldl() {
        return fsjldl;
    }

    public void setFsjldl(String fsjldl) {
        this.fsjldl = fsjldl;
    }

    public String getFsjldj() {
        return fsjldj;
    }

    public void setFsjldj(String fsjldj) {
        this.fsjldj = fsjldj;
    }

    public String getFsjllb() {
        return fsjllb;
    }

    public void setFsjllb(String fsjllb) {
        this.fsjllb = fsjllb;
    }

    public String getFisj() {
        return fisj;
    }

    public void setFisj(String fisj) {
        this.fisj = fisj;
    }

    public String getFSXMMC() {
        return FSXMMC;
    }

    public void setFSXMMC(String FSXMMC) {
        this.FSXMMC = FSXMMC;
    }

    public String getFshjlb() {
        return fshjlb;
    }

    public void setFshjlb(String fshjlb) {
        this.fshjlb = fshjlb;
    }

    public String getFsbfbm() {
        return fsbfbm;
    }

    public void setFsbfbm(String fsbfbm) {
        this.fsbfbm = fsbfbm;
    }

    public String getFszsbh() {
        return fszsbh;
    }

    public void setFszsbh(String fszsbh) {
        this.fszsbh = fszsbh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPk_psndoc() {
        return pk_psndoc;
    }

    public void setPk_psndoc(String pk_psndoc) {
        this.pk_psndoc = pk_psndoc;
    }

    @Override
    public String toString() {
        return "DM_KJHJCGDJ{" +
        "fssqh=" + fssqh +
        ", fsjldl=" + fsjldl +
        ", fsjldj=" + fsjldj +
        ", fsjllb=" + fsjllb +
        ", fisj=" + fisj +
        ", FSXMMC=" + FSXMMC +
        ", fshjlb=" + fshjlb +
        ", fsbfbm=" + fsbfbm +
        ", fszsbh=" + fszsbh +
        ", name=" + name +
        ", pk_psndoc=" + pk_psndoc +
        "}";
    }
}

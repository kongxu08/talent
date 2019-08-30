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
@TableName("hr_dm_xzzw_post")
public class Dm_xzzw_post implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("pk_psndoc")
    private String pk_psndoc;

    @TableField("glbdef11")
    private String glbdef11;

    @TableField("glbdef12")
    private String glbdef12;

    @TableField("begindate")
    private String begindate;

    @TableField("enddate")
    private String enddate;

    @TableField("glbdef8")
    private String glbdef8;

    @TableField("glbdef3")
    private String glbdef3;

    @TableField("glbdef2")
    private String glbdef2;

    @TableField("glbdef4")
    private String glbdef4;

    @TableField("glbdef1")
    private String glbdef1;

    @TableField("glbdef19")
    private String glbdef19;


    public String getPk_psndoc() {
        return pk_psndoc;
    }

    public void setPk_psndoc(String pk_psndoc) {
        this.pk_psndoc = pk_psndoc;
    }

    public String getGlbdef11() {
        return glbdef11;
    }

    public void setGlbdef11(String glbdef11) {
        this.glbdef11 = glbdef11;
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

    public String getGlbdef8() {
        return glbdef8;
    }

    public void setGlbdef8(String glbdef8) {
        this.glbdef8 = glbdef8;
    }

    public String getGlbdef3() {
        return glbdef3;
    }

    public void setGlbdef3(String glbdef3) {
        this.glbdef3 = glbdef3;
    }

    public String getGlbdef2() {
        return glbdef2;
    }

    public void setGlbdef2(String glbdef2) {
        this.glbdef2 = glbdef2;
    }

    public String getGlbdef4() {
        return glbdef4;
    }

    public void setGlbdef4(String glbdef4) {
        this.glbdef4 = glbdef4;
    }

    public String getGlbdef1() {
        return glbdef1;
    }

    public void setGlbdef1(String glbdef1) {
        this.glbdef1 = glbdef1;
    }

    public String getGlbdef19() {
        return glbdef19;
    }

    public void setGlbdef19(String glbdef19) {
        this.glbdef19 = glbdef19;
    }

    @Override
    public String toString() {
        return "Dm_xzzw_post{" +
        "pk_psndoc=" + pk_psndoc +
        ", glbdef11=" + glbdef11 +
        ", glbdef12=" + glbdef12 +
        ", begindate=" + begindate +
        ", enddate=" + enddate +
        ", glbdef8=" + glbdef8 +
        ", glbdef3=" + glbdef3 +
        ", glbdef2=" + glbdef2 +
        ", glbdef4=" + glbdef4 +
        ", glbdef1=" + glbdef1 +
        ", glbdef19=" + glbdef19 +
        "}";
    }
}

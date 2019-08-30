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
 * @since 2019-08-30
 */
@TableName("hr_dim_org_orgs2")
public class Dim_org_orgs2 implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("shortname")
    private String shortname;

    @TableField("seq")
    private Integer seq;


    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    @Override
    public String toString() {
        return "Dim_org_orgs2{" +
        "shortname=" + shortname +
        ", seq=" + seq +
        "}";
    }
}

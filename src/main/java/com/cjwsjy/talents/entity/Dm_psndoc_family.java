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
@TableName("hr_dm_psndoc_family")
public class Dm_psndoc_family implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("mem_name")
    private String mem_name;

    @TableField("mem_relation")
    private String mem_relation;

    @TableField("mem_birthday")
    private String mem_birthday;

    @TableField("mem_corp")
    private String mem_corp;

    @TableField("mem_job")
    private String mem_job;

    @TableField("relaaddr")
    private String relaaddr;

    @TableField("relaphone")
    private String relaphone;

    @TableField("profession")
    private String profession;

    @TableField("politics")
    private String politics;

    @TableField("pk_psndoc")
    private String pk_psndoc;


    public String getMem_name() {
        return mem_name;
    }

    public void setMem_name(String mem_name) {
        this.mem_name = mem_name;
    }

    public String getMem_relation() {
        return mem_relation;
    }

    public void setMem_relation(String mem_relation) {
        this.mem_relation = mem_relation;
    }

    public String getMem_birthday() {
        return mem_birthday;
    }

    public void setMem_birthday(String mem_birthday) {
        this.mem_birthday = mem_birthday;
    }

    public String getMem_corp() {
        return mem_corp;
    }

    public void setMem_corp(String mem_corp) {
        this.mem_corp = mem_corp;
    }

    public String getMem_job() {
        return mem_job;
    }

    public void setMem_job(String mem_job) {
        this.mem_job = mem_job;
    }

    public String getRelaaddr() {
        return relaaddr;
    }

    public void setRelaaddr(String relaaddr) {
        this.relaaddr = relaaddr;
    }

    public String getRelaphone() {
        return relaphone;
    }

    public void setRelaphone(String relaphone) {
        this.relaphone = relaphone;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getPolitics() {
        return politics;
    }

    public void setPolitics(String politics) {
        this.politics = politics;
    }

    public String getPk_psndoc() {
        return pk_psndoc;
    }

    public void setPk_psndoc(String pk_psndoc) {
        this.pk_psndoc = pk_psndoc;
    }

    @Override
    public String toString() {
        return "Dm_psndoc_family{" +
        "mem_name=" + mem_name +
        ", mem_relation=" + mem_relation +
        ", mem_birthday=" + mem_birthday +
        ", mem_corp=" + mem_corp +
        ", mem_job=" + mem_job +
        ", relaaddr=" + relaaddr +
        ", relaphone=" + relaphone +
        ", profession=" + profession +
        ", politics=" + politics +
        ", pk_psndoc=" + pk_psndoc +
        "}";
    }
}

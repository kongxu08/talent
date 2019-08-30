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
 * @since 2019-07-22
 */
@TableName("v_sm_user")
public class Sm_user implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("user_code")
    private String user_code;

    @TableField("user_name")
    private String user_name;

    @TableField("user_note")
    private String user_note;

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_note() {
        return user_note;
    }

    public void setUser_note(String user_note) {
        this.user_note = user_note;
    }

    @Override
    public String toString() {
        return "Sm_user{" +
        "user_code=" + user_code +
        ", user_name=" + user_name +
        ", user_note=" + user_note +
        "}";
    }
}

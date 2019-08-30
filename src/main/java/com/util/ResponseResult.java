package com.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Map;

@ApiModel(description = "请求返回值")
public class ResponseResult implements Serializable {
    private static final long serialVersionUID = 1;

    public boolean isSuccess() {
        return success;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public Map<String, String> getExtraInfo() {
        return extraInfo;
    }

    /**
     * 是否成功，成功找data、失败找msgL
     */
    protected final boolean success;

    /**
     * 返回结果编码
     */
    @ApiModelProperty(value = "请求状态",example = "200")
    protected final int code;

    /**
     * 返回消息，一般放置可追溯的错误消息
     */
    protected final String msg;

    /**
     * 返回数据
     */
    protected final Object data;

    /**
     * 额外参数,不使用Map<String, Object>防止JSON解析时过于复杂
     */
    protected final Map<String, String> extraInfo;

    private ResponseResult(boolean success, int code, String msg, Object data, Map<String, String> extraInfo) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data=data;
        this.extraInfo = extraInfo;
    }

    public static ResponseResult fail(int code, String msg, Map<String, String> extraInfo){
        return new ResponseResult(false,code,msg,null,extraInfo);
    }

    public static ResponseResult success(Object data, Map<String, String> extraInfo){
        return new ResponseResult(true,200,"success",data,extraInfo);
    }

}

package com.handle;

import com.util.LogUtil;
import com.util.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseResult exceptionHandler(Exception e, HttpServletRequest request) {
            Map<String,String> extraInfo = new HashMap<String,String>();
            extraInfo.put("msg",e.getMessage());
            extraInfo.put("url",request.getRequestURL().toString());
            extraInfo.put("localizedMessage",e.getLocalizedMessage());
            ResponseResult result = ResponseResult.fail(500,"fail",extraInfo);
        LogUtil.printLog(e,GlobalExceptionHandler.class);
        return result;
    }
}
package com.fengtao.common.beans.exceptions;

import com.alibaba.fastjson.JSONObject;
import com.fengtao.common.beans.enums.ErrorCode;

/**
 * 功能描述：系统全局统一异常
 *
 * @Auther: GQlofe
 * @Date: 2018/9/16 12:44
 */
public class SystemException extends Exception {

    /**
     * 错误码
     */
    private int code;

    /**
     * 错误信息
     */
    private String message;

    public SystemException(String message, int code, String message1) {
        super(message);
        this.code = code;
        this.message = message1;
    }

    public SystemException(ErrorCode errorCode) {
        super(errorCode.message);
        this.code = errorCode.code;
        this.message = errorCode.message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

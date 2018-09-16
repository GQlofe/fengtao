package com.fengtao.common.beans.enums;

/**
 * 功能描述：错误码,格式: 服务(2位)_模块(2位)_错误码(4位)
 *
 * @Auther: GQlofe
 * @Date: 2018/9/16 12:06
 */
public enum ErrorCode {

    SUCCESS(0, "成功"),

    // 用户中心服务：10, 登录模块：01
    USER_NAME_PW_ERROR(10010001, "用户名或密码错误"),


    SYSTEM_ERROR(99_99_9999, "系统错误");


    public int code;
    public String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 功能描述: 根据错误码获取枚举类
     *
     * @param: [code] 错误码
     * @return: ErrorCode
     * @auther: GQlofe
     * @date: 2018/9/16 12:13
     */
    public static ErrorCode parseByCode(int code) {
        ErrorCode[] values = ErrorCode.values();
        for (ErrorCode value : values) {
            if (value.code == code) {
                return value;
            }
        }
        return null;
    }
}

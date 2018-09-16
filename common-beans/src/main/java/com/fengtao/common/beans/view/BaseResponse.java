package com.fengtao.common.beans.view;

import com.alibaba.fastjson.JSONObject;
import com.fengtao.common.beans.enums.ErrorCode;
import com.fengtao.common.beans.exceptions.SystemException;
import lombok.Data;

/**
 * 功能描述：所有请求返回实体类
 *
 * @Auther: GQlofe
 * @Date: 2018/9/16 12:16
 */
@Data
public class BaseResponse<T> {

    /**
     * 返回错误码
     */
    private int code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 功能描述: 获取成功返回对象
     *
     * @param: []
     * @return: BaseResponse
     * @auther: GQlofe
     * @date: 2018/9/16 12:29
     */
    public static BaseResponse newSuccess() {
        BaseResponse response = new BaseResponse();
        response.setCode(ErrorCode.SUCCESS.code);
        response.setMessage(ErrorCode.SUCCESS.message);
        return response;
    }

    /**
     * 功能描述: 获取携带数据的成功返回对象
     *
     * @param: [data] 数据
     * @return: BaseResponse<T>
     * @auther: GQlofe
     * @date: 2018/9/16 12:30
     */
    public static <T> BaseResponse<T> newSuccess(T data) {
        BaseResponse<T> response = new BaseResponse<T>();
        response.setCode(ErrorCode.SUCCESS.code);
        response.setMessage(ErrorCode.SUCCESS.message);
        response.setData(data);
        return response;
    }

    /**
     * 功能描述: 返回错误对象
     *
     * @param: [errorCode]
     * @return: BaseResponse
     * @auther: GQlofe
     * @date: 2018/9/16 13:07
     */
    public static BaseResponse newFailure(ErrorCode errorCode) {
        BaseResponse response = new BaseResponse();
        response.setCode(errorCode.code);
        response.setMessage(errorCode.message);
        return response;
    }

    /**
     * 功能描述: 返回携带数据的错误对象
     *
     * @param: [errorCode, data]
     * @return: BaseResponse
     * @auther: GQlofe
     * @date: 2018/9/16 13:07
     */
    public static <T> BaseResponse<T> newFailure(ErrorCode errorCode, T data) {
        BaseResponse<T> response = new BaseResponse<T>();
        response.setCode(errorCode.code);
        response.setMessage(errorCode.message);
        response.setData(data);
        return response;
    }

    /**
     * 功能描述: 返回异常信息错误对象
     *
     * @param: [e]
     * @return: BaseResponse
     * @auther: GQlofe
     * @date: 2018/9/16 13:09
     */
    public static BaseResponse newFailureException(SystemException e) {

        BaseResponse response = new BaseResponse();
        response.setCode(e.getCode());
        response.setMessage(e.getMessage());
        return response;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

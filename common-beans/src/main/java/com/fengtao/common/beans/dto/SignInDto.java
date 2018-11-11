package com.fengtao.common.beans.dto;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;

/**
 * 功能描述：登录传输对象
 *
 * @Auther: GQlofe
 * @Date: 2018/9/16 14:40
 */
@Data
public class SignInDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;


    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

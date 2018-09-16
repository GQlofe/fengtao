package com.fengtao.common.beans.dto;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * 功能描述：登录传输对象
 *
 * @Auther: GQlofe
 * @Date: 2018/9/16 14:40
 */
public class SignInDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

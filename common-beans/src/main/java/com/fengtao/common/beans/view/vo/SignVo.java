package com.fengtao.common.beans.view.vo;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * 功能描述：登录注册请求对象
 *
 * @Auther: GQlofe
 * @Date: 2018/9/16 14:35
 */
@Data
public class SignVo {

    @NotNull(message = "10010001")
    @Size(min = 1, max = 20, message = "10010001")
    private String userName;

    @NotNull(message = "10010001")
    @Size(min = 6, max = 20, message = "10010001")
    private String password;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

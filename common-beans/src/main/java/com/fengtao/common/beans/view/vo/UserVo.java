package com.fengtao.common.beans.view.vo;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;



/**
 * 功能描述：登录注册请求对象
 *
 * @Auther: GQlofe
 * @Date: 2018/9/16 14:35
 */
@Data
public class UserVo {

    private String account;

    private String password;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

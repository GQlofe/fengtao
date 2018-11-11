package com.fengtao.common.beans.token;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

/**
 * 功能描述：登录凭证
 *
 * @Auther: GQlofe
 * @Date: 2018/9/19 22:46
 */
@Data
public class Token implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * token的key
     */
    private String key;

    /**
     * 账用户号
     */
    private String account;

    /**
     * 获取token实例
     * @param account
     * @return
     */
    public static Token newToken(String account){
        Token token = new Token();
        token.setKey(UUID.randomUUID().toString());
        token.setAccount(account);
        return token;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

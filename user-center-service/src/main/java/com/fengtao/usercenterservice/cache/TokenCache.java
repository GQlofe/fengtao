package com.fengtao.usercenterservice.cache;

import com.fengtao.common.beans.token.Token;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 功能描述：
 *
 * @Auther: GQlofe
 * @Date: 2018/9/22 21:03
 */
public class TokenCache {

    private static ConcurrentHashMap<String, Token> tokenCache = new ConcurrentHashMap<>();

    public static void setToken(Token token){
        tokenCache.put(token.getKey(),token);
    }

    public static Token getToken(String key){
        return tokenCache.get(key);
    }

    public static void delToken(String key){
        tokenCache.remove(key);
    }
}

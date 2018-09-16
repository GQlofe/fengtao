package com.fengtao.usercenterservice.service;

import com.fengtao.common.beans.dto.SignInDto;
import com.fengtao.common.beans.exceptions.SystemException;
import org.springframework.stereotype.Service;

/**
 * 功能描述：
 *
 * @Auther: GQlofe
 * @Date: 2018/9/16 14:39
 */
public interface SignService {

    /**
     *
     * 功能描述: 登录
     *
     * @param: signInDto 登录信息
     * @return: token
     * @exception SystemException
     * @auther: GQlofe
     * @date: 2018/9/16 14:53
     */
    String signIn(SignInDto signInDto) throws SystemException;
}

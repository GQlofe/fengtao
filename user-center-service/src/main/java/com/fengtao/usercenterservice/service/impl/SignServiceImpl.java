package com.fengtao.usercenterservice.service.impl;

import com.fengtao.common.beans.dto.SignInDto;
import com.fengtao.common.beans.exceptions.SystemException;
import com.fengtao.usercenterservice.service.SignService;
import org.springframework.stereotype.Service;

/**
 * 功能描述：登录注册服务实现类
 *
 * @Auther: GQlofe
 * @Date: 2018/9/16 15:11
 */
@Service
public class SignServiceImpl implements SignService {

    /**
     *
     * 功能描述: 登录
     *
     * @param: [signInDto] 登录信息
     * @return: java.lang.String
     * @exception SystemException
     * @auther: GQlofe
     * @date: 2018/9/16 15:13
     */
    @Override
    public String signIn(SignInDto signInDto) throws SystemException {

        return "token";
    }
}

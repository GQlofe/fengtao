package com.fengtao.usercenterservice.service.impl;

import com.fengtao.common.beans.dto.SignInDto;
import com.fengtao.common.beans.entity.usercenter.UserDo;
import com.fengtao.common.beans.exceptions.SystemException;
import com.fengtao.usercenterservice.dao.UserDao;
import com.fengtao.usercenterservice.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 功能描述：登录注册服务实现类
 *
 * @Auther: GQlofe
 * @Date: 2018/9/16 15:11
 */
@Service
public class SignServiceImpl implements SignService {

    @Autowired
    private UserDao userDao;

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

    /**
     *
     * 功能描述: 通过账号获取用户信息
     *
     * @param: [account] 账号
     * @return: com.fengtao.common.beans.entity.usercenter.UserDo 用户信息
     * @exception SystemException
     * @auther: GQlofe
     * @date: 2018/9/16 23:06
     */
    @Override
    public UserDo queryUser(String account) throws SystemException {

        return userDao.queryByAccount(account);
    }
}

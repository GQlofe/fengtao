package com.fengtao.usercenterservice.service;

import com.fengtao.common.beans.dto.SignInDto;
import com.fengtao.common.beans.entity.usercenter.UserDo;
import com.fengtao.common.beans.exceptions.SystemException;
import com.fengtao.common.beans.view.vo.UserVo;

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
    String signIn(UserVo userVo) throws SystemException;

    /**
     *
     * 功能描述: 注册
     *
     * @param: signInDto 注册信息
     * @return: token
     * @exception SystemException
     * @auther: GQlofe
     * @date: 2018/9/16 14:53
     */
    String signUp(UserVo userVo) throws SystemException;

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
    UserDo queryUser(String account) throws SystemException;
}

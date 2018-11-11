package com.fengtao.usercenterservice.service.impl;

import com.fengtao.common.beans.entity.usercenter.UserDo;
import com.fengtao.common.beans.enums.ErrorCode;
import com.fengtao.common.beans.exceptions.SystemException;
import com.fengtao.common.beans.token.Token;
import com.fengtao.common.beans.view.vo.UserVo;
import com.fengtao.usercenterservice.cache.TokenCache;
import com.fengtao.usercenterservice.dao.UserDao;
import com.fengtao.usercenterservice.service.SignService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.Charset;

/**
 * 功能描述：登录注册服务实现类
 *
 * @Auther: GQlofe
 * @Date: 2018/9/16 15:11
 */
@Service
public class SignServiceImpl implements SignService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
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
    public String signIn(UserVo userVo) throws SystemException {

        UserDo userDo = userDao.queryByAccount(userVo.getAccount());
        if (userDo == null){
            throw new SystemException(ErrorCode.ACCOUNT_PWD_ERROR);
        }
        String encry = DigestUtils.md5DigestAsHex(userVo.getPassword().getBytes(Charset.forName("UTF-8")));
        if (!StringUtils.equals(encry,userDo.getEncryPwd())){
            throw new SystemException(ErrorCode.ACCOUNT_PWD_ERROR);
        }
        Token token = Token.newToken(userVo.getAccount());
        TokenCache.setToken(token);
        return token.getKey();
    }

    /**
     *
     * 功能描述: 注册
     *
     * @param: [signInDto] 注册信息
     * @return: java.lang.String token
     * @exception SystemException
     * @auther: GQlofe
     * @date: 2018/9/20 0:05
     */
    @Override
    public String signUp(UserVo userVo) throws SystemException {

        // 校验账号是否被注册
        UserDo query = userDao.queryByAccount(userVo.getAccount());
        if (query != null){
            throw new SystemException(ErrorCode.ACCOUNT_EXIST);
        }

        UserDo userDo = new UserDo();
        userDo.setAccount(userVo.getAccount());
        userDo.setPassword(userVo.getPassword());
        userDo.setEncryPwd(DigestUtils.md5DigestAsHex(userVo.getPassword().getBytes(Charset.forName("UTF-8"))));
        userDo.setNickName(userVo.getAccount());
        long time = System.currentTimeMillis();
        userDo.setCreateTime(time);
        userDo.setUpdateTime(time);
        int insert = userDao.insert(userDo);
        if (insert == 0){
            throw new SystemException(ErrorCode.SIGN_UP_FAILED);
        }
        Token token = Token.newToken(userVo.getAccount());
        TokenCache.setToken(token);
        return token.getKey();
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

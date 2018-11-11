package com.fengtao.usercenterservice.controller;

import com.fengtao.common.beans.entity.usercenter.UserDo;
import com.fengtao.common.beans.exceptions.SystemException;
import com.fengtao.common.beans.view.BaseResponse;
import com.fengtao.common.beans.view.vo.UserVo;
import com.fengtao.usercenterservice.service.SignService;
import com.fengtao.usercenterservice.service.validator.SignValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述：登陆注册控制层
 *
 * @Auther: GQlofe
 * @Date: 2018/9/16 12:53
 */
@RestController
@RequestMapping("user/v1")
public class SignController {

    private static Logger logger = LoggerFactory.getLogger(SignController.class);

    @Autowired
    private SignService signService;
    @Autowired
    private SignValidator validator;

    /**
     * 登录
     * @param userVo 账号密码
     * @return token
     * @throws SystemException e
     */
    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public BaseResponse<String> signIn(@RequestBody UserVo userVo) throws SystemException {

        validator.validSignIn(userVo);

        String token = signService.signIn(userVo);

        return BaseResponse.newSuccess(token);
    }

    /**
     * 注册
     * @param userVo 账号密码
     * @return token
     * @throws SystemException e
     */
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public BaseResponse<String> signUp(@RequestBody UserVo userVo) throws SystemException {
        validator.validSignUp(userVo);

        String token = signService.signUp(userVo);

        return BaseResponse.newSuccess(token);
    }

    @RequestMapping(value = "/queryUser", method = RequestMethod.POST)
    public BaseResponse<UserDo> queryUser(@RequestBody UserVo userVo) throws SystemException {

        UserDo user = signService.queryUser(userVo.getAccount());
        return BaseResponse.newSuccess(user);
    }
}

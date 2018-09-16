package com.fengtao.usercenterservice.controller;

import com.fengtao.common.beans.dto.SignInDto;
import com.fengtao.common.beans.exceptions.SystemException;
import com.fengtao.common.beans.view.BaseResponse;
import com.fengtao.common.beans.view.vo.SignVo;
import com.fengtao.usercenterservice.service.SignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 功能描述：登陆注册控制层
 *
 * @Auther: GQlofe
 * @Date: 2018/9/16 12:53
 */
@RestController
@Validated
public class SignController {

    private static Logger logger = LoggerFactory.getLogger(SignController.class);

    @Autowired
    private SignService signService;

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public BaseResponse<String> signIn(@RequestBody @Valid SignVo signVo) throws SystemException {

        SignInDto signInDto = new SignInDto();
        BeanUtils.copyProperties(signVo, signInDto);
        String s = signService.signIn(signInDto);
        return BaseResponse.newSuccess(s);
    }
}
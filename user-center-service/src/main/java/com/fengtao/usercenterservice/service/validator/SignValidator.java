package com.fengtao.usercenterservice.service.validator;

import com.fengtao.common.beans.constant.Constant;
import com.fengtao.common.beans.enums.ErrorCode;
import com.fengtao.common.beans.exceptions.SystemException;
import com.fengtao.common.beans.view.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * 功能描述：
 *
 * @Auther: GQlofe
 * @Date: 2018/9/22 20:42
 */
@Service
public class SignValidator {

    public void validSignIn(UserVo userVo) throws SystemException {
        String account = userVo.getAccount();
        String password = userVo.getPassword();
        if (StringUtils.isAnyBlank(account,password)){
            throw new SystemException(ErrorCode.ACCOUNT_PWD_ERROR);
        }
        if (!account.matches(Constant.ACCOUNT_REGEX)){
            throw new SystemException(ErrorCode.ACCOUNT_PWD_ERROR);
        }
        if (!password.matches(Constant.PWD_REGEX)){
            throw new SystemException(ErrorCode.ACCOUNT_PWD_ERROR);
        }
    }

    public void validSignUp(UserVo userVo) throws SystemException {
        String account = userVo.getAccount();
        String password = userVo.getPassword();
        if (StringUtils.isAnyBlank(account,password)){
            throw new SystemException(ErrorCode.ACCOUNT_PWD_ERROR);
        }
        if (!account.matches(Constant.ACCOUNT_REGEX)){
            throw new SystemException(ErrorCode.ACCOUNT_PWD_ERROR);
        }
        if (!password.matches(Constant.PWD_REGEX)){
            throw new SystemException(ErrorCode.ACCOUNT_PWD_ERROR);
        }
    }
}

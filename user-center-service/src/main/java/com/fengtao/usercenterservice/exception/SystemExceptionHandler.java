package com.fengtao.usercenterservice.exception;

import com.fengtao.common.beans.enums.ErrorCode;
import com.fengtao.common.beans.exceptions.SystemException;
import com.fengtao.common.beans.view.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 功能描述：全局异常处理类
 *
 * @Auther: GQlofe
 * @Date: 2018/9/16 12:53
 */
@ControllerAdvice(basePackages = "com.fengtao.usercenterservice")
public class SystemExceptionHandler {

    public static String NEW_LINE = System.getProperty("line.separator");

    /**
     * 功能描述: 处理 SystemException 异常
     *
     * @param: [request, e]
     * @return: BaseResponse
     * @auther: GQlofe
     * @date: 2018/9/16 14:30
     */
    @ExceptionHandler(value = SystemException.class)
    @ResponseBody
    public BaseResponse handleSystemException(HttpServletRequest request, SystemException e) {

        print(e);
        return BaseResponse.newFailureException(e);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public BaseResponse handleValidException(HttpServletRequest request, MethodArgumentNotValidException e) {

        BindingResult bindingResult = e.getBindingResult();
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            ObjectError objectError = allErrors.get(0);
            String code = objectError.getDefaultMessage();
            ErrorCode errorCode = ErrorCode.parseByCode(Integer.parseInt(code));
            if (errorCode != null) {
                return BaseResponse.newFailure(errorCode);
            }
        }
        return BaseResponse.newFailure(ErrorCode.SYSTEM_ERROR);
    }

    /**
     * 功能描述: 处理 运行时异常
     *
     * @param: [request, e]
     * @return: BaseResponse
     * @auther: GQlofe
     * @date: 2018/9/16 14:31
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResponse handleException(HttpServletRequest request, Exception e) {

        print(e);
        return BaseResponse.newFailure(ErrorCode.SYSTEM_ERROR);
    }

    /**
     * 功能描述: 打印异常信息
     *
     * @param: [e]
     * @return: void
     * @auther: GQlofe
     * @date: 2018/9/16 14:29
     */
    public void print(Exception e) {

        Logger logger = null;
        StackTraceElement[] stackTrace = e.getStackTrace();
        Class<?> aClass1 = null;
        try {
            aClass1 = Class.forName(stackTrace[0].getClassName());
        } catch (ClassNotFoundException e1) {
            logger = LoggerFactory.getLogger(SystemExceptionHandler.class);
        }
        if (logger == null) {
            logger = LoggerFactory.getLogger(aClass1);
        }

        StringBuilder builder = new StringBuilder();
        builder.append(e.getClass().getName()).append(":  ").append(e.getMessage()).append(NEW_LINE);
        for (StackTraceElement stackTraceElement : stackTrace) {
            builder.append("    ").append(stackTraceElement.toString()).append(NEW_LINE);
        }
        logger.error(builder.toString());
    }

}

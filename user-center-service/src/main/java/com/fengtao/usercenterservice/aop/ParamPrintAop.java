package com.fengtao.usercenterservice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 功能描述：日志打印类
 *
 * @Auther: GQlofe
 * @Date: 2018/9/16 15:21
 */
@Component
@Aspect
public class ParamPrintAop {

    // 所有controller的所有方法
    @Pointcut("execution(* com.fengtao.usercenterservice.controller..*.*(..))")
    public void pointCut() {
    }


    /**
     * 打印入参和出参
     *
     * @param joinPoint joinPoint
     * @param returnVal returnVal
     */
    @AfterReturning(pointcut = "pointCut()", returning = "returnVal")
    public void afterReturn(JoinPoint joinPoint, Object returnVal) {

        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        Class declaringType = signature.getDeclaringType();
        String methodName = signature.getName();
        String className = signature.getDeclaringTypeName();

        StringBuilder builder = new StringBuilder();
        builder.append("---参数打印：").append(className).append(".").append(methodName).append(",")
        ;
        if (args == null) {
            builder.append("null");
        } else {
            if (args.length == 1) {
                builder.append("param=").append(args[0]);
            } else {
                builder.append("param:");
                int index = 1;
                for (Object arg : args) {
                    builder.append("$").append(index).append("=").append(arg).append(",");
                    index++;
                }
                builder.deleteCharAt(builder.length() - 1);
            }

        }
        builder.append("  ").append("return=").append(returnVal);

        Logger logger = LoggerFactory.getLogger(declaringType);
        logger.info(builder.toString());
    }

}

package com.yupi.springbootinit.exception;

import com.yupi.springbootinit.common.BaseResponse;
import com.yupi.springbootinit.common.ErrorCode;
import com.yupi.springbootinit.common.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@RestControllerAdvice       //一个注解，表示该类是一个全局异常处理器，用于处理应用程序中抛出的异常。
@Slf4j     // Lombok 提供的注解，用于自动生成日志记录器。
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    //@ExceptionHandler(BusinessException.class): 这是一个异常处理方法，用于处理 BusinessException 类型的异常
    // 当应用程序中抛出 BusinessException 异常时，该方法会被调用。
    public BaseResponse<?> businessExceptionHandler(BusinessException e) {
        //问号 ? 表示通配符类型，表示方法返回的 BaseResponse 对象的泛型类型是不确定的，可以是任意类型
        log.error("BusinessException", e);
        return ResultUtils.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    //这是另一个异常处理方法，用于处理 RuntimeException 类型的异常。当应用程序中抛出 RuntimeException 异常时，该方法会被调用
    public BaseResponse<?> runtimeExceptionHandler(RuntimeException e) {
        log.error("RuntimeException", e);
        return ResultUtils.error(ErrorCode.SYSTEM_ERROR, "系统错误");
    }
}

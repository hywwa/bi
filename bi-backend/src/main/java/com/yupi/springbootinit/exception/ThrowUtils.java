package com.yupi.springbootinit.exception;

import com.yupi.springbootinit.common.ErrorCode;

/**
 * 抛异常工具类      这里可以设置条件判断，借助businessexception这个基础的
 */
public class ThrowUtils {

    /**
     * 条件成立则抛异常
     *
     * @param condition
     * @param runtimeException
     */
    public static void throwIf(boolean condition, RuntimeException runtimeException) {
        if (condition) {
            throw runtimeException;
        }
    }
//用于根据条件判断是否抛出异常。如果条件为真，则抛出指定的运行时异常 runtimeException。
    /**
     * 条件成立则抛异常
     *
     * @param condition
     * @param errorCode
     */
    public static void throwIf(boolean condition, ErrorCode errorCode) {
        throwIf(condition, new BusinessException(errorCode));
    }
//用于根据条件判断是否抛出异常。如果条件为真，则根据传入的错误码 errorCode 抛出一个对应的业务异常。
    /**
     * 条件成立则抛异常
     *
     * @param condition
     * @param errorCode
     * @param message
     */
    public static void throwIf(boolean condition, ErrorCode errorCode, String message) {
        throwIf(condition, new BusinessException(errorCode, message));
    }
    //如果条件为真，则根据传入的错误码 errorCode 和消息 message 抛出一个对应的业务异常。
}

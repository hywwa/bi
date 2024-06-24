package com.yupi.springbootinit.exception;

import com.yupi.springbootinit.common.ErrorCode;

/**
 * 自定义异常类    这里是直接返回错误码
 */
public class BusinessException extends RuntimeException {
//定义了一个名为 BusinessException 的异常类，它继承自 RuntimeException，表示这是一个非检查型异常。
    /**
     * 错误码
     */
    private final int code;

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    public BusinessException(ErrorCode errorCode, String message) {
        super(message);
        this.code = errorCode.getCode();
    }

    public int getCode() {
        return code;
    }
}

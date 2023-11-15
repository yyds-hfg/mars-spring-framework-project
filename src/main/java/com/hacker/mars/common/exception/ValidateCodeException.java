package com.hacker.mars.common.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * <p>
 *
 * </p>
 *
 * @author: 韩福贵
 * @date: 2023-11-15
 */
public class ValidateCodeException extends AuthenticationException {

    /**
     * 验证码异常
     *
     * @param msg   信息
     * @param cause 原因
     */
    public ValidateCodeException(String msg, Throwable cause) {
        super(msg, cause);
    }

    /**
     * 验证码
     *
     * @param msg 消息
     */
    public ValidateCodeException(String msg) {
        super(msg);
    }

}

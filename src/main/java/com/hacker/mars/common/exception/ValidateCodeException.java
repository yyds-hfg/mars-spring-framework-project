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
    public ValidateCodeException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public ValidateCodeException(String msg) {
        super(msg);
    }
}

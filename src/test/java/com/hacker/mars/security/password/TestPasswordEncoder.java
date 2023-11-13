package com.hacker.mars.security.password;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * <p>
 *
 * </p>
 *
 * @author: 韩福贵
 * @date: 2023-11-13
 */
public class TestPasswordEncoder {

    @Test
    public void test1() {
        PasswordEncoder delegatingPasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        System.out.println(delegatingPasswordEncoder.encode("123456"));
    }

}

package com.hacker.mars.domain.user.entity;

import lombok.Data;

import java.awt.image.BufferedImage;

/**
 * <p>
 *
 * </p>
 *
 * @author: 韩福贵
 * @date: 2023-11-13
 */
@Data
public class ImageCode {

    /**
     * 验证码图片
     */
    private BufferedImage image;

    /**
     * code验证码
     */
    private String code;


    /**
     * 构造函数
     *
     * @param image 图片
     * @param code  验证码
     */
    public ImageCode(BufferedImage image, String code) {
        this.image = image;
        this.code = code;
    }

}

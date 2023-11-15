package com.hacker.mars.common.security;

import cn.hutool.cache.impl.LRUCache;

/**
 * <p>
 *  模拟Redis
 * </p>
 *
 * @author: 韩福贵
 * @date: 2023-11-15
 */
public class RedisCodeCache {
    /**
     * LRU缓存
     */
    private final static LRUCache<String, String> REDIS_CACHE = new LRUCache<>(10);

    /**
     * 验证码KEY
     */
    public final static String IMAGE_CODE_KEY = "IMAGE_CODE:IP:";

    /**
     * 获取缓存的值
     *
     * @param key 键
     * @return 值
     */
    public static String get(String key) {
        return REDIS_CACHE.get(key);
    }

    /**
     * 设置验证码的值
     *
     * @param key  键
     * @param code 值
     */
    public static void set(String key, String code) {
        REDIS_CACHE.put(key, code, 60000);
    }

    /**
     * 删除缓存
     *
     * @param key 键
     */
    public static void remove(String key) {
        REDIS_CACHE.remove(key);
    }

}

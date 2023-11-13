package com.hacker.mars.domain.user;

import com.hacker.mars.infrastructure.persistent.po.TUserPo;

/**
 * <p>
 *
 * </p>
 *
 * @author: 韩福贵
 * @date: 2023-11-12
 */
public interface UserService {

    /**
     * 根据用户名称查找用户
     *
     * @param username 用户名称
     * @return 用户
     */
    TUserPo findByUsername(String username);

}

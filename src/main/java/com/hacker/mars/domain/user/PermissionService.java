package com.hacker.mars.domain.user;

import com.hacker.mars.infrastructure.persistent.po.TPermissionPo;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author: 韩福贵
 * @date: 2023-11-12
 */
public interface PermissionService {

    /**
     * 根据用户ID查找权限
     *
     * @param id 用户id
     * @return 权限列表
     */
    List<TPermissionPo> findByUserId(Integer id);

}

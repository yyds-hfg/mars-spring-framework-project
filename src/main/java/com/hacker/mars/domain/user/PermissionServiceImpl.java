package com.hacker.mars.domain.user;

import com.hacker.mars.infrastructure.persistent.mapper.TPermissionMapper;
import com.hacker.mars.infrastructure.persistent.po.TPermissionPo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author: 韩福贵
 * @date: 2023-11-12
 */
@Service
@AllArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final TPermissionMapper permissionMapper;

    @Override
    public List<TPermissionPo> findByUserId(Integer id) {
        return permissionMapper.findByUserId(id);
    }

}

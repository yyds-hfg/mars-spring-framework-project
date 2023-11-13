package com.hacker.mars.domain.user;

import com.hacker.mars.infrastructure.persistent.mapper.TUserMapper;
import com.hacker.mars.infrastructure.persistent.po.TUserPo;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

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
public class UserServiceImpl implements UserService {

    private final TUserMapper userMapper;

    @Override
    public TUserPo findByUsername(String username) {
        return userMapper.findByUsername( username);
    }

}

package com.hacker.mars.infrastructure.persistent.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hacker.mars.infrastructure.persistent.po.TUserPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Zero
 * @since 2023-11-05
 */
@Mapper
public interface TUserMapper extends BaseMapper<TUserPo> {

    default TUserPo findByUsername(String username) {
        QueryWrapper<TUserPo> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(TUserPo::getUsername, username);
        return this.selectOne(wrapper);
    }

}

package com.hacker.mars.infrastructure.persistent.mapper;

import com.hacker.mars.infrastructure.persistent.po.TPermissionPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Zero
 * @since 2023-11-05
 */
@Mapper
public interface TPermissionMapper extends BaseMapper<TPermissionPo> {

    /**
     * 根据用户ID查找权限
     *
     * @param id 用户ID
     * @return 权限列表
     */
    List<TPermissionPo> findByUserId(Integer id);

}

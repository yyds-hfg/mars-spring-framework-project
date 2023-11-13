package com.hacker.mars.infrastructure.persistent.mapper;

import com.hacker.mars.infrastructure.persistent.po.PersistentLoginsPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Zero
 * @since 2023-11-13
 */
@Mapper
public interface PersistentLoginsMapper extends BaseMapper<PersistentLoginsPo> {

    void updateToken(@Param("series") String series,
                     @Param("tokenValue") String tokenValue,
                     @Param("localDateTime") LocalDateTime localDateTime);

    void createNewToken(@Param("username") String username, @Param("series") String series,
                        @Param("tokenValue") String tokenValue, @Param("localDateTime") LocalDateTime localDateTime);

    List<PersistentLoginsPo> tokensBySeries(@Param("seriesId") String seriesId);

    void removeUserTokens(@Param("username") String username);
}

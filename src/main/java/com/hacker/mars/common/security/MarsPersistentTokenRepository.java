package com.hacker.mars.common.security;

import cn.hutool.core.date.DateUtil;
import com.hacker.mars.infrastructure.persistent.mapper.PersistentLoginsMapper;
import com.hacker.mars.infrastructure.persistent.po.PersistentLoginsPo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author: 韩福贵
 * @date: 2023-11-13
 */
@Slf4j
@Component
@AllArgsConstructor
public class MarsPersistentTokenRepository implements PersistentTokenRepository {

    private final PersistentLoginsMapper persistentLoginsMapper;

    @Override
    public void createNewToken(PersistentRememberMeToken token) {
        persistentLoginsMapper.createNewToken(token.getUsername(),token.getSeries(),token.getTokenValue(),DateUtil.toLocalDateTime(token.getDate()));
    }

    @Override
    public void updateToken(String series, String tokenValue, Date lastUsed) {
        persistentLoginsMapper.updateToken(series,tokenValue,DateUtil.toLocalDateTime(lastUsed));
    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        try {
            List<PersistentLoginsPo> list = persistentLoginsMapper.tokensBySeries(seriesId);
            if (list.size()>1) {
                log.info("Querying token for series '{}' returned more than one value. Series" + " should be unique", seriesId);
                return null;
            }
            if (list.size() == 0) {
                log.info("Querying token for series '{}' returned no results.", seriesId);
                return null;
            }
            PersistentLoginsPo loginsPo = list.get(0);
            return new PersistentRememberMeToken(loginsPo.getUsername(),loginsPo.getSeries(),loginsPo.getToken(), DateUtil.date(loginsPo.getLastUsed()));
        } catch (DataAccessException ex) {
            log.error("Failed to load token for series " + seriesId, ex);
        }
        return null;
    }

    @Override
    public void removeUserTokens(String username) {
        persistentLoginsMapper.removeUserTokens(username);
    }

}

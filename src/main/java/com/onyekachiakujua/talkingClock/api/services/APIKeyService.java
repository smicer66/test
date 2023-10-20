package com.onyekachiakujua.talkingClock.api.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import javax.servlet.http.HttpServletRequest;
import com.onyekachiakujua.talkingClock.config.ApiKeyAuthentication;

public class APIKeyService {
    private static final String HEADER_KEY = "TALKING-CLOCK-KEY";
    private static final String VALID_TOKEN = "b9jhKIh4St+TJp2wBJS+E1CX1dIqgzCs+dIpWdGuDO82mTNsxyWnNrV0OL20O/JP";

    public static Authentication authenticate(HttpServletRequest request) throws Exception {
        String apiKeyValue = request.getHeader(HEADER_KEY);
        if (apiKeyValue == null || !apiKeyValue.equals(VALID_TOKEN)) {
            throw new Exception("Key provided does not match any valid API keys");
        }

        return new ApiKeyAuthentication(apiKeyValue, AuthorityUtils.NO_AUTHORITIES);
    }
}

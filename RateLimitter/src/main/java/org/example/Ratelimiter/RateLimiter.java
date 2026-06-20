package org.example.Ratelimiter;

import org.example.Enum.RateLimiterType;
import org.example.model.RateLimiterConfig;

public abstract class RateLimiter {

    protected RateLimiterConfig config;
    protected RateLimiterType type;

    RateLimiter(RateLimiterConfig config, RateLimiterType type){
        this.config = config;
        this.type = type;
    }

    public abstract boolean allowRequest(String userId);
}

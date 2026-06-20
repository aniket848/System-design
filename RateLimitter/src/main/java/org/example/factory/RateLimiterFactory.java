package org.example.factory;

import org.example.Enum.RateLimiterType;
import org.example.Ratelimiter.RateLimiter;
import org.example.Ratelimiter.TokenRateLimiter;
import org.example.Ratelimiter.fixedWindowRateLimiter;
import org.example.Ratelimiter.slidingWindowRateLimiter;
import org.example.model.RateLimiterConfig;

public class RateLimiterFactory {

    public static RateLimiter createRateLimiter(RateLimiterConfig config, RateLimiterType rateLimiterType){

        return switch(rateLimiterType){
            case FIXED_WINDOW -> new fixedWindowRateLimiter(config);
            case SLIDING_WINDOW -> new slidingWindowRateLimiter(config);
            case TOKEN_BUCKET -> new TokenRateLimiter(config);
             default -> throw new IllegalArgumentException("Invalid rate limiter type: " + rateLimiterType);
        };
    }
}

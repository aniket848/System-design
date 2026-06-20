package org.example.service;

import org.example.Enum.Usertier;
import org.example.Ratelimiter.RateLimiter;
import org.example.Ratelimiter.TokenRateLimiter;
import org.example.Ratelimiter.fixedWindowRateLimiter;
import org.example.Ratelimiter.slidingWindowRateLimiter;
import org.example.model.RateLimiterConfig;
import org.example.model.User;

import java.util.HashMap;
import java.util.Map;

public class RateLimiterService {

    Map<Usertier, RateLimiter> rateLimiterMap = new HashMap<>();

    public RateLimiterService(){

        // for free user
        rateLimiterMap.put(Usertier.FREE ,
                new slidingWindowRateLimiter(new RateLimiterConfig(10, 60))
        );

        // for premium user
        rateLimiterMap.put(Usertier.PREMIUM,
                new slidingWindowRateLimiter(new RateLimiterConfig(15, 60))
        );
    }

    public boolean executeRequest(User user){
        RateLimiter rateLimiter = rateLimiterMap.get(user.getUsertier());

        return rateLimiter.allowRequest(user.getUserId());
        //System.out.println("Request for user " + user.getName() + " with tier " + user.getUsertier() + ": " + res);

    }
}

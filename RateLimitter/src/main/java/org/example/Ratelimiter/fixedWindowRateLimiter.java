package org.example.Ratelimiter;

import org.example.Enum.RateLimiterType;
import org.example.model.RateLimiterConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class fixedWindowRateLimiter extends RateLimiter {

    Map<String, Integer> userRequestCount = new ConcurrentHashMap<>(); // {userId, requestCount}
    Map<String, Long> windowStartTime = new HashMap<>(); // {userId, windowStartTime}

    public fixedWindowRateLimiter(RateLimiterConfig config){
        super(config, RateLimiterType.FIXED_WINDOW);
    }

    @Override
    public boolean allowRequest(String userId) {
        // Implement the logic for fixed window rate limiting here


        AtomicBoolean isAllowed = new AtomicBoolean(false);

        userRequestCount.compute(userId, (id, count)->{
            long now = System.currentTimeMillis();
            long currentWindow = now /1000 / config.getTimeWindow();
            long prevWindow = windowStartTime.getOrDefault(id, currentWindow);

            if(currentWindow != prevWindow){ // new session starts
                windowStartTime.put(id,currentWindow);
                isAllowed.set(true);
                return 1; // reset request count to 1 for that user in new session
            }

            if(count == null) count=0;

            if(count < config.getMaxRequests()){
                isAllowed.set(true);
                return count+1;
            }

            return count;

        });

        return isAllowed.get();
    }
}

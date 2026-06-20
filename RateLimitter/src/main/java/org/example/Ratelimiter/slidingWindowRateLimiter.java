package org.example.Ratelimiter;

import org.example.Enum.RateLimiterType;
import org.example.model.RateLimiterConfig;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class slidingWindowRateLimiter extends RateLimiter {

    Map<String, Queue<Long>> userRequestTimeStamp = new ConcurrentHashMap<>();

    public slidingWindowRateLimiter(RateLimiterConfig config) {
        super(config, RateLimiterType.SLIDING_WINDOW);
    }

    @Override
    public boolean allowRequest(String userId) {


        AtomicBoolean isAllowed = new AtomicBoolean(false);
        long now = System.currentTimeMillis()/1000;

        userRequestTimeStamp.compute( userId, (id, log)->{

            if(log == null)
                log = new ArrayDeque<>();

            while(!log.isEmpty() && (now - log.peek())> config.getTimeWindow()){
                log.poll();
            }

            if(log.size() < config.getMaxRequests()){
                isAllowed.set(true);
                log.offer(now);
            }

            return log;

        });

        return isAllowed.get();
    }
}

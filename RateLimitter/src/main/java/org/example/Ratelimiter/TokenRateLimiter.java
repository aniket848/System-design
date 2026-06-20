package org.example.Ratelimiter;

import org.example.Enum.RateLimiterType;
import org.example.model.RateLimiterConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class TokenRateLimiter extends RateLimiter {

    Map<String, Long> lastRefill = new HashMap<>();
    Map<String , Integer> tokens = new ConcurrentHashMap<>();



    public TokenRateLimiter(RateLimiterConfig config) {
        super(config, RateLimiterType.TOKEN_BUCKET);
    }

    @Override
    public boolean allowRequest(String userId) {

        AtomicBoolean isAllowed = new AtomicBoolean(false);
        tokens.compute(userId , (id,tokenCount)->{

            long now = System.currentTimeMillis();

            int refillTokens = calculateTokensToAdd(now, id);

            if(refillTokens > 0){
                isAllowed.set(true);
                //System.out.println("reached here refillTokens :"+refillTokens);
                return refillTokens - 1; // consume one token for the current request
            }

            return refillTokens;

        });

        //System.out.println("Tokens left for user " + userId + ": " + tokens.get(userId) + " allowed: " + isAllowed.get());
        return isAllowed.get();
    }

    private Integer calculateTokensToAdd(long now, String userId){

        long lastRefillTime = lastRefill.getOrDefault(userId, now);
        long elapsedSeconds = (now - lastRefillTime)/1000;
        int tokenFillRate = (int)config.getTimeWindow() / config.getMaxRequests();

        int tokensToAdd  = (int)elapsedSeconds/tokenFillRate;
        int currentTokens = tokens.getOrDefault(userId, config.getMaxRequests());
        currentTokens = Math.min(config.getMaxRequests(), currentTokens + tokensToAdd);

        if(currentTokens > 0){
            lastRefill.put(userId, now);
        }

        return currentTokens;
    }
}

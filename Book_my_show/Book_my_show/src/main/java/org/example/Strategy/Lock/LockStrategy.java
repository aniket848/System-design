package org.example.Strategy.Lock;

public interface LockStrategy {

    public Boolean TryLock(String key, String userId, Long ttlMs);
    public Boolean unlock(String key);
    public Boolean isExpired(String key);
    public Boolean isLockedBy(String key, String userId);
}

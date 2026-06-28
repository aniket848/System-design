package org.example.Strategy.Lock;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryLockStrategy implements LockStrategy{

    private static class Expiry{
        public Long deadline;
        public String owner;

        public Expiry(Long deadline, String owner) {
            this.deadline = deadline;
            this.owner = owner;
        }

        public Long getDeadline() {
            return deadline;
        }

        public String getOwner() {
            return owner;
        }
    }

    private final Map<String,Expiry> locks = new ConcurrentHashMap<>();

    @Override
    public Boolean TryLock(String key, String userId, Long ttlMs) {

        Long now = System.currentTimeMillis();
        Long deadline = now + ttlMs;
        Expiry expiry = new Expiry(deadline,userId);

        locks.compute(key,(k,v)-> {
            if(v==null || v.deadline < now){
                return expiry;
            }
            return v;
        });
        return locks.get(key) == expiry; // whether new expiry is set or not, if set then lock is acquired
    }

    @Override
    public Boolean unlock(String key) {
        locks.remove(key);
        return true;
    }

    @Override
    public Boolean isExpired(String key) {
        return locks.get(key).deadline < System.currentTimeMillis();
    }

    @Override
    public Boolean isLockedBy(String key, String userId) {
        Expiry expiry = locks.get(key);
        if(expiry==null){
            return false;
        }
        return expiry.getOwner().equals(userId);
    }
}

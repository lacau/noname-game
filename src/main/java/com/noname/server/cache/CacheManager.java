package com.noname.server.cache;

import org.apache.jcs.JCS;
import org.apache.jcs.access.exception.CacheException;
import org.springframework.stereotype.Component;

/**
 * Created by lacau on 16/02/16.
 */
@Component
public class CacheManager {

    private JCS cache;

    public CacheManager() {
        try {
            cache = JCS.getInstance("default");
        } catch(CacheException e) {
            e.printStackTrace();
        }
    }

    public void store(CredentialCache value) {
        try {
            cache.put(value.id, value);
        } catch(CacheException e) {
            e.printStackTrace();
        }
    }

    public CredentialCache retrieve(Long key) {
        return (CredentialCache) cache.get(key);
    }
}
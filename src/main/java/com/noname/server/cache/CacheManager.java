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
        final Object value = cache.get(key);
        return value != null ? (CredentialCache) value : null;
    }

    public void remove(Long key) {
        try {
            cache.remove(key);
        } catch(CacheException e) {
            e.printStackTrace();
        }
    }
}
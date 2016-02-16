package com.noname.server.cache;

import com.noname.server.json.CredentialOut;
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

    public void store(CredentialOut value) {
        try {
            cache.put(value.getId(), value);
        } catch(CacheException e) {
            e.printStackTrace();
        }
    }

    public CredentialOut retrieve(Long key) {
        return (CredentialOut) cache.get(key);
    }
}

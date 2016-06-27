package com.noname.server.security;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

import com.noname.server.resource.AccountResource;
import com.noname.server.resource.LoginResource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lacau on 12/02/16.
 */
@Provider
public class LoginFeature implements DynamicFeature {

    @Autowired
    private LoginFilter loginFilter;

    @Autowired
    private CORSFilter corsFilter;

    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext context) {
        if(resourceShouldBeFiltered(resourceInfo))
            context.register(loginFilter);
        context.register(corsFilter);
    }

    private boolean resourceShouldBeFiltered(ResourceInfo resourceInfo) {
        if(resourceInfo.getResourceClass() == AccountResource.class)
            return false;

        if(resourceInfo.getResourceClass() == LoginResource.class)
            return false;

        return true;
    }
}
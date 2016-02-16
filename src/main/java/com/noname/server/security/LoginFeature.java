package com.noname.server.security;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

import com.noname.server.endpoint.AccountEndPoint;
import com.noname.server.endpoint.LoginEndPoint;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lacau on 12/02/16.
 */
@Provider
public class LoginFeature implements DynamicFeature {

    @Autowired
    private LoginFilter loginFilter;

    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext context) {
        if(resourceShouldBeFiltered(resourceInfo))
            context.register(loginFilter);
    }

    private boolean resourceShouldBeFiltered(ResourceInfo resourceInfo) {
        if(resourceInfo.getResourceClass() == AccountEndPoint.class)
            return false;

        if(resourceInfo.getResourceClass() == LoginEndPoint.class)
            return false;

        return true;
    }
}
package com.taxrobot.gateway.filters;

import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.tasks.Tasks;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.taxrobot.gateway.connectDS.FireBaseComponent;
import com.taxrobot.gateway.util.JwtComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.ExecutionException;

public class SecureFilter extends ZuulFilter {

    @Autowired
    FireBaseComponent fireBaseComponent;

    @Autowired
    JwtComponent jwtComponent;

    private static final Logger LOGGER = LoggerFactory.getLogger(SecureFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        LOGGER.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        try {
            FirebaseToken token = Tasks.await(jwtComponent.verifyJWT(fireBaseComponent.getFirebaseApp(), request.getHeader("Authorization")));
            if (token != null) {
                requestContext.addZuulRequestHeader("entity", token.getClaims().get("entity").toString());
                LOGGER.info("Validación completa: " + token.getClaims().get("entity").toString());
            }
        } catch (ExecutionException | InterruptedException e) {
            LOGGER.error(e.getClass() + ": " + e.getMessage());
            requestContext.setResponseBody("NOT AUTHORIZED");
            requestContext.setSendZuulResponse(false);
        }
        return requestContext.getResponse();
    }
}

package com.smartsoft.app.data.rest;

import android.util.Base64;
import javax.inject.Inject;
import javax.inject.Singleton;
import retrofit.RequestInterceptor;

@Singleton
public final class ApiHeaders implements RequestInterceptor {
    public static final String AUTHORIZATION = "Authorization";
    public static final String BASIC = "Basic %s";
    //TODO: set correct credentials
    public static final String CREDENTIALS = "user:pass";

    @Inject
    public ApiHeaders() {
    }

    @Override
    public void intercept(RequestFacade request) {
        //TODO: uncomment if api requires basic auth
        request.addHeader(AUTHORIZATION, String.format(BASIC,
                Base64.encodeToString(CREDENTIALS.getBytes(), Base64.NO_WRAP)));
    }
}
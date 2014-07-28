package com.smartsoft.app.data.rest;

import com.smartsoft.app.data.rest.model.base.ResponseBase;
import java.util.List;
import retrofit.http.Body;
import retrofit.http.POST;
import rx.Observable;

//TODO: insert api methods here
interface RestApi {
    @POST("/someEndpoint/")
    public Observable<ResponseBase<Object>> someEndpoint(@Body List<Object> someBody);
}
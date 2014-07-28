package com.smartsoft.app.data.rest;

import com.smartsoft.app.data.rest.model.base.ResponseBase;
import hugo.weaving.DebugLog;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@Singleton
public class ApiManager {
    RestApi restApi;

    @Inject
    public ApiManager(RestApi restApi) {
        this.restApi = restApi;
    }

    @DebugLog
    public Observable<ResponseBase<Object>> someEndpoint(final List<Object> someBody) {
        return restApi.someEndpoint(someBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}

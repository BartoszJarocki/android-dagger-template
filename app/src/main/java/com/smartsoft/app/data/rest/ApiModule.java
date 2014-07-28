package com.smartsoft.app.data.rest;

import com.squareup.okhttp.OkHttpClient;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import retrofit.Endpoint;
import retrofit.Endpoints;
import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.client.OkClient;

@Module(
        complete = false,
        library = true)
public final class ApiModule {
    //TODO: insert correct api url
    public static final String PRODUCTION_API_URL = "http://productionurl";

    @Provides @Singleton Endpoint provideEndpoint() {
        return Endpoints.newFixedEndpoint(ApiEndpoints.PRODUCTION.url);
    }

    @Provides @Singleton Client provideClient(OkHttpClient client) {
        return new OkClient(client);
    }

    @Provides @Singleton RestAdapter provideRestAdapter(Endpoint endpoint, Client client,
            ApiHeaders headers) {

        return new RestAdapter.Builder() //
                .setClient(client) //
                .setLogLevel(RestAdapter.LogLevel.FULL).setEndpoint(endpoint) //
                .setRequestInterceptor(headers) //
                .build();
    }

    @Provides @Singleton RestApi provideJojoRestApi(RestAdapter restAdapter) {
        return restAdapter.create(RestApi.class);
    }

    @Provides @Singleton ApiManager provideApiManager(RestApi restApi) {
        return new ApiManager(restApi);
    }
}
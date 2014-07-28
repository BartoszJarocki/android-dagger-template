package com.smartsoft.app;

import android.app.Application;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module(
        library = true,
        injects = {
                AppNameApplication.class
        })
public final class AppModule {
    private final AppNameApplication app;

    public AppModule(AppNameApplication app) {
        this.app = app;
    }

    @Provides @Singleton Application provideApplication() {
        return app;
    }
}

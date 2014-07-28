package com.smartsoft.app;

import android.app.Application;
import android.content.Context;
import com.smartsoft.app.utils.Injector;
import dagger.ObjectGraph;
import hugo.weaving.DebugLog;
import timber.log.Timber;

//TODO: change to proper class name
public class AppNameApplication extends Application implements Injector {
    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new CrashReportingTree());
        }

        buildObjectGraphAndInject();
        registerActivityLifecycleCallbacks(new AppActivityCallbacks());
    }

    @DebugLog
    public void buildObjectGraphAndInject() {
        objectGraph = ObjectGraph.create(new Object[] {
                new AppModule(get(AppNameApplication.this))
        });
        objectGraph.inject(this);
    }

    @Override
    public void inject(Object object) {
        objectGraph.inject(object);
    }

    @Override
    public ObjectGraph getObjectGraph() {
        return objectGraph;
    }

    public static AppNameApplication get(Context context) {
        return (AppNameApplication) context.getApplicationContext();
    }

    /**
     * A tree which logs important information for crash reporting.
     */
    private static class CrashReportingTree extends Timber.HollowTree {
        @Override
        public void i(String message, Object... args) {
            // TODO e.g., Crashlytics.log(String.format(message, args));
        }

        @Override
        public void i(Throwable t, String message, Object... args) {
            i(message, args); // Just add to the log.
        }

        @Override
        public void e(String message, Object... args) {
            i("ERROR: " + message, args); // Just add to the log.
        }

        @Override
        public void e(Throwable t, String message, Object... args) {
            e(message, args);

            // TODO e.g., Crashlytics.logException(t);
        }
    }
}
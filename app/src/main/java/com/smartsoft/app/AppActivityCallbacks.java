package com.smartsoft.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import timber.log.Timber;

/**
 * Created by bartoszjarocki on 07/07/14.
 */
public class AppActivityCallbacks implements Application.ActivityLifecycleCallbacks {
    @Override public void onActivityCreated(Activity activity, Bundle bundle) {
        Timber.d("Activity created: " + activity.getComponentName().getShortClassName());
    }

    @Override public void onActivityStarted(Activity activity) {
        Timber.d("Activity started: " + activity.getComponentName().getShortClassName());
    }

    @Override public void onActivityResumed(Activity activity) {
        Timber.d("Activity resumed: " + activity.getComponentName().getShortClassName());
    }

    @Override public void onActivityPaused(Activity activity) {
        Timber.d("Activity paused: " + activity.getComponentName().getShortClassName());
    }

    @Override public void onActivityStopped(Activity activity) {
        Timber.d("Activity stopped: " + activity.getComponentName().getShortClassName());
    }

    @Override public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Timber.d("Activity saveInstance: " + activity.getComponentName().getShortClassName());
    }

    @Override public void onActivityDestroyed(Activity activity) {
        Timber.d("Activity destroyed: " + activity.getComponentName().getShortClassName());
    }
}

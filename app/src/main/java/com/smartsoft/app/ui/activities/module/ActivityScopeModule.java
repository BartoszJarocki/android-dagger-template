package com.smartsoft.app.ui.activities.module;

import android.app.Activity;
import android.content.Context;
import com.smartsoft.app.annotations.ForActivity;
import com.smartsoft.app.data.DataModule;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module(
        complete = false,
        library = true,
        includes = DataModule.class,
        injects = {
        })
public class ActivityScopeModule {
    private final Activity mActivity;

    public ActivityScopeModule(Activity activity) {
        mActivity = activity;
    }

    @Provides @Singleton @ForActivity Context providesActivityContext() {
        return mActivity;
    }
    @Provides @Singleton Activity providesActivity() {
        return mActivity;
    }
}
package com.smartsoft.app.ui.activities.module;

import android.app.Activity;
import android.content.Context;
import com.smartsoft.app.annotations.ForActivity;
import com.smartsoft.app.data.DebugDataModule;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module(
        overrides = true,
        complete = false,
        library = true,
        includes = DebugDataModule.class,
        injects = {
        })
public class DebugActivityScopeModule {
    private final Activity mActivity;

    public DebugActivityScopeModule(Activity activity) {
        mActivity = activity;
    }

    @Provides @Singleton @ForActivity Context providesActivityContext() {
        return mActivity;
    }
    @Provides @Singleton Activity providesActivity() {
        return mActivity;
    }
}
package com.smartsoft.app.data;

import com.smartsoft.app.data.rest.DebugApiModule;
import dagger.Module;

@Module(
        includes = {
                DebugApiModule.class,
                DataModule.class
        },
        complete = false,
        library = true,
        overrides = true)
public final class DebugDataModule {
}

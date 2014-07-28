package com.smartsoft.app;

import dagger.Module;

@Module(
    addsTo = AppModule.class,
    overrides = true
)
public final class DebugAppModule {
}

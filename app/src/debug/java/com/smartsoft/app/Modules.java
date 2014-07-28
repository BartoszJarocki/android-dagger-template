package com.smartsoft.app;

import android.app.Activity;
import com.smartsoft.app.ui.activities.module.DebugActivityScopeModule;

public final class Modules {
    public static Object[] list(Activity activity) {
        return new Object[] {
                new DebugActivityScopeModule(activity)
        };
    }

    private Modules() {
        // No instances.
    }
}
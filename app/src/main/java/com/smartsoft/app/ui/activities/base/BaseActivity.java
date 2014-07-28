package com.smartsoft.app.ui.activities.base;

import android.app.Activity;
import android.os.Bundle;
import com.smartsoft.app.AppNameApplication;
import com.smartsoft.app.data.rest.ApiManager;
import com.smartsoft.app.utils.Injector;
import com.squareup.otto.Bus;
import dagger.ObjectGraph;
import hugo.weaving.DebugLog;
import javax.inject.Inject;

/**
 * Created by bartoszjarocki on 23/02/14.
 */
public abstract class BaseActivity extends Activity implements Injector {
    @Inject ApiManager apiManager;
    @Inject Bus dataBus;

    protected ObjectGraph mActivityGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        inject();
        setupActionBar();
    }

    @Override
    protected void onDestroy() {
        clearData();

        super.onDestroy();
    }

    /**
     * Inject the supplied {@code object} using the activity-specific graph.
     */
    @Override
    public void inject(Object object) {
        mActivityGraph.inject(object);
    }

    @Override
    public ObjectGraph getObjectGraph() {
        return mActivityGraph;
    }

    protected abstract Object[] getActivitytModules();

    @DebugLog
    private void inject() {
        // Create the activity graph by .plus-ing our modules onto the application graph.
        AppNameApplication application = AppNameApplication.get(this);
        mActivityGraph = application.getObjectGraph().plus(getActivitytModules());

        // Inject ourselves so subclasses will have dependencies fulfilled when this method returns.
        mActivityGraph.inject(this);
    }

    private void setupActionBar() {
        if (getActionBar() == null) {
            return;
        }

        getActionBar().setDisplayShowTitleEnabled(false);
    }

    private void clearData() {
        // Eagerly clear the reference to the activity graph to allow it to be garbage collected as
        // soon as possible.
        mActivityGraph = null;
    }
}

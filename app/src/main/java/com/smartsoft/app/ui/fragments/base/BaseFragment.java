package com.smartsoft.app.ui.fragments.base;

import android.app.Fragment;
import android.os.Bundle;
import com.smartsoft.app.data.rest.ApiManager;
import com.smartsoft.app.ui.activities.base.BaseActivity;
import com.squareup.otto.Bus;
import javax.inject.Inject;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class BaseFragment extends Fragment {

    @Inject protected Bus dataBus;
    @Inject protected ApiManager apiManager;

    public BaseFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        inject();
    }

    @Override
    public void onStart() {
        super.onStart();

        dataBus.register(this);
    }

    @Override
    public void onStop() {
        dataBus.unregister(this);

        super.onStop();
    }

    private void inject() {
        // Assume that it lives within a BaseActivity host
        ((BaseActivity) getActivity()).inject(this);
    }
}

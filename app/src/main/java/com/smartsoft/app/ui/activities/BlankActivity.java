package com.smartsoft.app.ui.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.smartsoft.app.Modules;
import com.smartsoft.app.R;
import com.smartsoft.app.ui.activities.base.BaseActivity;

public class BlankActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank);
    }

    @Override protected Object[] getActivitytModules() {
        return Modules.list(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.blank, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}

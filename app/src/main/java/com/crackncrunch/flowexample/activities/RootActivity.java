package com.crackncrunch.flowexample.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.crackncrunch.flowexample.IView;
import com.crackncrunch.flowexample.R;
import com.crackncrunch.flowexample.RedScreen;
import com.crackncrunch.flowexample.flow.TreeKeyDispatcher;

import flow.Flow;

public class RootActivity extends AppCompatActivity {

    private FrameLayout mRootFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);

        mRootFrame = (FrameLayout) findViewById(R.id.root_frame);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        newBase = Flow.configure(newBase, this)
                .defaultKey(new RedScreen())
                .dispatcher(new TreeKeyDispatcher(this))
                .install();
        super.attachBaseContext(newBase);
    }

    @Override
    public void onBackPressed() {
        if (getCurrentScreen() != null && !getCurrentScreen().viewBackPressed()
                && !Flow.get(this).goBack()) {
            // TODO: 09-Feb-17 implement exit dialog
            super.onBackPressed();
        }
    }

    private IView getCurrentScreen() {
        return (IView) mRootFrame.getChildAt(0);
    }
}

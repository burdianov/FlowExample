package com.crackncrunch.flowexample;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import flow.Flow;

public class RootActivity extends AppCompatActivity {

    private FrameLayout mRootFrame;

    @Override
    protected void attachBaseContext(Context newBase) {
        newBase = Flow.configure(newBase, this)
                .defaultKey(new RedScreen())
                .dispatcher(new TreeKeyDispatcher())
                .install();
        super.attachBaseContext(newBase);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);

        mRootFrame = (FrameLayout) findViewById(R.id.root_frame);
    }
}

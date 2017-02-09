package com.crackncrunch.flowexample;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import flow.Flow;

public class RootActivity extends AppCompatActivity {

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
    }
}

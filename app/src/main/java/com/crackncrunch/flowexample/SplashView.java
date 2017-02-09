package com.crackncrunch.flowexample;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import flow.Flow;

/**
 * Created by Lilian on 10-Feb-17.
 */

public class SplashView extends FrameLayout implements IView {

    public SplashView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Flow.get(SplashView.this).set(new RedScreen());
            }
        }, 3000);
    }

    @Override
    public boolean viewBackPressed() {
        return false;
    }
}

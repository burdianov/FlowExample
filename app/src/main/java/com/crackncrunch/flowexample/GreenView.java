package com.crackncrunch.flowexample;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import flow.Flow;

/**
 * Created by Lilian on 09-Feb-17.
 */
public class GreenView extends LinearLayout implements IView {

    public static final int LIGHT = 0;
    public static final int DARK = 1;

    private GreenScreen mScreen;

    public GreenView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) {
            mScreen = Flow.getKey(this);
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        Button greenButton = (Button) findViewById(R.id.green_btn);
        greenButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mScreen.getState() == DARK) {
                    mScreen.setState(LIGHT);
                    showViewFromState();
                } else {
                    Flow.get(GreenView.this).goBack();
                }
            }
        });

        Button changeButton = (Button) findViewById(R.id.change_btn);
        changeButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mScreen.getState() == LIGHT) {
                    mScreen.setState(DARK);
                    showViewFromState();
                }
            }
        });
        showViewFromState();
    }

    private void showViewFromState() {
        int color;
        if (mScreen.getState() == DARK) {
            color = android.R.color.holo_green_dark;
        } else {
            color = android.R.color.holo_green_light;
        }
        setBackgroundColor(getResources().getColor(color));
    }

    @Override
    public boolean viewBackPressed() {
        if (mScreen.getState() == DARK) {
            mScreen.setState(LIGHT);
            showViewFromState();
            return true;
        }
        return false;
    }
}

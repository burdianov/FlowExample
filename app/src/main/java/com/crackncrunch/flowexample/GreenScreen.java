package com.crackncrunch.flowexample;

import com.crackncrunch.flowexample.flow.Screen;

/**
 * Created by Lilian on 09-Feb-17.
 */

@Screen(R.layout.screen_green)
public class GreenScreen {

    private int mState;

    public GreenScreen(int state) {
        mState = state;
    }

    public void setState(int state) {
        mState = state;
    }

    public int getState() {
        return mState;
    }
}

package com.crackncrunch.flowexample;

/**
 * Created by Lilian on 09-Feb-17.
 */
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

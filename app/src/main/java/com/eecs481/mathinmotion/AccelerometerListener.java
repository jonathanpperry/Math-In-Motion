package com.eecs481.mathinmotion;

import android.view.View;

public interface AccelerometerListener
{
    /* Functions that interface with Activities */
    //tilt up
    public void swipeUp();

    //tilt down
    public void swipeDown();

    //tilt left
    public void swipeLeft();

    //tilt right
    public void swipeRight();

    //shake
    public void nextStep();
}

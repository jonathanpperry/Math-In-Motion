package com.eecs481.mathinmotion;

import android.view.GestureDetector;
import android.view.MotionEvent;

import static java.lang.Math.abs;


public class Gesture extends GestureDetector.SimpleOnGestureListener
{
    private AccelerometerListener listener;

    public Gesture(AccelerometerListener list)
    {
        listener = list;
    }

    public boolean onFling(MotionEvent e1, MotionEvent e2, float velX, float velY)
    {
        if (abs(velX) > abs(velY))
        {
            if (velX > 0)
                listener.swipeRight();
            else
                listener.swipeLeft();
        }
        else
        {
            if (velY > 0)
                listener.swipeDown();
            else
                listener.swipeUp();
        }
        return true;
    }
}

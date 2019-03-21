package com.eecs481.mathinmotion;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Peter on 3/9/2015.
 */
public class Motion implements SensorEventListener {
    private static Motion instance = null;
    private SensorManager mSensorManager;
    private ArrayList<MotionListener> listeners;
    private long lastUpdate = 0;
    private float last_x, last_y, last_z;
    boolean waiting = false;
    private long sleeptime = 0;
    private Motion() {
        listeners = new ArrayList<MotionListener>();
    }

    public static Motion getInstance() {
        if (instance == null)
            instance = new Motion();
        return instance;
    }

    public void addListener(Context context, MotionListener listener) {
        if (listeners.size() == 0) {
            mSensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
            Sensor mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
            mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
        listeners.add(listener);
    }

    public void removeListener(MotionListener listener) {

        listeners.remove(listener);
        if (listeners.size() == 0)
            mSensorManager.unregisterListener(this);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void onSensorChanged(SensorEvent event) { //detects change and acts accordingly=
        long curTime = System.currentTimeMillis();
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];
        if (curTime - lastUpdate > 200) //wait 200 ms to get get opposite direction accel data
        {
            waiting = true;
        }
        if (curTime - lastUpdate > 1500) //wait 1.5 seconds to reset sensors
        {
            last_x = 0;
            last_y = 0;
            last_z = 0;
        }
        if (curTime - sleeptime < 900) {//0.9 seconds to give user time to return device back to centered position
            return;
        } else {
            sleeptime = 0;
        }

        if (waiting && (Math.abs(x) >= 1 || Math.abs(y) >= 0.8 || Math.abs(z) >= 2)//if all the values are significant enough, you do stuff
                && (Math.abs(last_x) >= 2.5 || Math.abs(last_y) >= 2.5 || Math.abs(last_z) >= 3)) {
            Log.d("lastx", Float.toString(last_x));
            Log.d("lasty",Float.toString(last_y));
            Log.d("lastz",Float.toString(last_z));
            Log.d("x",Float.toString(x));
            Log.d("y",Float.toString(y));
            Log.d("z",Float.toString(z));
            waiting = false;// waiting for next time to capture motion
            //if absolute value tan of the angle of motion is between a certain range, then one of corner numbers
            if ( Math.abs(last_x) > Math.abs(last_z)-2 && (Math.abs(last_y) > Math.abs(last_z)-2)
                    && Math.abs(last_x/last_y) > 0.5 && Math.abs(last_x/last_y) <2) {
                Log.d("got here","a");

                if ((last_x >x) &&(last_y > y) && last_x >1 && last_y > 1) { // if both x and y positive acceleration
                    Log.d("direction","3");
                    append(3);
                    last_x = 0;
                    last_y = 0;
                    last_z = 0;
                    sleeptime = System.currentTimeMillis();
                } else  if ((last_x <x) &&(last_y > y) && last_x < -1 && last_y > 1) { // if x is neg and y pos
                    Log.d("direction","1");
                    append(1);
                    last_x = 0;
                    last_y = 0;
                    last_z = 0;
                    sleeptime = System.currentTimeMillis();
                } else  if ((last_x <x) &&(last_y < y) && last_x < -1 && last_y < -1) { // if both negative
                    Log.d("direction","7");
                    append(7);
                    last_x = 0;
                    last_y = 0;
                    last_z = 0;
                    sleeptime = System.currentTimeMillis();
                } else  if ((last_x >x) &&(last_y < y) && last_x > 1 && last_y < -1) { //if y is neg and x is pos
                    Log.d("direction","9");
                    append(9);
                    last_x = 0;
                    last_y = 0;
                    last_z = 0;
                    sleeptime = System.currentTimeMillis();
                }
            }
            else if (last_x != 0 && Math.abs(last_x) > Math.abs(last_z)-2 && (Math.abs(last_y) >
                    Math.abs(last_z)-2) &&( Math.abs(last_x/last_y) < 0.5 || Math.abs(last_x/last_y) >2)) {
                //if side to side or up down is most significant
                Log.d("got here","b");
                if ((last_y > y) && last_y > 1 && Math.abs(last_y) > Math.abs(last_x)) {//if up is most significant
                    Log.d("direction","2");
                    append(2);
                    last_y = 0;
                    last_x = 0;
                    last_z = 0;
                    sleeptime = System.currentTimeMillis();
                }
                else if ((last_y < y) && last_y < -1 && Math.abs(last_y) > Math.abs(last_x)) {// down most significant
                    Log.d("direction","8");
                    append(8);
                    last_y = 0;
                    last_x = 0;
                    last_z = 0;
                    sleeptime = System.currentTimeMillis();
                }
                else if ((last_x < x) && last_x < -1 && Math.abs(last_x) > Math.abs(last_y)) { //left most sig.
                    Log.d("direction","4");
                    append(4);
                    last_y = 0;
                    last_x = 0;
                    last_z = 0;
                    sleeptime = System.currentTimeMillis();
                }
                else if ((last_x > x) && last_x > 1 && Math.abs(last_x) > Math.abs(last_y)) {//right most sig
                    Log.d("direction","6");
                    append(6);
                    last_y = 0;
                    last_x = 0;
                    last_z = 0;
                    sleeptime = System.currentTimeMillis();
                }
            }
        } else if (Math.abs(last_z) > Math.abs(last_y)+1 && Math.abs(last_z) > Math.abs(last_x)+1 && (Math.abs(x) >= 1 || Math.abs(y) >= 0.8 || Math.abs(z) >= 2)
                && (Math.abs(last_x) >= 2.5 || Math.abs(last_y) >= 2.5 || Math.abs(last_z) >= 3)) {// if z direction most significant

            Log.d("z","z");
            if (last_z < z && last_z <-1 ) {//if outward most significant
                append(5);
                last_y = 0;
                last_x = 0;
                last_z = 0;
                sleeptime = System.currentTimeMillis();
            }
            else if (last_z > z && last_z >1 ) {// if inward most significant
                append(0);
                last_y = 0;
                last_x = 0;
                last_z = 0;
                sleeptime = System.currentTimeMillis();
            }

        }
        lastUpdate = curTime;//time of sensing
        last_x = x;
        last_y = y;
        last_z = z;
    }
    public void append(int digit)
    {
        for (MotionListener listener : listeners)
            listener.append(Integer.toString(digit));
    }
}

package com.example.catchtheballapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class Akcelerometr  implements SensorEventListener {


    private final Akcelerometr context;

    private AkcModel akcModel = new AkcModel();
    public Akcelerometr(Context context) {
        this.context=this;
        SensorManager manager = (SensorManager)context.getSystemService( Context.SENSOR_SERVICE );
        Sensor accel = manager.getDefaultSensor( Sensor.TYPE_ACCELEROMETER );
        manager.registerListener( this, accel, SensorManager.SENSOR_DELAY_GAME );
    }



    @Override
    public void onSensorChanged(SensorEvent event) {

        akcModel.setX(event.values[0]);

    }
    public float getValue0()
    {
        return akcModel.getX();
    }
    
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}

package com.example.catchtheballapp;

import android.content.SharedPreferences;
import android.view.View;
public class Statistics{
       private  int points;

    public Statistics(int points) {
        this.points = points;
    }

    int getPoints() {
        return points;
    }

    void setPoints(int points) {
        this.points = points;
    }


}

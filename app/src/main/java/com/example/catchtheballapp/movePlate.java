package com.example.catchtheballapp;

public class movePlate {
    int movePlate(float akc_X, int plateX) {
int x=0;
        if (akc_X < -1)
            x = plateX + 20;
        if (akc_X > 1)
            x=plateX - 20;
        return x;
    }



}


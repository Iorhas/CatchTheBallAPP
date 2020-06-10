package com.example.catchtheballapp;

public class Ball {
    private int x_pos;
    private int y_pos;
    private int rad;

    public Ball(int x_pos, int y_pos,int rad) {
        this.x_pos = x_pos;
        this.y_pos = y_pos;
        this.rad=rad;
    }

    public int getX_pos() {
        return x_pos;
    }

    public void setX_pos(int x_pos) {
        this.x_pos = x_pos;
    }

    public int getY_pos() {
        return y_pos;
    }

    public void setY_pos(int y_pos) {
        this.y_pos = y_pos;
    }

    public int getRad() {
        return rad;
    }

    public void setRad(int rad) {
        this.rad = rad;
    }
}
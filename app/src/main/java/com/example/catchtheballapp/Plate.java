package com.example.catchtheballapp;

public class Plate {
    private int x_pos;
    private int y_pos;
    private int rad;


    public Plate(int x, int y, int r) {
        this.x_pos = x;
        this.y_pos = y;
        this.rad = r;
    }

    public int get_x_pos() {
        return x_pos;
    }

    public int get_y_pos() {
        return y_pos;
    }

    public int get_rad(){return rad;}


    public void set_x_pos(int x) {
        this.x_pos = x;
    }

    public void set_y_pos(int y) {
        this.y_pos = y;
    }

}


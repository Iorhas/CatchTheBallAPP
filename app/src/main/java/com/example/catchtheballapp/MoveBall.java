package com.example.catchtheballapp;

public class MoveBall {

    public int moveBall(int x_position, int  speed)
    {
        int p;
        p=x_position+speed;
        return p;
    }
    public boolean checkHit(int x_plate,int x_ball,int y_plate,int y_ball)
    {
        if (x_ball+50 >= x_plate-50 && x_ball-50<=x_plate+50 && y_ball>=y_plate )
        {
            return true;
        }
        return false;
    }
    public int returnPoints(int points,int w)
    {
        return points+w;
    }
    public boolean checkLife (int x ) {
        if (x <= 0) {
            return true;
        }
        return false;
    }
    public int mathRandom(int edge_right, int edge_left)
    {
        return (int) (Math.random() * (edge_right - edge_left + 1) + edge_left);

    }



    }


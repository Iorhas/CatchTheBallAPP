package com.example.catchtheballapp;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;

import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;


public class Component extends View {

    Statistics statistics = new Statistics();
    DisplayMetrics metrics = getContext().getResources().getDisplayMetrics();
    int edge_bottom=metrics.heightPixels-100;
    int edge_top=50;
    int edge_right= metrics.widthPixels-50;
    int edge_left = 50;
    String toastText = "Przegrałeś, kliknij w ekran by rozpocząć nową grę.";
    boolean start_game = true;
    movePlate movePlatee = new movePlate();
    MoveBall moveBall = new MoveBall();
    Runnable runnable;
    Handler handler;
    private Paint p, p1, p2, p3,p4;
    Akcelerometr akcelerometr = new Akcelerometr(getContext());
    private Plate plate = new Plate(metrics.widthPixels/2, edge_bottom-25, 50);
    private Ball ball = new Ball(540, edge_top, 50);
    private Ball blackBall = new Ball(540, edge_top, 50);
    private Ball orangeBall = new Ball(540, edge_top, 50);
    int x = plate.get_x_pos();
    int points = 0;
    int life = 2;


    @SuppressLint("ShowToast")
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN)

            start_game = true;
        return super.onTouchEvent(event);
    }
    public Component(Context context, AttributeSet attrs) {
        super(context, attrs);

        handler = new android.os.Handler();
        runnable = new Runnable() {

            @Override
            public void run() {
                invalidate();
            }
        };


        p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(Color.WHITE);
        p1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p1.setColor(Color.CYAN);
        p2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p2.setColor(Color.RED);
        p2.setTextSize(60);
        p3 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p3.setColor(Color.YELLOW);
        p4 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p4.setColor(Color.BLACK);
    }



    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        handler.postDelayed(runnable, 10);
        canvas.drawRect(edge_left - 50, edge_top - 50, edge_right + 50, edge_bottom + 50, p4);
        canvas.drawRect(edge_left, edge_top, edge_right, edge_bottom, p);

        // balls
        canvas.drawCircle(ball.getX_pos(), ball.getY_pos(), ball.getRad(), p2);
        canvas.drawCircle(orangeBall.getX_pos(), orangeBall.getY_pos(), orangeBall.getRad(), p3);
        canvas.drawCircle(blackBall.getX_pos(), blackBall.getY_pos(), blackBall.getRad(), p4);
        // plate
        canvas.drawRect( plate.get_x_pos() - 100, plate.get_y_pos() - 20,  plate.get_x_pos() + 100, plate.get_y_pos() + 20, p2);
        //move plate
        x=movePlatee.movePlate(akcelerometr.getValue0(),plate.get_x_pos());

        if (x >= edge_right - 80 || x <= edge_left + 80) {
            x = plate.get_x_pos();
        }


        if (ball.getY_pos() >= edge_bottom-30) {
            ball.setY_pos(0);
            ball.setX_pos(moveBall.mathRandom(edge_right, edge_left));

        }
        if (blackBall.getY_pos() >= edge_bottom-30) {
            blackBall.setY_pos(0);
            blackBall.setX_pos(moveBall.mathRandom(edge_right, edge_left));
        }
        if (orangeBall.getY_pos() >= edge_bottom-30)
       {
            orangeBall.setY_pos(-1000);
            orangeBall.setX_pos(moveBall.mathRandom(edge_right, edge_left));
        }

        if (start_game) {
            plate.set_x_pos(x);
            ball.setY_pos(moveBall.moveBall(ball.getY_pos(), 23));
            orangeBall.setY_pos(moveBall.moveBall(orangeBall.getY_pos(), 28));
            blackBall.setY_pos(moveBall.moveBall(blackBall.getY_pos(), 24));
        }

        // counting points
        if (moveBall.checkHit(plate.get_x_pos(), ball.getX_pos(), plate.get_y_pos(), ball.getY_pos())) {
            points=moveBall.returnPoints(points,10);

        }
        if (moveBall.checkHit(plate.get_x_pos(), orangeBall.getX_pos(), plate.get_y_pos(), orangeBall.getY_pos())) {
            points = moveBall.returnPoints(points,20);

        }
        if (moveBall.checkHit(plate.get_x_pos(), blackBall.getX_pos(), plate.get_y_pos(), blackBall.getY_pos())) {
            life = life - 1;

        }
        // po porazce
        if (moveBall.checkLife(life)) {
            start_game = false;
            ball.setY_pos(0);
            orangeBall.setY_pos(0);
            blackBall.setY_pos(0);
            life = 2;
            points = 0;
            Toast toast= Toast.makeText(getContext(),toastText,Toast.LENGTH_SHORT);
            toast.show();

        }
        if(points>=statistics.getPoints())
            statistics.setPoints(points);


        canvas.drawText("Life" + ":" + life, edge_left+50, 50, p2);
        canvas.drawText("Points" + ":" + points, 380, 50, p2);
        canvas.drawText("Highest "+ ":"+statistics.getPoints(),edge_right-350,50,p2);

    }


}



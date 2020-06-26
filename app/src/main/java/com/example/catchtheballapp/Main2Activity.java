package com.example.catchtheballapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import org.w3c.dom.Text;

import static com.example.catchtheballapp.Component.temp;

public class Main2Activity extends AppCompatActivity {

    static String txt;
    public   int temp_2;
    TextView textView;
int function()
{
    if(temp<temp_2)
    {
        temp=temp_2;
    }
    return temp;
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.textView2);
        textView.setTextColor(Color.RED);
        textView.setTextSize(18);
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        txt = sharedPref.getString("dane", "5");
        textView.setText((txt));

    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onPause() {
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        temp_2 = Integer.parseInt(sharedPref.getString("dane1", String.valueOf(5)));
        function();
        editor.putString("dane1", String.valueOf(temp));
        textView.setText((txt));

        editor.apply();


        super.onPause();


    }

}
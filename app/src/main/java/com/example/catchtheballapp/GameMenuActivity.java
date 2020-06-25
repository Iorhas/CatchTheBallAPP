package com.example.catchtheballapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.catchtheballapp.Component.temp;

public class GameMenuActivity extends AppCompatActivity {
private Button button,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_menu);
        button =(Button) findViewById(R.id.button);
        button2 =(Button) findViewById(R.id.btn1);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain2Activity();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

    }

    public void openMain2Activity()
    {
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);

    }


}

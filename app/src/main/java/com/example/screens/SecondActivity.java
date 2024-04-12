package com.example.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    int item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView view2 = findViewById(R.id.outsideText);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            item = extras.getInt("value");
        }


        int birthYear = birthYear(item);
        if(birthYear < 1924){
            view2.setText("Ah so you where born in " + birthYear + "\n"
                    + "Nah thats wack!");
        }else if (birthYear < 1990) {
            view2.setText("Ah so you where born in " + birthYear + "\n"
                    + "Thats pretty old");
        } else if(birthYear > 2020){
            view2.setText("Ah so you where born in " + birthYear + "\n"
                    + "Stop messing about young man!");
        } else{
            view2.setText("Ah so you where born in " + birthYear + "\n"
                    + "Thats younger than i tought");
        }
    }


public int birthYear(int age){
        return 2024 - age;
    }

}

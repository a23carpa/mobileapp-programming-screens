package com.example.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    String recycleName;
    String recycleAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView view1 = findViewById(R.id.topText);
        TextView view2 = findViewById(R.id.bottomText);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            recycleName = extras.getString("name");
            recycleAge= extras.getString("age");
        }

        view1.setText("Name: " + recycleName);
        view2.setText("Age: " + recycleAge);

    }

}

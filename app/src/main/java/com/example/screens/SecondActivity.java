package com.example.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    String item1;
    String item2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView view1 = findViewById(R.id.topText);
        TextView view2 = findViewById(R.id.bottomText);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            item1 = extras.getString("name");
            item2 = extras.getString("age");
        }

        view1.setText("Name: " + item1);
        view2.setText("Age: " + item2);

    }

}

package com.example.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<recyclerItem> items = new ArrayList<>(Arrays.asList(
                new recyclerItem("Carl", "31"),
                new recyclerItem("David","29"),
                new recyclerItem("Kent","60"),
                new recyclerItem("Johny","64"),
                new recyclerItem("Daniel","??"),
                new recyclerItem("Alexander","??"),
                new recyclerItem("Markus","Snus"),
                new recyclerItem("András","Unknown")
        ));


        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, items,
                new RecyclerViewAdapter.OnClickListener() {
                    @Override
                    public void onClick(recyclerItem item) {
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        intent.putExtra("name", item.getName()); // Optional
                        intent.putExtra("age", item.getAge()); // Optional
                        startActivity(intent);
                    }
                });


        RecyclerView view = findViewById(R.id.recyclerMain);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);


    }

}




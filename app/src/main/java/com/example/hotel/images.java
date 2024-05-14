package com.example.hotel;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

public class images extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        button = findViewById(R.id.back11);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new cusmanu();
            }
        });
}}
package com.example.hotel;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class cusmanu extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cus_menu);

        button = findViewById(R.id.btnmemberlogout);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity();
            }
        });

        button = findViewById(R.id.btnroom);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serachBooks();
            }
        });
        button = findViewById(R.id.btnimg);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                images();
            }
        });

    }

    public void MainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void serachBooks(){
        Intent intent = new Intent(this, searchrooms.class);
        startActivity(intent);
    }
    public void images(){
        Intent intent = new Intent(this, images.class);
        startActivity(intent);
    }


}

package com.example.hotel;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class adminMenu extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);

        button = findViewById(R.id.btnlogout);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity();
            }
        });

        button = findViewById(R.id.btnaddingB);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manageBooks();
            }
        });


        button = findViewById(R.id.btnempadd);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addemplye();
            }
        });

        button = findViewById(R.id.btnlending);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {lendingroom();
            }
        });

        button = findViewById(R.id.viewem);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {vemplyee();
            }
        });

    }

    public void manageBooks(){
        Intent intent = new Intent(this, managerooms.class);
        startActivity(intent);
    }


    public void addemplye(){
        Intent intent = new Intent(this, employee.class);
        startActivity(intent);
    }

    public void lendingroom(){
        Intent intent = new Intent(this, lendingroom.class);
        startActivity(intent);
    }
    public void vemplyee(){
        Intent intent = new Intent(this, vemplyee.class);
        startActivity(intent);
    }

    public void MainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

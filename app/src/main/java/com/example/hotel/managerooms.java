package com.example.hotel;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class managerooms extends AppCompatActivity {

    Button button;
    private DBManager dbManager;

    EditText editText1, editText2, editText3,editText4,editText5;
    Button add;
    Button clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_room);

        button = findViewById(R.id.btnback3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adminMenu();
            }
        });

        dbManager= new DBManager(this);

        dbManager.open();

        add = findViewById(R.id.btnbookadd);
        clear =  findViewById(R.id.btndelete);
        editText1 =  findViewById(R.id.rID);
        editText2 =  findViewById(R.id.bcount);
        editText3 = findViewById(R.id.price);
        editText4 = findViewById(R.id.tavai);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean valid = true;

                if (editText1.getText().toString().isEmpty() || editText2.getText().toString().isEmpty()||
                        editText3.getText().toString().isEmpty()||editText4.getText().toString().isEmpty()) {

                    Toast.makeText(getApplicationContext(), "Fields can't be null", Toast.LENGTH_LONG).show();
                    valid = false;
                }
                if(valid) {

                    String roomID = editText1.getText().toString();
                    String Bedcount = editText2.getText().toString();
                    String price = editText3.getText().toString();
                    String availability = editText4.getText().toString();

                    dbManager.insert("insert into room values('" + roomID + "','" +
                             Bedcount + "','" + price + "','" + availability + "')");
                    Toast.makeText(getApplicationContext(), "Successfully Inserted", Toast.LENGTH_SHORT).show();
                    Log.e("first","Inserted");
                    dbManager.close();
                }

                else
                {
                    Toast.makeText(getApplicationContext(), "Error in Book Adding", Toast.LENGTH_SHORT).show();
                }

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editText1.getText().clear();
                editText2.getText().clear();
                editText3.getText().clear();
                editText4.getText().clear();
                editText5.getText().clear();

                Toast.makeText(getApplicationContext(),
                        "Your Successfully Deleted", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void adminMenu(){
        Intent intent = new Intent(this, adminMenu.class);
        startActivity(intent);
    }
}

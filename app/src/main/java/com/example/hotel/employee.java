package com.example.hotel;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class employee extends AppCompatActivity {

    Button button;
    private DBManager dbManager;

    EditText editText1, editText2, editText3;
    Button addbranch;
    Button clearbranch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_emp);

        button = findViewById(R.id.btnback5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adminMenu();
            }
        });

        final DBManager dbManager;
        dbManager = new DBManager(this);

        dbManager.open();

        addbranch = findViewById(R.id.empadd);
        clearbranch =  findViewById(R.id.empclear);
        editText1 =  findViewById(R.id.empidi);
        editText2 =  findViewById(R.id.empnamei);
        editText3 = findViewById(R.id.empconi);

        addbranch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean valid = true;

                if (editText1.getText().toString().isEmpty() || editText2.getText().toString().isEmpty()||
                        editText3.getText().toString().isEmpty()) {

                    Toast.makeText(getApplicationContext(), "Fields can't be null", Toast.LENGTH_LONG).show();
                    valid = false;
                }
                if(valid) {

                    String empID = editText1.getText().toString();
                    String Name = editText2.getText().toString();
                    String contact = editText3.getText().toString();


                    dbManager.insert("insert into employee values('" + empID + "','" + Name + "'," +
                             contact + "')");
                    Toast.makeText(getApplicationContext(), "Successfully Inserted", Toast.LENGTH_SHORT).show();
                    Log.e("first","Inserted");
                    dbManager.close();
                }

                else
                {
                    Toast.makeText(getApplicationContext(), "Error in Branch Adding", Toast.LENGTH_SHORT).show();
                }

            }
        });

        clearbranch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editText1.getText().clear();
                editText2.getText().clear();
                editText3.getText().clear();

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

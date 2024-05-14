package com.example.hotel;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class lendingroom extends AppCompatActivity {

    Button button;
    private DBManager dbManager;

    EditText editText1, editText2, editText3, editText4,editText5;
    Button addLendingroom;
    Button clearLendingroom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lending);

        button = findViewById(R.id.btnback6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adminMenu();
            }
        });

        dbManager= new DBManager(this);

        dbManager.open();

        addLendingroom = findViewById(R.id.btnAddLend);
        clearLendingroom =  findViewById(R.id.btnDeleteLend);
        editText1 =  findViewById(R.id.txtBranchIDBook);
        editText2 =  findViewById(R.id.txtCusnb);
        editText3 = findViewById(R.id.txtDateout);
        editText4 = findViewById(R.id.txtDaeDue);
        editText5 = findViewById(R.id.txtDateReturn);

        addLendingroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean valid = true;

                if (editText1.getText().toString().isEmpty() || editText2.getText().toString().isEmpty()||
                        editText3.getText().toString().isEmpty() || editText4.getText().toString().isEmpty() ||
                        editText5.getText().toString().isEmpty()) {

                    Toast.makeText(getApplicationContext(), "Fields can't be null", Toast.LENGTH_LONG).show();
                    valid = false;
                }
                if(valid) {

                    String roomID = editText1.getText().toString();
                    String cusNo = editText2.getText().toString();
                    String DateOut = editText3.getText().toString();
                    String DateDue = editText4.getText().toString();
                    String DateReturned = editText5.getText().toString();


                    dbManager.insert("insert into roomhire values(?,'" + roomID + "','" + cusNo + "'," +
                            "'" + DateOut + "','" + DateDue + "','" + DateReturned + "')");
                    Toast.makeText(getApplicationContext(), "Successfully Inserted", Toast.LENGTH_SHORT).show();
                    Log.e("first","Inserted");
                    String updateQuery = "UPDATE room SET availability = 0 WHERE roomID = ?";
                    dbManager.execSQL(updateQuery, new String[]{roomID});
                    dbManager.close();

                }

                else
                {
                    Toast.makeText(getApplicationContext(), "Error in lend room Adding", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void adminMenu(){
        Intent intent = new Intent(this, adminMenu.class);
        startActivity(intent);
    }
}

package com.example.hotel;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.core.view.MenuItemCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.hotel.databinding.ActivityVemplyeeBinding;

import java.util.ArrayList;

public class vemplyee extends AppCompatActivity {


    DatabaseHelper db;

    ListView userlist;

    ArrayList<String> listItem;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vemplyee);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Check employees");

        db = new DatabaseHelper(this);
        listItem = new ArrayList<>();

        DBManager dbManager = new DBManager(this);

        userlist = findViewById(R.id.users_list);
        viewemp();
        userlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = userlist.getItemAtPosition(position).toString();
                Intent intent = new Intent(vemplyee.this, vemplyee.class);
                startActivity(intent);
                Toast.makeText(vemplyee.this, "" + text, Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void viewemp() {
        Cursor cursor = db.viewData();

        if (cursor.getCount() == 0) {
            Toast.makeText(this, "NO DATA TO SHOW", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                listItem.add("emp ID: " + cursor.getString(0) + '\n' +
                        "Name: " + cursor.getString(1) + '\n' +
                        "contact: " + cursor.getString(2) + '\n'
                );
            }
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItem);
            userlist.setAdapter(adapter);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<String> userslist = new ArrayList<>();
                for (String user : listItem) {
                    if (user.toLowerCase().contains(newText.toLowerCase())) {
                        userslist.add(user);
                    }
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(vemplyee.this,
                        android.R.layout.simple_expandable_list_item_1, userslist);
                userlist.setAdapter(adapter);
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

}
